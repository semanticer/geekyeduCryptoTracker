package cz.geekyedu.geekyedu.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import cz.geekyedu.geekyedu.data.remote.CryptoProvider
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

    private fun loadCryptoList() {
        loadingVisibility.value = true
        val cryptoListRequest: Call<List<CryptoCurrency>> = CryptoProvider.cryptoService.cryptoList(10)
        cryptoListRequest.setEnqueue(
                onResponse = { call, response ->
                    if (response.isSuccessful) {
                        val cryptoCurrencyList = response.body()!!
                        cryptoList.value = cryptoCurrencyList
                    }
                    loadingVisibility.value = false
                },
                onFailure = { call, t -> loadingVisibility.value = false }
        )
    }
}