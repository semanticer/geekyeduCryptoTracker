package cz.geekyedu.geekyedu.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [(CryptoCurrencyAmount::class)], version = 1)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun cryptoCurrencyDao(): CryptoCurrencyDao

    companion object {
        private var INSTANCE: CryptoDatabase? = null

        fun getInstance(context: Context): CryptoDatabase {
            if (INSTANCE == null) {
                synchronized(CryptoDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            CryptoDatabase::class.java, "cryptodb.db")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}