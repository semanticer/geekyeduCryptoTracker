package cz.geekyedu.geekyedu.presentation

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import androidx.view.isVisible
import cz.geekyedu.geekyedu.R
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import cz.geekyedu.geekyedu.data.remote.CryptoService
import cz.geekyedu.geekyedu.presentation.utils.setEnqueue
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var cryptoAdapter: CryptoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup recyclerView
        cryptoAdapter = CryptoAdapter()
        val viewManager = LinearLayoutManager(this)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = cryptoAdapter
        }

        // setup view model observers and listeners
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO observe liveData of progressView visibility and liveData of List<CryptoCurrency>

        loadCryptoList() // TODO remove this
    }

    // TODO this should be in viewModel now and distribute new data via LiveData stream to this activity
    private fun loadCryptoList() {
        progressView.isVisible = true
        val cryptoListRequest: Call<List<CryptoCurrency>> = CryptoService.instance.cryptoList(10)
        cryptoListRequest.setEnqueue(
                onResponse = { call, response ->
                    if (response.isSuccessful) {
                        cryptoAdapter.submitList(response.body())
                    }
                    progressView.isVisible = false
                },
                onFailure = { call, t -> progressView.isVisible = false }
        )
    }
}


