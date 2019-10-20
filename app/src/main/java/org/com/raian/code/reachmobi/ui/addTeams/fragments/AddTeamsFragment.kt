package org.com.raian.code.reachmobi.ui.addTeams.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import org.com.raian.code.reachmobi.databinding.FragmentAddTeamsBinding
import org.com.raian.code.reachmobi.ui.addTeams.adapters.RVAddTeamsAdapter
import org.com.raian.code.reachmobi.ui.addTeams.viewmodel.AddTeamsViewModel
import org.com.raian.code.reachmobi.ui.base.ViewModelFactory
import java.util.logging.Logger

class AddTeamsFragment : DialogFragment(){
    private val TAG = AddTeamsFragment::class.java.simpleName
    private val logger = Logger.getLogger(TAG)

    private lateinit var binding: FragmentAddTeamsBinding
    private lateinit var rootView: View

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: RVAddTeamsAdapter


    private val addTeamsViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory()).get(AddTeamsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddTeamsBinding.inflate(inflater, container, false)
        initView()
        return rootView
    }

    private fun initView(){
        rootView = binding.root
        binding.lifecycleOwner = this
        binding.fragment = this
        binding.viewModel = addTeamsViewModel

        adapter = RVAddTeamsAdapter()
        layoutManager = LinearLayoutManager(context)
        binding.mRecyclerViewAddTeams.layoutManager = layoutManager
        binding.mRecyclerViewAddTeams.adapter = adapter
    }

    override fun onResume() {
        super.onResume().also {
            initObservers()
        }
    }

    private fun initObservers() {
        addTeamsViewModel.getListOfTeamsUI().observe(this, Observer {
            adapter.setTeams(it)
        })
    }

}