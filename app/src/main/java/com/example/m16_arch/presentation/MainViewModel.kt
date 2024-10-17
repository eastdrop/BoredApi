package com.example.m16_arch.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m16_arch.data.UsefulActivity
import com.example.m16_arch.domain.GetUsefulActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsefulActivityUseCase: GetUsefulActivityUseCase
) : ViewModel() {

    // Создаем MutableStateFlow для хранения состояния UsefulActivity
    private val _usefulActivityState = MutableStateFlow<UsefulActivity?>(null)
    val usefulActivityState: StateFlow<UsefulActivity?> = _usefulActivityState

    // Метод для обновления UsefulActivity
    fun reloadUsefulActivity() {
        viewModelScope.launch {
            getUsefulActivityUseCase.execute(
                onSuccess = { activity ->
                    _usefulActivityState.value = activity // Обновляем состояние при успехе
                },
                onError = { error ->
                    // Можно обработать ошибку, например, логирование
                    println("Error: ${error.message}")
                }
            )
        }
    }
}