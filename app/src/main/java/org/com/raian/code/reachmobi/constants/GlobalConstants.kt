package org.com.raian.code.reachmobi.constants

class GlobalConstants {

    companion object {
        const val nflBaseUrl = "https://armchairanalysis.com/api/1.0/"

        //Constants for saving RoomDB
        const val dataBaseName = "teams_database.db"
        const val dataBaseVersion = 2

        //TODO: Make this a list of pairs<>
        val mapOfTeams = mapOf(
            "ARI" to "nfl_arizona_cardinals",//ARI
            "ATL" to "nfl_atlanta_falcons",//ATL
            "BAL" to "nfl_baltimore_ravens",//BAL
            "BUF" to "nfl_buffalo_bills",//BUF
            "CAR" to "nfl_carolina_panthers",//CAR
            "CHI" to "nfl_chicago_bears",//CHI
            "CIN" to "nfl_cincinnati_bengals",//CIN
            "CLE" to "nfl_cleveland_browns",//CLE
            "DAL" to "nfl_dallas_cowboys",//DAL
            "DEN" to "nfl_denver_broncos",//DEN
            "DET" to "nfl_detroit_lions",//DET
            "GB" to "nfl_green_bay_packers",//GB
            "HOU" to "nfl_houston_texans",//HOU
            "IND" to "nfl_indianapolis_colts",//IND
            "JAX" to "nfl_jacksonville_jaguars",//JAX
            "KAC" to "nfl_kansas_city_chiefs",//KAC
            "LAC" to "nfl_los_angeles_chargers",//LAC
            "LA" to "nfl_los_angeles_rams",//LA
            "MIA" to "nfl_miami_dolphins",//MIA
            "MIN" to "nfl_minnesota_vikings",//MIN
            "NE" to "nfl_new_england_patriots",//NE
            "NO" to "nfl_new_orleans_saints",//NO
            "NYG" to "nfl_new_york_giants",//NYG
            "NYJ" to "nfl_new_york_jets",//NYJ
            "OAK" to "nfl_oakland_raiders",//OAK
            "PHI" to "nfl_philadelphia_eagles",//PHI
            "PIT" to "nfl_pittsburgh_steelers",//PIT
            "SF" to "nfl_san_francisco_49ers",//SF
            "SEA" to "nfl_seattle_seahawks",//SEA
            "TB" to "nfl_tampa_bay_buccaneers",//TB
            "TEN" to "nfl_tennessee_titans",//TEN
            "WAS" to "nfl_washington_redskins"//WAS
        )
    }

}