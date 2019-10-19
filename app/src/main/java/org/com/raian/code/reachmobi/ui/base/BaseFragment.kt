package org.com.raian.code.reachmobi.ui.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import org.com.raian.code.reachmobi.ui.showTeams.viewmodel.ShowTeamsViewModel
import java.util.logging.Logger

abstract class BaseFragment : Fragment(){
    protected lateinit var TAG : String
    protected lateinit var logger: Logger
    protected lateinit var rootView: View

    protected val showTeamsViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory()).get(ShowTeamsViewModel::class.java)
    }

    abstract fun initView()
}