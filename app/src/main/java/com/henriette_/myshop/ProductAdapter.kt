package com.henriette_.myshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henriette_.myshop.databinding.ProductListItemBinding
//import com.google.android.gms.analytics.ecommerce.Product
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductAdapter(var productList: List<Products>) : RecyclerView.Adapter<MyShopViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyShopViewHolder {
        val binding =
            ProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyShopViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyShopViewHolder, position: Int) {
        var currentProducts = productList[position]
        var binding = holder.binding
        binding.tvId.text = currentProducts.id.toString()
        binding.tvCategory.text = currentProducts.category.toString()
        binding.tvDescription.text = currentProducts.description.toString()
        binding.tvPrice.text = currentProducts.price.toString()
        binding.tvTitle.text = currentProducts.title.toString()
        binding.tvRating.text = currentProducts.rating.toString()
        binding.tvStock.text = currentProducts.stock.toString()

        Picasso
            .get()
            .load(currentProducts.thumbnail)
//            .transform(/* transformation = */ CropCircleTransformation())
            .into(binding.ivThumbnail)
    }


}

class MyShopViewHolder(var binding: ProductListItemBinding) : RecyclerView.ViewHolder(binding.root)
