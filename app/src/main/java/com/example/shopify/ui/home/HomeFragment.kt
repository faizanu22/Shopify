package com.example.shopify.ui.home

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopify.databinding.FragmentFirstBinding
import com.example.shopify.ui.adapter.ImageSliderAdapter
import com.example.shopify.ui.adapter.CommonItemAdapter
import com.example.shopify.utils.MasterDataUtils
import com.example.shopify.utils.MasterDataUtils.getViewPagerImage
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var itemAdapter: CommonItemAdapter
    private val handler = Handler(Looper.getMainLooper())
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter =
            ImageSliderAdapter(requireContext(), getViewPagerImage())
        startAutoScroll()

        val docRef = db.collection("1")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("fireBase", "DocumentSnapshot data: $document")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }

        binding.recyclerViewExclusiveOffer.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL, false
        )
        itemAdapter = CommonItemAdapter(
            requireContext(),
            MasterDataUtils.getCommonList(),
            CommonItemAdapter.OnClickListener { itemAdapter, clickType ->

            })
        binding.recyclerViewExclusiveOffer.adapter = itemAdapter

        binding.recyclerViewBestSelling.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL, false
        )
        itemAdapter = CommonItemAdapter(
            requireContext(),
            MasterDataUtils.getCommonList(),
            CommonItemAdapter.OnClickListener { itemAdapter, clickType ->

            })
        binding.recyclerViewBestSelling.adapter = itemAdapter

    }

    private fun startAutoScroll() {
        var currentPage = 0
        var runnable: Runnable? = null
        runnable = object : Runnable {
            override fun run() {
                if (getViewPagerImage().isNotEmpty()) {
                    currentPage =
                        (currentPage + 1) % MasterDataUtils.getViewPagerImage().size
                    binding.viewPager.setCurrentItem(currentPage, true)
                    handler.postDelayed(this, 4000)
                }
            }
        }
        handler.postDelayed(runnable, 4000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}