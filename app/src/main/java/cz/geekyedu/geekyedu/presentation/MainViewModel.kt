package cz.geekyedu.geekyedu.presentation

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.os.AsyncTask
import cz.geekyedu.geekyedu.data.db.CryptoCurrencyAmount
import cz.geekyedu.geekyedu.data.db.CryptoDataBase
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import cz.geekyedu.geekyedu.data.remote.CryptoService
import cz.geekyedu.geekyedu.presentation.utils.map
import cz.geekyedu.geekyedu.presentation.utils.setEnqueue
import cz.geekyedu.geekyedu.presentation.utils.zipLiveData
import retrofit2.Call


class MainViewModel(app: Application) : AndroidViewModel(app) {

    val loadingVisibility = MutableLiveData<Boolean>()
    val cryptoAmountEditDialog = MutableLiveData<CryptoCurrency>()
    val cryptoList by lazy { loadCryptoList() }
    val cryptoTotal by lazy {
        zipLiveData(cryptoCurrencyDao.getAll(), cryptoList).map { (amounts, listCurrencies) ->
            fun getCryptoPrice(cryptoId: String) = listCurrencies.find { crypto -> crypto.id == cryptoId }!!.priceUsd
            amounts.map { getCryptoPrice(it.id) * it.amount }.sum()
        }
    }
    private val cryptoCurrencyDao by lazy { CryptoDataBase.getInstance(getApplication())!!.cryptoCurrencyDao() }

    init {
        loadingVisibility.value = false
        cryptoAmountEditDialog.value = null
    }

    fun onCryptoItemSelected(cryptoCurrency: CryptoCurrency) {
        cryptoAmountEditDialog.value = cryptoCurrency
    }

    fun onCryptoAmountEntered(cryptoCurrency: CryptoCurrency, amount: Double) {
        AsyncTask.execute {
            cryptoCurrencyDao.insert(CryptoCurrencyAmount(cryptoCurrency.id, amount))
        }
    }

    private fun loadCryptoList(): MutableLiveData<List<CryptoCurrency>> {
        val liveData = MutableLiveData<List<CryptoCurrency>>()
        loadingVisibility.value = true
        val cryptoListRequest: Call<List<CryptoCurrency>> = CryptoService.instance.cryptoList(10)
        cryptoListRequest.setEnqueue(
                onResponse = { call, response ->
                    if (response.isSuccessful) {
                        liveData.value = response.body()
                    }
                    loadingVisibility.value = false
                },
                onFailure = { call, t -> loadingVisibility.value = false }
        )
        return liveData
    }
}