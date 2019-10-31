package org.com.raian.code.reachmobi.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.com.raian.code.reachmobi.ui.addTeams.viewmodel.AddTeamsViewModel
import org.com.raian.code.reachmobi.ui.showTeams.viewmodel.ShowTeamsViewModel
import java.lang.IllegalStateException

@Deprecated("IT GOT ENHANCED")
@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ShowTeamsViewModel::class.java)){
            return ShowTeamsViewModel() as T
        }
        if(modelClass.isAssignableFrom(AddTeamsViewModel::class.java)){
            return AddTeamsViewModel() as T
        }
        throw IllegalStateException("ViewModel is not recognized")
    }
}