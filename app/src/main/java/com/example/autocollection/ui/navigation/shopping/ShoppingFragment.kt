package com.example.autocollection.ui.navigation.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.autocollection.databinding.FragmentShoppingBinding

class ShoppingFragment : Fragment() {

    private var _binding: FragmentShoppingBinding? = null

    private val binding get() = _binding!!
    val adapter by lazy {
        ShoppingAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val shoppingViewModel =
            ViewModelProvider(this)[ShoppingViewModel::class.java]

        _binding = FragmentShoppingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recycler.adapter = adapter
        shoppingViewModel.itemsLiveData.value

        shoppingViewModel.itemsLiveData.observe(requireActivity()) {
            adapter.items = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}