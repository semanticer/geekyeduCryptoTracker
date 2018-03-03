package cz.geekyedu.geekyedu.data.remote

import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface CryptoService {
    @GET("ticker/")
    fun cryptoList(@Query("limit") limit: Int): Call<List<CryptoCurrency>>
}