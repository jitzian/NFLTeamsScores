package org.com.raian.code.reachmobi.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import org.com.raian.code.reachmobi.model.database.model.TeamDataClass

@Dao
interface TeamDao {
    @Insert(onConflict = REPLACE)
    fun insert(teamDataClass: TeamDataClass)

    @Update
    fun update(teamDataClass: TeamDataClass)

    @Query("SELECT * FROM team ORDER BY id ASC")
//    fun getAll(): LiveData<List<TeamDataClass>>
    fun getAll(): List<TeamDataClass>


    @Query("SELECT * FROM team WHERE isSelected = :status ORDER BY teamName ASC")
    fun getAllByStatus(status: Boolean): LiveData<List<TeamDataClass>>

    @Query("SELECT * FROM team WHERE teamName = :teamName")
    fun getByTeamName(teamName: String): LiveData<TeamDataClass>
}