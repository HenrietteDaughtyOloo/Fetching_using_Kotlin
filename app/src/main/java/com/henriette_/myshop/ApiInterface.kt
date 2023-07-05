package com.henriette_.myshop
import com.google.android.gms.analytics.ecommerce.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/product")
    fun getProducts():Call<ProductsResponse>

}