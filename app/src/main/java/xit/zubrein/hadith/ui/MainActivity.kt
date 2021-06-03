package xit.zubrein.hadith.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import xit.zubrein.hadith.R
import xit.zubrein.hadith.Utils.toast
import xit.zubrein.hadith.base.BaseActivity
import xit.zubrein.hadith.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var toggle : ActionBarDrawerToggle
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var listener : NavController.OnDestinationChangedListener

    override fun getView() = R.layout.activity_main

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {

        showNavigationDrawer()

    }

    private fun showNavigationDrawer(){

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(navController.graph,binding.drawerLayout)
        setupActionBarWithNavController(navController,appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

}