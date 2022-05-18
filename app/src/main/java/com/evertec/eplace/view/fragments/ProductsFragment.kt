package com.evertec.eplace.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evertec.eplace.R
import com.evertec.eplace.common.dataAccess.OnCLickListener
import com.evertec.eplace.databinding.FragmentProductsBinding


/*
Se decidio quemar la data del recyclerView debido a  problemas en la implementacion,
para avanzar con el reto
 */
class ProductsFragment : Fragment(), OnCLickListener {

    private lateinit var mBinding: FragmentProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentProductsBinding.inflate(layoutInflater)

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