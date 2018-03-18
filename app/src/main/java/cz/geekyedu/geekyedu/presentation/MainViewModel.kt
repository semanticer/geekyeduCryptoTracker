package cz.geekyedu.geekyedu.presentation

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import cz.geekyedu.geekyedu.data.remote.CryptoService
import cz.geekyedu.geekyedu.presentation.utils.setEnqueue
import retrofit2.Call


class MainViewModel(app: Application) : AndroidViewModel(app) {

    val loadingVisibility = MutableLiveData<Boolean>()
    val cryptoList by lazy { loadCryptoList() }
    // TODO add edit dialog LiveData with CryptoCurrency that should be edited


    fun onCryptoItemSelected(cryptoCurrency: CryptoCurrency) {
        // TODO change dialog live data to provide this selected Crypto currency
    }

    fun onCryptoAmountEntered(cryptoCurrency: CryptoCurrency, amount: Double) {
        Log.i("MainViewModel", "cryptoCurrency: ${cryptoCurrency.name} amount: $amount")
    }

    private fun loadCryptoList(): MutableLiveData<List<CryptoCurrency>> {
        val liveData = MutableLiveData<List<CryptoCurrency>>()
        showLoading()
        val cryptoListRequest: Call<List<CryptoCurrency>> = CryptoService.instance.cryptoList(10)
        cryptoListRequest.setEnqueue(
                onResponse = { call, response ->
                    if (response.isSuccessful) {
                        liveData.value = response.body()
                    }
                    hideLoading()
                },
                onFailure = { call, t -> hideLoading() }
        )
        return liveData
    }

    private fun showLoading() { loadingVisibility.value = true }
    private fun hideLoading() { loadingVisibility.value = false }
}