package cz.geekyedu.geekyedu.data.model

// TODO add percentChange24h and percentChange7d Doubles
data class CryptoCurrency (
        val id: String,
        val name: String,
        val symbol: String,
        val priceUsd: Double
)