package cz.geekyedu.geekyedu.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [(CryptoCurrencyAmount::class)], version = 1)
abstract class CryptoDataBase : RoomDatabase() {
    abstract fun cryptoCurrencyDao(): CryptoCurrencyDao
}