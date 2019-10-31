package org.com.raian.code.reachmobi.ui.showTeams.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.com.raian.code.reachmobi.databinding.FragmentShowTeamsBinding
import org.com.raian.code.reachmobi.ui.addTeams.fragments.AddTeamsFragment
import org.com.raian.code.reachmobi.ui.base.BaseFragment
import org.com.raian.code.reachmobi.ui.showTeams.adapters.RVShowTeamsAdapter
import org.com.raian.code.reachmobi.ui.showTeams.adapters.SwipeToDeleteCallback
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
        binding = FragmentShowTeamsBinding.inflate(inflater, container, false)
        initView()
        setupSwiping()
        return rootView
    }

    override fun initView() {
        rootView = binding.root
        binding.lifecycleOwner = this
        binding.showTeamsFragment = this
        binding.showTeamsViewModel = showTeamsViewModel

        adapter = RVShowTeamsAdapter()
        layoutManager = LinearLayoutManager(context)
        binding.mRecyclerView.layoutManager = layoutManager
        binding.mRecyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume().also {
            showTeamsViewModel?.getSelectedTeamData()
        }
    }

    fun goToTeams() {
        fragmentManager?.let { AddTeamsFragment().show(it, AddTeamsFragment::class.java.simpleName) }
    }

    private fun prepareObservers(){
        showTeamsViewModel?.teamDataUI?.observe(this, Observer {
            adapter.setTeamStats(it)
        })
    }

    private fun setupSwiping() {
        val swipeHandler = object : SwipeToDeleteCallback(context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = binding.mRecyclerView.adapter as RVShowTeamsAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.mRecyclerView)
    }

}
