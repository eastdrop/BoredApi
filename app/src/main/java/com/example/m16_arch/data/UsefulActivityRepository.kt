package com.example.m16_arch.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class UsefulActivityRepository @Inject constructor(
    private val api: BoredApiService
) {
    // Инициализация BoredApiService при объявлении переменной
    /*private val api: BoredApiService = Retrofit.Builder()
        .baseUrl("https://www.boredapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BoredApiService::class.java)*/

    // Асинхронный метод для получения активности с использованием enqueue
    fun getUsefulActivity(onSuccess: (UsefulActivity) -> Unit, onError: (Throwable) -> Unit) {
        api.getActivity().enqueue(object : Callback<UsefulActivityDto> {
            override fun onResponse(
                call: Call<UsefulActivityDto>,
                response: Response<UsefulActivityDto>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it)
                    }
                } else {
                    onError(Throwable("Response error: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<UsefulActivityDto>, t: Throwable) {
                onError(t)
            }
        })
    }
}