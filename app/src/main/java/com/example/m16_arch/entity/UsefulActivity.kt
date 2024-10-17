package com.example.m16_arch.entity

data class UsefulActivity(
    val activity: String, // Описание активности
    val type: String, // Тип активности (например, recreational, social и т.д.)
    val participants: Int, // Количество участников
    val price: Double, // Ожидаемая стоимость (0.0 - бесплатно)
    val link: String, // Ссылка (может быть пустой строкой)
    val key: String, // Уникальный идентификатор активности
    val accessibility: Double // Доступность активности (0.0 - легкая, 1.0 - сложная)
)
