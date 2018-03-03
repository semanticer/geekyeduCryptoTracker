package cz.geekyedu.geekyedu.presentation.utils


object CryptoIconHelper {
    fun getIconUrl(cryptoIdString: String): String = when(cryptoIdString) {
        "bitcoin" -> "https://res.cloudinary.com/da7jhtpgh/image/upload/v1508609483/bitcoin_eqld4v.png"
        "ethereum" -> "https://res.cloudinary.com/da7jhtpgh/image/upload/v1508609485/ethereum_nw0chu.png"
        "ripple" -> "https://res.cloudinary.com/da7jhtpgh/image/upload/v1508609486/ripple_p0xeut.png"
        "bitcoin-cash" -> "https://res.cloudinary.com/da7jhtpgh/image/upload/v1516327336/bch_2x_hahroi.png"
        "litecoin" -> "https://res.cloudinary.com/da7jhtpgh/image/upload/v1512427497/ltc_fjbqjf.png"
        "neo" -> "https://res.cloudinary.com/da7jhtpgh/image/upload/v1508609486/neo_fvoo6c.png"
        "cardano" -> "https://res.cloudinary.com/da7jhtpgh/image/upload/v1513434489/cardano_unympj.png"
        "stellar" -> "https://res.cloudinary.com/da7jhtpgh/image/upload/v1516326886/xlm_2x_jfwlwt.png"
        "eos" -> "https://res.cloudinary.com/da7jhtpgh/image/upload/v1516326878/eos_2x_dvr7p0.png"
        "monero" -> "https://res.cloudinary.com/da7jhtpgh/image/upload/v1508609486/monero_wzk3ur.png"
        else -> "unknownUrl"
    }
}

