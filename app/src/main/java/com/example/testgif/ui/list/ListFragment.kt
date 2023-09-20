package com.example.testgif.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.testgif.databinding.FragmentListBinding
import com.example.testgif.ui.base.BaseFragment
import com.example.testgif.ui.gif.GifFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate), GifListener {

    private val listAdapter: ListAdapter = ListAdapter(this)
    private val viewModel: GifViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getGifs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = listAdapter
        viewModel.gifLiveData.observe(viewLifecycleOwner) { gifs ->
            listAdapter.setGifs(gifs)
        }
    }

    override fun navigateToGif(url: String) {
        navigate(GifFragment.newInstance(url))
    }
}