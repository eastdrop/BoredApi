package com.example.m16_arch.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.m16_arch.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment: Fragment() {
    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Подписываемся на полезную активность из ViewModel
        lifecycleScope.launch {
            viewModel.usefulActivityState.collect{ activity ->
                activity?.let {
                    binding.activityTextView.text = it.activity
                }
            }
        }

        // Загружаем новую активность при запуске
        viewModel.reloadUsefulActivity()

        // Добавляем обработчик для перезагрузки активности по нажатию кнопки
        binding.reloadButton.setOnClickListener{
            viewModel.reloadUsefulActivity()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}