package com.capstone.karsanusa.ui.fragment

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.capstone.karsanusa.BuildConfig
import com.capstone.karsanusa.R
import com.capstone.karsanusa.data.entity.CarouselEntity
import com.capstone.karsanusa.databinding.FragmentHomeBinding
import com.capstone.karsanusa.ui.activity.LoginActivity
import com.capstone.karsanusa.ui.adapter.CarouselAdapter
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var scanImageUri: Uri
    private val intentCamera = registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
        if (isSuccess) {
            val intent = HomeFragmentDirections.actionFragmentHomeToResultFragment()
            intent.scanImageUri = scanImageUri.toString()

            findNavController().navigate(intent)
        }
    }

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
        binding.homeCarouselRecyclerView.adapter = adapter
        binding.homeCarouselRecyclerView.layoutManager = layoutManager
        CarouselSnapHelper().attachToRecyclerView(binding.homeCarouselRecyclerView)
        adapter.submitList(list)
        // END OF DUMMY CODE

        binding.dummyButtonToLogin.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }
        binding.dummyButtonToCamera.setOnClickListener {
            val fileNameFormat = "yyyyMMdd_HHmmss"
            val timeStamp = SimpleDateFormat(fileNameFormat, Locale.US).format(Date())

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val contentValues = ContentValues()

                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, "$timeStamp.jpg")
                contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
                contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, "Pictures/KarsaNusa")

                scanImageUri = requireContext().contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)!!
            }
            else {
                val filesDir = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                val imageFile = File(filesDir, "/KarsaNusa/$timeStamp.jpg")

                if (imageFile.parentFile?.exists() == false) {
                    imageFile.parentFile?.mkdir()
                }

                scanImageUri = FileProvider.getUriForFile(requireContext(), "${BuildConfig.APPLICATION_ID}.fileprovider", imageFile)
            }

            intentCamera.launch(scanImageUri)
        }
    }
}
