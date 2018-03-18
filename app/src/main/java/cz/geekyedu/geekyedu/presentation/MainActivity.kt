package cz.geekyedu.geekyedu.presentation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.InputType
import android.widget.Toast
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
            cryptoAdapter.onItemListener = { onCryptoItemSelected(it) }
            cryptoList.observe(this@MainActivity, Observer {   list ->
                list?.let { cryptoAdapter.submitList(it) }
            })
            loadingVisibility.observe(this@MainActivity, Observer { isVisible ->
                progressView.isVisible = isVisible ?: false
            })
            cryptoAmountEditDialog.observe(this@MainActivity, Observer { crypto ->
                if (crypto != null) {
                    showInputDialog(crypto)
                } else dismissDialog()
            })
        }
    }

    private fun showInputDialog(cryptoCurrency: CryptoCurrency) {
        dialog = MaterialDialog.Builder(this)
                .title(cryptoCurrency.name)
                .inputType(InputType.TYPE_NUMBER_FLAG_SIGNED)
                .input(getString(R.string.your_amount_of) + " ${cryptoCurrency.symbol}", "", { dialog, input ->
                    val amount = try { input.toString().toDouble() } catch (e: NumberFormatException) { null }
                    if (amount != null) {
                        viewModel.onCryptoAmountEntered(cryptoCurrency, amount)
                    } else {
                        Toast.makeText(this, R.string.amount_format_error, Toast.LENGTH_LONG).show()
                    }
                })
                .build()
        dialog?.apply { show() }
    }
    private fun dismissDialog() {
        dialog?.takeUnless { it.isCancelled }
                ?.apply { dismiss() }
    }

}


