package org.com.raian.code.reachmobi.ui.addTeams.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.com.raian.code.reachmobi.databinding.CardViewTeamBinding
import org.com.raian.code.reachmobi.model.database.model.TeamDataClass
import org.com.raian.code.reachmobi.utility.getDrawableByName

class RVAddTeamsAdapter : RecyclerView.Adapter<RVAddTeamsAdapter.ViewHolder>() {

    private var lstRes = ArrayList<TeamDataClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardViewTeamBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return lstRes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        lstRes[position].let { holder.bind(it) }
    }

    inner class ViewHolder(private val binding: CardViewTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TeamDataClass) {
            binding.mTextViewTeamName.text = item.teamName
            binding.mCheckBoxTeamToShow.isChecked = item.isSelected
            binding.mImageViewTeamIcon.setImageDrawable(getDrawableByName("${item.teamName}"))
        }
    }

    fun setTeams(lstTeams: List<TeamDataClass>) {
        lstRes = lstTeams as ArrayList<TeamDataClass>
        notifyDataSetChanged()
    }

}