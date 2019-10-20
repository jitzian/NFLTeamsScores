package org.com.raian.code.reachmobi.model.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class TeamDataClass(
    @ColumnInfo(name = "teamName") var teamName: String? = null,
    @ColumnInfo(name = "isSelected") var isSelected: Boolean = false,
    @ColumnInfo(name = "teamLogo") var teamLogo: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}