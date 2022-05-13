package com.evertec.eplace.common.entities

data class StockEntity(
    var id: Long = 0,
    var nameStock: String,
    var priceStock: Int = 0
) {
}