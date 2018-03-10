package cz.geekyedu.geekyedu.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import androidx.view.isVisible
import cz.geekyedu.geekyedu.R
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import cz.geekyedu.geekyedu.data.remote.CryptoProvider
import cz.geekyedu.geekyedu.presentation.utils.setEnqueue
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call


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
        loadData(10)
    }

    private fun loadData(limit: Int) {
        progressView.isVisible = true
        val cryptoListRequest: Call<List<CryptoCurrency>> = CryptoProvider.cryptoService.cryptoList(limit)
        cryptoListRequest.setEnqueue(
                onResponse = { call, response ->
                    if (response.isSuccessful) {
                        val cryptoCurrencyList = response.body()!!
                        cryptoAdapter.submitList(cryptoCurrencyList)
                    } else {
                        showRemoteError()
                    }
                    progressView.isVisible = false
                },
                onFailure = { call, t ->
                    showRemoteError()
                    progressView.isVisible = false
                }
        )
    }


    private fun showRemoteError() {
        Toast.makeText(this, R.string.network_error, Toast.LENGTH_LONG).show()

    }
}
