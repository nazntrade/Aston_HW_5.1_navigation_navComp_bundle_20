package com.becker.aston_hw_5_1_navigation_navcomp_bundle_20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.becker.aston_hw_5_1_navigation_navcomp_bundle_20.FragmentB.Companion.PASSED_TEXT_FROM_B_TO_C_EXTRA
import com.becker.aston_hw_5_1_navigation_navcomp_bundle_20.databinding.FragmentCBinding

class FragmentC : Fragment() {

    private var textFromFragmentB: String? = null
    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textFromFragmentB = arguments?.getString(PASSED_TEXT_FROM_B_TO_C_EXTRA)

        with(binding) {
            textFromB.text = textFromFragmentB
            buttonBack.setOnClickListener {
                findNavController().popBackStack()
            }
            buttonCtoD.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentC_to_fragmentD)
            }
        }
    }
}