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
    val cryptoAmountEditDialog = MutableLiveData<CryptoCurrency?>()

    init {
        loadingVisibility.value = false
        cryptoAmountEditDialog.value = null
        if (cryptoList.value == null) {
            loadCryptoList()
        }
    }

    fun onCryptoItemSelected(cryptoCurrency: CryptoCurrency) {
        cryptoAmountEditDialog.value = cryptoCurrency
    }

    fun onCryptoAmountEntered(cryptoCurrency: CryptoCurrency, amount: Double) {
        Log.i("onCryptoAmountEntered", "${cryptoCurrency.name} => $amount")
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