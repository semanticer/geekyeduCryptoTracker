package cz.geekyedu.geekyedu.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface CryptoCurrencyDao {
    @Query("SELECT * from CryptoCurrencyAmount")
    fun getAll(): LiveData<List<CryptoCurrencyAmount>>

    @Insert(onConflict = REPLACE)
    fun insert(cryptoCurrencyAmount: CryptoCurrencyAmount)
}