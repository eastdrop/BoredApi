package com.example.m16_arch.domain

import com.example.m16_arch.data.UsefulActivity
import com.example.m16_arch.data.UsefulActivityRepository
import javax.inject.Inject

class GetUsefulActivityUseCase @Inject constructor(
    private val repository: UsefulActivityRepository
) {
    fun execute(onSuccess: (UsefulActivity) -> Unit, onError: (Throwable) -> Unit) {
        repository.getUsefulActivity(onSuccess, onError)
    }
}