package com.example.bankclerk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.bankclerk.databinding.ActivityMainBinding

class MainActivity(override val defaultViewModelProviderFactory: ViewModelProvider.Factory) : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 네비게이션 컨트롤러 설정
        navController = findNavController(R.id.nav_host_fragment)

        // 하단 네비게이션 뷰에 클릭 리스너 추가
        binding.bottomNavigationview.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.nav_counsel -> {
                    navController.navigate(R.id.counselFragment)
                    true
                }
                R.id.nav_record -> {
                    navController.navigate(R.id.recordFragment)
                    true
                }
                R.id.nav_mypage -> {
                    navController.navigate(R.id.mypageFragment)
                    true
                }
                else -> false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}