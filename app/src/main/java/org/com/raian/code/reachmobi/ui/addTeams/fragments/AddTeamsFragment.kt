package org.com.raian.code.reachmobi.ui.addTeams.fragments

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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
import org.com.raian.code.reachmobi.ui.base.viewmodel.getViewModel
import org.com.raian.code.reachmobi.ui.showTeams.viewmodel.ShowTeamsViewModel
import java.util.logging.Logger

class AddTeamsFragment : DialogFragment(){
    private val TAG = AddTeamsFragment::class.java.simpleName
    private val logger = Logger.getLogger(TAG)

    private lateinit var binding: FragmentAddTeamsBinding
    private lateinit var rootView: View

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: RVAddTeamsAdapter

//    private val addTeamsViewModel by lazy {
//        ViewModelProviders.of(this, ViewModelFactory()).get(AddTeamsViewModel::class.java)
//    }
//
//    private val showTeamsViewModel by lazy {
//        ViewModelProviders.of(this, ViewModelFactory()).get(ShowTeamsViewModel::class.java)
//    }

    private val addTeamsViewModel by lazy {
        getViewModel {
            AddTeamsViewModel()
        }
    }

    private val showTeamsViewModel by lazy {
        getViewModel {
            ShowTeamsViewModel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context).also {
            initObservers()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddTeamsBinding.inflate(inflater, container, false)
        initView()
        return rootView
    }

    override fun onStart() {
        super.onStart()

        // remove black outer overlay, or change opacity
//        dialog?.window?.also { window ->
//            window.attributes?.also { attributes ->
////                attributes.dimAmount = 0.1f
//                attributes.dimAmount = 0.8f
//                window.attributes = attributes
//            }
//        }
    }

    private fun initView(){
        rootView = binding.root
        binding.lifecycleOwner = this
        binding.fragment = this
        binding.viewModel = addTeamsViewModel

//        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.RED))

        adapter = RVAddTeamsAdapter()
        layoutManager = LinearLayoutManager(context)
        binding.mRecyclerViewAddTeams.layoutManager = layoutManager
        binding.mRecyclerViewAddTeams.adapter = adapter
    }

    private fun initObservers() {
        addTeamsViewModel?.getListOfTeamsUI()?.observe(this, Observer {lst->
            lst.let {
                adapter.setTeams(it)
            }
        })
    }

    override fun dismiss() {
        super.dismiss().also {
            showTeamsViewModel?.getSelectedTeamData()
        }
    }

}