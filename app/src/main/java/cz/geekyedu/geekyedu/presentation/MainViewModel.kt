package cz.geekyedu.geekyedu.presentation

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import cz.geekyedu.geekyedu.data.model.CryptoCurrency


class MainViewModel(app: Application) : AndroidViewModel(app) {

    val loadingVisibility = MutableLiveData<Boolean>()
    val cryptoList: MutableLiveData<List<CryptoCurrency>> by lazy { /* Return liveData with List<CryptoCurrency>  */ }

}