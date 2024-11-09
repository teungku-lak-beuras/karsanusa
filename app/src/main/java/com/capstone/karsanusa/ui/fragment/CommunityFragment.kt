package com.capstone.karsanusa.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.capstone.karsanusa.databinding.FragmentCommunityBinding
import com.google.android.material.search.SearchView.TransitionState

class CommunityFragment : Fragment() {
    private lateinit var binding: FragmentCommunityBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCommunityBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.communitySearchView.setupWithSearchBar(binding.communitySearchBar)
        binding.communitySearchView.addTransitionListener { searchView, previousState, newState ->
            if (newState == TransitionState.HIDDEN) {
                binding.communitySearchBar.setText(binding.communitySearchView.text)
                binding.communitySearchView.hide()
            }
        }
    }
}
