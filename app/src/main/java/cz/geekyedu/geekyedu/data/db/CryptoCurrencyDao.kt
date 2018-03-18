package cz.geekyedu.geekyedu.data.db

import android.arch.persistence.room.Dao

//TODO read about Room on https://developer.android.com/training/data-storage/room/index.html
//TODO or kotlin specific https://medium.com/mindorks/android-architecture-components-room-and-kotlin-f7b725c8d1d

@Dao
interface CryptoCurrencyDao {
    // TODO add getAll() method with @Query annotation to get all CryptoCurrencyAmounts

    // TODO add insert(cryptoCurrencyAmount: CryptoCurrencyAmount) with @Insert(onConflict = REPLACE) annotation
}