package com.example.m16_arch.data

import retrofit2.Call
import retrofit2.http.GET

interface BoredApiService {
    @GET("activity")
    fun getActivity(): Call<UsefulActivityDto>
}