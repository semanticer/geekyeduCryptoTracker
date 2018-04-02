package cz.geekyedu.geekyedu.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.view.isVisible
import cz.geekyedu.geekyedu.R
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import cz.geekyedu.geekyedu.presentation.utils.CryptoIconHelper
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val singleTestCrypto = CryptoCurrency("bitcoin", "Bitcoin", "BTC", 7032.50)
        bindTo(singleTestCrypto)
        progressView.isVisible = false
    }

    private fun bindTo(model: CryptoCurrency) {
        val nameText = "${model.symbol} | ${model.name}"
        nameView.text = nameText

        // TODO show price from model in correct textView

        // TODO set percentages with plus or minus color from resources

        val iconUrl = CryptoIconHelper.getIconUrl(model.id)
        // TODO show icon from iconUrl using GlideApp
    }
}


