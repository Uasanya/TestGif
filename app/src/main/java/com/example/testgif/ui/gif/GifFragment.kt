package com.example.testgif.ui.gif

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testgif.R
import com.example.testgif.databinding.FragmentGifBinding
import com.example.testgif.ui.base.BaseFragment
import com.example.testgif.ui.util.GlideProvider.setGif


private const val ARG_PARAM1 = "param1"


class GifFragment : BaseFragment<FragmentGifBinding>(FragmentGifBinding::inflate) {

    companion object {
        fun newInstance(param1: String) =
            GifFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        param1?.let { binding.ivGif.setGif(it) }
    }
}