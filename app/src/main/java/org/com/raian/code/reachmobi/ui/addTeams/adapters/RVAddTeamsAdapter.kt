package org.com.raian.code.reachmobi.ui.addTeams.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.com.raian.code.reachmobi.databinding.CardViewTeamBinding
import org.com.raian.code.reachmobi.model.database.model.TeamDataClass
import org.com.raian.code.reachmobi.ui.addTeams.viewmodel.AddTeamsViewModel
import org.com.raian.code.reachmobi.utility.getDrawableByName
import java.util.logging.Logger

class RVAddTeamsAdapter : RecyclerView.Adapter<RVAddTeamsAdapter.ViewHolder>() {
    private val TAG = RVAddTeamsAdapter::class.java.simpleName
    private val logger = Logger.getLogger(TAG)

    private var lstRes = ArrayList<TeamDataClass>()
    private val addTeamsViewModel by lazy {
        AddTeamsViewModel()
    }

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

            binding.mCheckBoxTeamToShow.setOnCheckedChangeListener(null)
            binding.mCheckBoxTeamToShow.isChecked = item.isSelected
            binding.mCheckBoxTeamToShow.setOnCheckedChangeListener { _, isChecked ->
                item.isSelected = isChecked
                addTeamsViewModel.saveTeam(item)
            }

            binding.mImageViewTeamIcon.setImageDrawable(getDrawableByName("${item.teamName}"))
        }
    }

    fun setTeams(lstTeams: List<TeamDataClass>) {
        lstRes = lstTeams as ArrayList<TeamDataClass>
        notifyDataSetChanged()
    }

}