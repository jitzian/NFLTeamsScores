package org.com.raian.code.reachmobi.ui.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil

import org.com.raian.code.reachmobi.R
import org.com.raian.code.reachmobi.databinding.ActivityMainBinding
import org.com.raian.code.reachmobi.ui.base.BaseActivity
import org.com.raian.code.reachmobi.ui.showTeams.fragments.ShowTeamsFragment
import java.util.logging.Logger

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    init {
        TAG = MainActivity::class.java.simpleName
        logger = Logger.getLogger(TAG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState).also {
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
            initView()
        }
    }

    override fun initView() {
        binding.activity = this
        binding.lifecycleOwner = this
        supportFragmentManager.beginTransaction()
            .replace(R.id.mFrameLayoutMainContainer, ShowTeamsFragment(), ShowTeamsFragment::class.java.simpleName)
            .commit()
    }

}
