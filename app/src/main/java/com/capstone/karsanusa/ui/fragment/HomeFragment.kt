package com.capstone.karsanusa.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.capstone.karsanusa.R
import com.capstone.karsanusa.data.entity.CarouselEntity
import com.capstone.karsanusa.databinding.FragmentHomeBinding
import com.capstone.karsanusa.ui.activity.LoginActivity
import com.capstone.karsanusa.ui.adapter.CarouselAdapter
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // DUMMY CODE; IGNORE FROM THIS ON WARD
        val array = resources.obtainTypedArray(R.array.carousel_images)
        val adapter = CarouselAdapter()
        val list = ArrayList<CarouselEntity>()

        list.add(CarouselEntity(array.getResourceId(0, -1)))
        list.add(CarouselEntity(array.getResourceId(1, -1)))
        list.add(CarouselEntity(array.getResourceId(2, -1)))
        list.add(CarouselEntity(array.getResourceId(3, -1)))
        list.add(CarouselEntity(array.getResourceId(4, -1)))
        list.add(CarouselEntity(array.getResourceId(5, -1)))

        val layoutManager = CarouselLayoutManager(HeroCarouselStrategy())
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        binding.carouselRecyclerView.adapter = adapter
        binding.carouselRecyclerView.layoutManager = layoutManager
        CarouselSnapHelper().attachToRecyclerView(binding.carouselRecyclerView)
        adapter.submitList(list)
        // END OF DUMMY CODE

        binding.dummyButtonToLogin.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
