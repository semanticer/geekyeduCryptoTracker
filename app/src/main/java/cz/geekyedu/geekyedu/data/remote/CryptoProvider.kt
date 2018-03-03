package cz.geekyedu.geekyedu.data.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object CryptoProvider {
    val cryptoService: CryptoService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.coinmarketcap.com/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(CryptoService::class.java)
    }

}