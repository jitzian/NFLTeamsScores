package org.com.raian.code.reachmobi.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.com.raian.code.reachmobi.constants.GlobalConstants
import org.com.raian.code.reachmobi.model.database.dao.TeamDao
import org.com.raian.code.reachmobi.model.database.model.TeamDataClass

@Database(
    entities = [
        TeamDataClass::class
    ],
    version = GlobalConstants.dataBaseVersion,
    exportSchema = false
)
abstract class TeamsDataBase: RoomDatabase(){
    abstract fun teamDao(): TeamDao
}