package org.com.raian.code.reachmobi.model.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teamStatistics")
data class TeamStatistics(
    @ColumnInfo(name = "teamId") var teamId: String? = null,
    @ColumnInfo(name = "gid") var gid: Int = 0,
    @ColumnInfo(name = "seas") var seas: Int = 0,
    @ColumnInfo(name = "wk") var wk: Int = 0,
    @ColumnInfo(name = "day") var day: String? = null,
    @ColumnInfo(name = "v") var v: String? = null,
    @ColumnInfo(name = "h") var h: String? = null,
    @ColumnInfo(name = "stad") var stad: String? = null,
    @ColumnInfo(name = "temp") var temp: String? = null,
    @ColumnInfo(name = "humd") var humd: String? = null,
    @ColumnInfo(name = "wspd") var wspd: String? = null,
    @ColumnInfo(name = "wdir") var wdir: String? = null,
    @ColumnInfo(name = "cond") var cond: String? = null,
    @ColumnInfo(name = "surf") var surf: String? = null,
    @ColumnInfo(name = "ou") var ou: String? = null,
    @ColumnInfo(name = "sprv") var sprv: String? = null,
    @ColumnInfo(name = "ptsv") var ptsv: Int = 0,
    @ColumnInfo(name = "ptsh") var ptsh: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}