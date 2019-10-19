package org.com.raian.code.reachmobi.ui.addTeams.viewmodel

import org.com.raian.code.reachmobi.ui.base.BaseViewModel
import java.util.logging.Logger

class AddTeamsViewModel : BaseViewModel(){
    init {
        TAG = AddTeamsViewModel::class.java.simpleName
        logger = Logger.getLogger(TAG)
    }
}