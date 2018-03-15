package cz.geekyedu.geekyedu.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [(CryptoCurrencyAmount::class)], version = 1)
abstract class CryptoDataBase : RoomDatabase() {

    abstract fun cryptoCurrencyDao(): CryptoCurrencyDao

    companion object {
        private var INSTANCE: CryptoDataBase? = null

        fun getInstance(context: Context): CryptoDataBase? {
            if (INSTANCE == null) {
                synchronized(CryptoDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            CryptoDataBase::class.java, "cryptodb.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}