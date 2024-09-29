package com.example.autocollection.ui.navigation.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.autocollection.data.CarItem
import com.example.autocollection.databinding.FragmentShoppingBinding
import com.example.autocollection.ui.observe
import com.example.autocollection.ui.showToast

class ShoppingFragment : Fragment() {

    private var _binding: FragmentShoppingBinding? = null
    private val binding get() = _binding!!
    val shoppingViewModel by lazy { ViewModelProvider(this)[ShoppingViewModel::class.java] }
    val adapter by lazy { ShoppingAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentShoppingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recycler.adapter = adapter
        shoppingViewModel.getVehiclesImp()
        observers()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observers(){
        with(shoppingViewModel){
            observe(itemsLiveData){ adapter.items.firstOrNull{ it.state !="Propio" } }
            observe(messageLiveData){ showToast(it) }
            observe(processingLiveData){
                when(it){
                    true ->  binding.progressBar.root.visibility = View.VISIBLE
                    false ->  binding.progressBar.root.visibility = View.GONE
                }
            }
        }
    }
}