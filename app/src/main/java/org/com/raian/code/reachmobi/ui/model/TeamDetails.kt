package org.com.raian.code.reachmobi.ui.model

data class TeamDetails(
    var gameId: Int? = 0,
    var season: Int? = 0,
    var weekNumber: Int? = 0,
    var dayOfWeek: String? = null,
    var visitingTeam: String? = null,
    var homeTeam: String? = null,
    var stadiumName: String? = null
)