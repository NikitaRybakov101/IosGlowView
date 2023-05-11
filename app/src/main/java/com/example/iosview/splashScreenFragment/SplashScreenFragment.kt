package com.example.iosview.splashScreenFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iosview.databinding.SplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

    private var _binding: SplashScreenBinding? = null
    private val binding: SplashScreenBinding get() = _binding!!

    companion object {
        private const val URL_FONT = "null"
        private const val TEXT_SIZE_APP_NAME = 110f
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = SplashScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingSplash()
    }

    private fun loadingSplash() {
        binding.customTextView.setText("InTool", URL_FONT, TEXT_SIZE_APP_NAME)
    }
}