package com.evertec.eplace.common.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evertec.eplace.R
import com.evertec.eplace.common.dataAccess.OnCLickListener
import com.evertec.eplace.common.entities.StockEntity
import com.evertec.eplace.databinding.ItemProductBinding

class StockAdapter(
    private var stock: MutableList<StockEntity>,
    private var listener: OnCLickListener
)  : RecyclerView.Adapter<StockAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemProductBinding.bind(view)

        fun setListener(stockEntity:StockEntity) {
            with(binding.root) {
                setOnClickListener { listener.onClick(stockEntity.id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stock = stock[position]

        with(holder) {
            setListener(stock)
            binding.tvProductName.text = stock.nameStock
            binding.tvProductPrice.text = stock.priceStock.toString()
        }
    }

    override fun getItemCount(): Int = stock.size

    fun setStock(stock: MutableList<StockEntity>) {
        this.stock = stock
        notifyDataSetChanged()
    }

    fun getStock() : MutableList<StockEntity> {
        return this.stock
    }

}