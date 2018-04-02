package cz.geekyedu.geekyedu.data.model

data class CryptoCurrency (
        val id: String,
        val name: String,
        val symbol: String,
        val priceUsd: Double,
        val percentChange24h: Double,
        val percentChange7d: Double
)