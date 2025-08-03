package com.example.shopify.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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

class HomeFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemAdapter: CommonItemAdapter
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter =
            ImageSliderAdapter(requireContext(), getViewPagerImage())
        startAutoScroll()

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
        _binding = null
    }
}