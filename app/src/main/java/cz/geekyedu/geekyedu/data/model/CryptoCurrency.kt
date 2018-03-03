package cz.geekyedu.geekyedu.data.model

import com.squareup.moshi.Json

data class CryptoCurrency (
        val id: String,
        val name: String,
        val symbol: String,
        @Json(name = "price_usd") val priceUsd: Double,
        @Json(name = "percent_change_24h") val percentChange24h: Double,
        @Json(name = "percent_change_7d") val percentChange7d: Double
)