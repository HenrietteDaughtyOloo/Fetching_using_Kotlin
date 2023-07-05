package com.henriette_.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.henriette_.myshop.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
     var productList: List<Products> = emptyList()
//    late init var ProductAdapter:ProductAdapter

//    var productList:List<Products> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ProductAdapter= ProductAdapter(emptyList())
//        binding.rvProducts.adapter=ProductAdapter

    }

    override fun onResume() {
        super.onResume()
        getProducts()
    }
    fun getProducts(){
        val apiClient = ApiClient.buildClient(ApiInterface::class.java)
        val request = apiClient.getProducts()
        request.enqueue(object : Callback<ProductsResponse>{
            override fun onResponse(call: Call<ProductsResponse>, response: Response<ProductsResponse>) {
                if(response.isSuccessful){
                    var product = response.body()?.products
                    var productsAdapter=ProductAdapter(product?: emptyList())
                            binding.rvProducts.layoutManager=LinearLayoutManager(this@MainActivity)
                            binding.rvProducts.adapter=productsAdapter

                            Toast.
                    makeText(
                        baseContext,
                        "fetched ${product?.size} products",
                        Toast.LENGTH_LONG)
                        .show()
                }
                else{
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
//        binding.rvProducts.layoutManager=LinearLayoutManager(this@MainActivity)
//        binding.rvProducts.adapter=ProductAdapter
    }
}



