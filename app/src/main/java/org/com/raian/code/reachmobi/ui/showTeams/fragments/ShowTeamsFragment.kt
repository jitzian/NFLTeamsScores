package org.com.raian.code.reachmobi.ui.showTeams.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.com.raian.code.reachmobi.R
import org.com.raian.code.reachmobi.databinding.FragmentShowTeamsBinding
import org.com.raian.code.reachmobi.ui.addTeams.fragments.AddTeamsFragment
import org.com.raian.code.reachmobi.ui.base.BaseFragment
import java.util.logging.Logger

class ShowTeamsFragment : BaseFragment() {

    private lateinit var binding: FragmentShowTeamsBinding

    init{
        TAG = ShowTeamsFragment::class.java.simpleName
        logger = Logger.getLogger(TAG)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentShowTeamsBinding.inflate(inflater, container, false)
        initView()
        return rootView
    }


    override fun initView() {
        rootView = binding.root
        binding.lifecycleOwner = this
        binding.showTeamsFragment = this
        binding.showTeamsViewModel = showTeamsViewModel

        showTeamsViewModel.getResultsByTeam("DAL")
    }

    fun goToTeams(v: View){
        logger.severe("$TAG::goToTeams::${v::class.java}")
        fragmentManager?.beginTransaction()
            ?.replace(R.id.mFrameLayoutAddTeamContainer, AddTeamsFragment(), AddTeamsFragment::class.java.simpleName)
            ?.commit()
    }

}
