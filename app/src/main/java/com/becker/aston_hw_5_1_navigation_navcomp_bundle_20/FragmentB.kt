package com.becker.aston_hw_5_1_navigation_navcomp_bundle_20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.becker.aston_hw_5_1_navigation_navcomp_bundle_20.databinding.FragmentBBinding


class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonBtoC.setOnClickListener {
                val bundleToFragmentC = Bundle()
                bundleToFragmentC.putString(PASSED_TEXT_FROM_B_TO_C_EXTRA, "Hello Fragment C")
                findNavController().navigate(R.id.action_fragmentB_to_fragmentC, bundleToFragmentC)
            }

            buttonBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    companion object {
        const val PASSED_TEXT_FROM_B_TO_C_EXTRA = "PASSED_TEXT_FROM_B_TO_C_EXTRA"
    }
}