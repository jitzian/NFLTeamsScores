package org.com.raian.code.reachmobi.ui.showTeams.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.com.raian.code.reachmobi.constants.GlobalConstants.Companion.mapOfCityImages
import org.com.raian.code.reachmobi.databinding.CardViewTeamStatsBinding
import org.com.raian.code.reachmobi.ui.model.TeamDataUI
import org.com.raian.code.reachmobi.ui.showTeams.viewmodel.ShowTeamsViewModel
import java.util.*
import java.util.logging.Logger
import kotlin.collections.ArrayList

class RVShowTeamsAdapter: RecyclerView.Adapter<RVShowTeamsAdapter.ViewHolder>(){
    private val TAG = RVShowTeamsAdapter::class.java.simpleName
    private val logger = Logger.getLogger(TAG)
    private var lstRes = ArrayList<TeamDataUI>()
    private var mapOfElements = WeakHashMap<String, TeamDataUI>()
    private val searchableList = ArrayList<TeamDataUI>()

    private val showTeamsViewModel by lazy {
        ShowTeamsViewModel()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardViewTeamStatsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return lstRes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        lstRes[position].let {
            holder.bind(it)
        }
    }

    inner class ViewHolder(val binding: CardViewTeamStatsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: TeamDataUI){
            binding.mTextViewStatsTeamName.text = item.teamId
            binding.mTextViewTeamStatsSeasonValue.text = item.teamData?.get(0)?.season.toString()
            binding.mTextViewTeamStatsWeekValue.text = item.teamData?.get((0))?.weekNumber.toString()
            binding.mTextViewTeamStatsStadiumValue.text = item.teamData?.get(0)?.stadiumName
            Picasso.get()
                .load(mapOfCityImages[item.teamId])
                .into(binding.mImageViewCity)
        }
    }

    fun removeAt(position: Int) {
        logger.info("$TAG::removeAt::Deleting from View::${position}::${lstRes[position].teamId}")
        showTeamsViewModel.clearDataAndSelection(lstRes[position].teamId.toString())
        updateMapWithNewListOfElements(lstRes[position].teamId.toString())
        notifyItemRemoved(position)
    }

    fun setTeamStats(lstStats: List<TeamDataUI>){
        lstRes = lstStats as ArrayList<TeamDataUI>
        loadMapWithListOfElements()
        notifyDataSetChanged()
    }

    private fun loadMapWithListOfElements(){
        for(i in lstRes){
            mapOfElements[i.teamId] = i
        }
    }

    private fun updateMapWithNewListOfElements(teamIdTobeRemoved: String){
        mapOfElements.remove(teamIdTobeRemoved)
        lstRes.clear()
        mapOfElements.values.forEach {
            lstRes.add(it)
        }
    }

    interface Searchable {
        /** This method will allow to specify a search string to compare against
        your search this can be anything depending on your use case.
         */
        fun getSearchCriteria(): String
    }
}

