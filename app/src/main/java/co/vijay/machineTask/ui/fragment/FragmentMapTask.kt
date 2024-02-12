package co.vijay.machineTask.ui.fragment

import co.vijay.machineTask.R
import co.vijay.machineTask.base.BaseFragment
import co.vijay.machineTask.databinding.FragmentMapTaskBinding
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class FragmentMapTask : BaseFragment<FragmentMapTaskBinding>() {

    override fun init() {
        
    }

    override fun layoutId() = R.layout.fragment_map_task
}
