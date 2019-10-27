package org.com.raian.code.reachmobi.model.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import org.com.raian.code.reachmobi.model.database.model.TeamStatistics

@Dao
interface TeamStatisticsDao{
    @Insert(onConflict = REPLACE)
    fun insert(teamStatistics: TeamStatistics)

    @Update
    fun update(teamStatistics: TeamStatistics)

    @Query("SELECT DISTINCT * FROM teamStatistics WHERE teamId = :teamId")
    fun getAllByTeamId(teamId: String): List<TeamStatistics>

    @Query("DELETE FROM teamStatistics")
    fun deleteAll()

    @Query("DELETE FROM teamStatistics WHERE teamId = :teamId")
    fun deleteByTeamId(teamId: String)
}