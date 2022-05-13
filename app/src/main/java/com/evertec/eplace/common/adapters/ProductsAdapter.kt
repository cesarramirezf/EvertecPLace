package com.evertec.eplace.common.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evertec.eplace.R
import com.evertec.eplace.common.dataAccess.OnCLickListener
import com.evertec.eplace.common.entities.ProductsEntity
import com.evertec.eplace.databinding.ItemProductBinding

class ProductsAdapter(

    private var products: MutableList<ProductsEntity>,
    private var listener: OnCLickListener

) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemProductBinding.bind(view)

        fun setListener(productsEntity: ProductsEntity) {
            with(binding.root) {
                setOnClickListener { listener.onClick(productsEntity.id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        with(holder) {
            setListener(product)
            binding.tvProductName.text = product.nameProduct
            binding.tvProductPrice.text = product.priceProduct.toString()
        }
    }

    override fun getItemCount(): Int = products.size

    fun setProducts(products: MutableList<ProductsEntity>) {
        this.products = products
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    fun getProducts() : MutableList<ProductsEntity> {
        return this.products
    }
}