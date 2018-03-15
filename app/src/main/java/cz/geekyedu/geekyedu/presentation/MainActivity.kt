package cz.geekyedu.geekyedu.presentation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import androidx.view.isVisible
import cz.geekyedu.geekyedu.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var cryptoAdapter: CryptoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cryptoAdapter = CryptoAdapter()
        val viewManager = LinearLayoutManager(this)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = cryptoAdapter
        }

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.cryptoList.observe(this, Observer {
            list -> list?.let { cryptoAdapter.submitList(it) }
        })
        viewModel.loadingVisibility.observe(this, Observer {
            isVisible -> progressView.isVisible = isVisible ?: false
        })
    }
}

