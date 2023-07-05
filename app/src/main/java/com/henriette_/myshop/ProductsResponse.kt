package com.henriette_.myshop

//import com.google.android.gms.analytics.ecommerce.Product


data class ProductsResponse(
    var products: List<Products>,
    var total:Int,
    var  skip:Int,
    var limit:Int
)
