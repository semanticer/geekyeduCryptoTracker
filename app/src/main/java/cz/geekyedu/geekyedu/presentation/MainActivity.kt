package cz.geekyedu.geekyedu.presentation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import androidx.view.isVisible
import com.afollestad.materialdialogs.MaterialDialog
import cz.geekyedu.geekyedu.R
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var dialog: MaterialDialog? = null

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
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.apply {
            // TODO set adapter's onItemListener property
            cryptoList.observe(this@MainActivity, Observer {   list ->
                list?.let { cryptoAdapter.submitList(it) }
            })
            loadingVisibility.observe(this@MainActivity, Observer { isVisible ->
                progressView.isVisible = isVisible ?: false
            })
            // TODO observe amount edit dialog and show or dismiss dialog based on that
        }
    }

    private fun showInputDialog(cryptoCurrency: CryptoCurrency) {
        dialog = TODO("Build input dialog https://github.com/afollestad/material-dialogs#input-dialogs")

        dialog?.apply { show() }
    }
    private fun dismissDialog() {
        dialog?.takeUnless { it.isCancelled }
                ?.apply { dismiss() }
    }

}


