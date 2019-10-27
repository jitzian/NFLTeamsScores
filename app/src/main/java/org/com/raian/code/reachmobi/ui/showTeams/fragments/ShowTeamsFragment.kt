package org.com.raian.code.reachmobi.ui.showTeams.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.runBlocking
import org.com.raian.code.reachmobi.R
import org.com.raian.code.reachmobi.databinding.FragmentShowTeamsBinding
import org.com.raian.code.reachmobi.ui.addTeams.fragments.AddTeamsFragment
import org.com.raian.code.reachmobi.ui.base.BaseFragment
import org.com.raian.code.reachmobi.ui.showTeams.adapters.RVShowTeamsAdapter
import java.util.logging.Logger

class ShowTeamsFragment : BaseFragment() {

    private lateinit var binding: FragmentShowTeamsBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: RVShowTeamsAdapter

    init{
        TAG = ShowTeamsFragment::class.java.simpleName
        logger = Logger.getLogger(TAG)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context).also {
            prepareObservers()
        }
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

//        adapter = RVShowTeamsAdapter()
//        layoutManager = LinearLayoutManager(context)
//        binding.mRecyclerView.layoutManager = layoutManager
//        binding.mRecyclerView.adapter = adapter
    }

//    override fun onResume() {
//        logger.severe("$TAG::onResume")
//        super.onResume().also {
//            showTeamsViewModel.getSelectedTeamData()
//        }
//    }

    override fun onStart() {
        super.onStart().also {
            showTeamsViewModel.getSelectedTeamData()
//            runBlocking {
//                showTeamsViewModel.getRemoteData("DAL")
//            }
        }
    }

    fun goToTeams() {
        fragmentManager?.let { AddTeamsFragment().show(it, AddTeamsFragment::class.java.simpleName) }
    }

    private fun prepareObservers(){
//        showTeamsViewModel.getListOfTeamsUI().observe(this, Observer {
//            logger.severe("$TAG::${it}")
//        })
//        showTeamsViewModel.getListOfFetchedTeamsUI().observe(this, Observer { lst ->
//            lst.let {
//                adapter.setTeamStats(it)
//            }
//        })

        showTeamsViewModel.getListOfTeamStatistics().observe(this, Observer { lst->
            lst.let {
                logger.severe("$TAG::${it}")
            }
        })
    }

}
