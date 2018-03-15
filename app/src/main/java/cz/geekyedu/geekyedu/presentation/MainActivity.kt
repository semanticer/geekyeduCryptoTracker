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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup recyclerView
        val cryptoAdapter = CryptoAdapter()
        val viewManager = LinearLayoutManager(this)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = cryptoAdapter
        }

        // setup view model observers and listeners
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        cryptoAdapter.onItemListener = { viewModel.onCryptoItemSelected(it) }
        viewModel.cryptoList.observe(this, Observer {
            list -> list?.let { cryptoAdapter.submitList(it) }
        })
        viewModel.loadingVisibility.observe(this, Observer {
            isVisible -> progressView.isVisible = isVisible ?: false
        })
    }
}

