package cz.geekyedu.geekyedu.data.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity
class CryptoCurrencyAmount(
        @NonNull @PrimaryKey(autoGenerate = false) var id: String,
        @ColumnInfo var amount: Double
)
