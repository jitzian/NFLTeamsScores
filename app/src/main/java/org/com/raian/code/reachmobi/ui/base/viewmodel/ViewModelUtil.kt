package org.com.raian.code.reachmobi.ui.base.viewmodel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

inline fun <reified T : ViewModel> Fragment.getViewModel(noinline creator: (() -> T)? = null): T? {
    return if (creator == null)
        activity?.let { ViewModelProviders.of(it).get(T::class.java) }
    else
        activity?.let {
            ViewModelProviders.of(it, BaseViewModelFactory(creator)).get(T::class.java)
        }
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null)
        ViewModelProviders.of(this).get(T::class.java)
    else
        ViewModelProviders.of(this, BaseViewModelFactory(creator)).get(T::class.java)
}
