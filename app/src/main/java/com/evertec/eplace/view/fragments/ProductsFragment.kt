package com.evertec.eplace.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.evertec.eplace.R
import com.evertec.eplace.common.adapters.StockAdapter
import com.evertec.eplace.common.dataAccess.OnCLickListener
import com.evertec.eplace.common.entities.StockEntity
import com.evertec.eplace.databinding.FragmentProductsBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ProductsFragment : Fragment(), OnCLickListener {

    private lateinit var mBinding: FragmentProductsBinding

    private lateinit var mStockAdapter: StockAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentProductsBinding.inflate(layoutInflater)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {


        mStockAdapter = StockAdapter(mutableListOf(), this)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        mBinding.recyclerView.run {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            getStock()
            adapter = mStockAdapter
        }
    }

    private fun getStock() {

        runBlocking {
            val stock = mutableListOf(
                StockEntity(1, "PS5", 600),
                StockEntity(2, "Lavadora", 450),
                StockEntity(3, "Plancha", 75),
                StockEntity(4, "Nevera", 500),
                StockEntity(5, "Comedor", 375),
                StockEntity(6, "Cama", 275)
            )
            launch { mStockAdapter.setStock(stock) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    companion object {
        private const val KEY_ID_PRODUCT = "KEY_ID_PRODUCT"
    }

    override fun onClick(productId: Long) {
        val args = Bundle()

        args.putLong(KEY_ID_PRODUCT, productId)
    }
}