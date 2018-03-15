package cz.geekyedu.geekyedu.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import cz.geekyedu.geekyedu.data.remote.CryptoService
import cz.geekyedu.geekyedu.presentation.utils.setEnqueue
import retrofit2.Call

class MainViewModel : ViewModel() {

    val cryptoList = MutableLiveData<List<CryptoCurrency>>()
    val loadingVisibility = MutableLiveData<Boolean>()

    init {
        loadingVisibility.value = false
        if (cryptoList.value == null) {
            loadCryptoList()
        }
    }

    fun onCryptoItemSelected(cryptoCurrency: CryptoCurrency) {
        Log.i("onCryptoItemSelected", cryptoCurrency.name)
    }

    private fun loadCryptoList() {
        loadingVisibility.value = true
        val cryptoListRequest: Call<List<CryptoCurrency>> = CryptoService.instance.cryptoList(10)
        cryptoListRequest.setEnqueue(
                onResponse = { call, response ->
                    if (response.isSuccessful) {
                        cryptoList.value = response.body()
                    }
                    loadingVisibility.value = false
                },
                onFailure = { call, t -> loadingVisibility.value = false }
        )
    }
}