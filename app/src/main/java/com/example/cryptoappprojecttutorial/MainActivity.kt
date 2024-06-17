package com.example.cryptoappprojecttutorial

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoappprojecttutorial.Adapter.CryptoListAdapter
import com.example.cryptoappprojecttutorial.VievModel.MainViewModel
import com.example.cryptoappprojecttutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initRecyclerviewCrypto()

    }

    private fun initRecyclerviewCrypto() {
        binding.view.layoutManager  = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.view.adapter        = CryptoListAdapter(mainViewModel.loadData())
    }
}