package cz.geekyedu.geekyedu.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import androidx.view.isVisible
import cz.geekyedu.geekyedu.R
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import cz.geekyedu.geekyedu.data.remote.CryptoService
import cz.geekyedu.geekyedu.presentation.utils.CryptoIconHelper
import cz.geekyedu.geekyedu.presentation.utils.GlideApp
import cz.geekyedu.geekyedu.presentation.utils.setEnqueue
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFirstCrypto()
    }

    private fun loadFirstCrypto() {
        progressView.isVisible = true
        val cryptoListRequest: Call<List<CryptoCurrency>> = CryptoService.instance.cryptoList(1)
        cryptoListRequest.setEnqueue(
                onResponse = { call, response ->
                    if (response.isSuccessful) {
                        val crypto = response.body()!![0]
                        bindTo(crypto)
                    }
                    progressView.isVisible = false
                },
                onFailure = { call, t -> progressView.isVisible = false }
        )
    }

    private fun bindTo(model: CryptoCurrency) {
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
        valueView.setTextColor(resources.getColor(textColor, null))
    }
}


