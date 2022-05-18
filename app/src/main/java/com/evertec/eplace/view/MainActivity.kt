package com.evertec.eplace.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.evertec.eplace.R
import com.evertec.eplace.common.utils.Utilities
import com.evertec.eplace.databinding.ActivityMainBinding
import com.evertec.eplace.view.fragments.InfoFragment
import com.evertec.eplace.view.fragments.PaymentFragment
import com.evertec.eplace.view.fragments.ProductsFragment
import com.evertec.eplace.view.fragments.ResumeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        launchFragment(ProductsFragment())
        binding.fab.setOnClickListener {
            launchFragment(PaymentFragment())
            binding.bottomAppBar.visibility = View.INVISIBLE
        }

        binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.info -> {
                    launchFragment(InfoFragment())
                    true
                }
                R.id.products -> {
                    launchFragment(ProductsFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun launchFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.containerMain, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

        if (fragment == PaymentFragment()) binding.bottomAppBar.visibility = View.INVISIBLE
        else binding.bottomAppBar.visibility = View.VISIBLE
    }
}