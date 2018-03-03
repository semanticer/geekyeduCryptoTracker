package cz.geekyedu.geekyedu.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import cz.geekyedu.geekyedu.R
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import cz.geekyedu.geekyedu.data.remote.CryptoProvider
import cz.geekyedu.geekyedu.presentation.utils.CryptoIconHelper
import cz.geekyedu.geekyedu.presentation.utils.GlideApp
import cz.geekyedu.geekyedu.presentation.utils.setEnqueue
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cryptoListRequest: Call<List<CryptoCurrency>> = CryptoProvider.cryptoService.cryptoList(10)
        cryptoListRequest.setEnqueue(
                onResponse = {call, response ->
                    if (response.isSuccessful) {
                        val cryptoCurrency = response.body()!![0]
                        showModel(cryptoCurrency)
                    } else {
                        showRemoteError()
                    }
                },
                onFailure = {call, t -> showRemoteError() }
        )
    }

    private fun showModel(model: CryptoCurrency) {
        val nameText = "${model.symbol} | ${model.name}"
        val priceText = "$ ${model.priceUsd}"
        nameView.text = nameText
        priceView.text = priceText
        setPercentValue(model.percentChange24h, dayPercent)
        setPercentValue(model.percentChange7d, weekPercent)
        val iconUrl = CryptoIconHelper.getIconUrl(model.id)
        GlideApp
            .with(this)
            .load(iconUrl)
            .into(iconView)
    }

    private fun setPercentValue(percent: Double, valueView: TextView) {
        val percentText = "$percent%"
        valueView.text = percentText
        val textColor = if (percent >= 0 ) R.color.plus else R.color.minus
        valueView.setTextColor(getColor(textColor))
    }

    private fun showRemoteError() {
        Toast.makeText(this, R.string.network_error, Toast.LENGTH_LONG).show()

    }
}
