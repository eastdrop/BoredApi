package com.example.m16_arch.data

import com.example.m16_arch.entity.UsefulActivity

data class UsefulActivityDto(
    override val activity: String,
    override val type: String,
    override val participants: Int,
    override val price: Double,
    override val link : String,
    override val key: String,
    override val accessibility: Double
) : com.example.m16_arch.data.UsefulActivity
