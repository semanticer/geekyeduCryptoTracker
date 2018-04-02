package cz.geekyedu.geekyedu.data.remote

interface CryptoService {

    // TODO define ticker method with a limit parameter from https://coinmarketcap.com/api/
    // TODO retrofit documentation http://square.github.io/retrofit/

    companion object {
        val instance: CryptoService by lazy {
            TODO("use lazy delegation to create CryptoService when it's needed with baseUrl https://api.coinmarketcap.com/v1/ and ConverterFactory")
        }
    }
}