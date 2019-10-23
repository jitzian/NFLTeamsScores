package org.com.raian.code.reachmobi.ui.showTeams.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.com.raian.code.reachmobi.databinding.CardViewTeamStatsBinding
import org.com.raian.code.reachmobi.model.database.model.TeamDataClass
import java.util.logging.Logger

class RVShowTeamsAdapter: RecyclerView.Adapter<RVShowTeamsAdapter.ViewHolder>() {
    private val TAG = RVShowTeamsAdapter::class.java.simpleName
    private val logger = Logger.getLogger(TAG)
    private var lstRes = ArrayList<TeamDataClass>()

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
        fun bind(item: TeamDataClass){
            binding.mTextViewStatsTeamName.text = item.teamName
        }
    }

    fun setTeamStats(lstStats: List<TeamDataClass>){
        lstRes = lstStats as ArrayList<TeamDataClass>

    }

}