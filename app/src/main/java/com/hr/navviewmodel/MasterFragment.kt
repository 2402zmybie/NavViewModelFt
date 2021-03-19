package com.hr.navviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.hr.navviewmodel.databinding.FragmentMasterBinding

class MasterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentMasterBinding>(inflater,R.layout.fragment_master,container,false);
        var viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java);
        binding.seekbar.setProgress(viewModel.number.value!!)
        binding.seekbar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                viewModel.number.value = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        binding.bt.setOnClickListener {
            var findNavController = Navigation.findNavController(it)
            findNavController.navigate(R.id.action_masterFragment_to_detailFragment)
        }g
        binding.data = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}