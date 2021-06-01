package xit.zubrein.hadith.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import dagger.hilt.android.AndroidEntryPoint
import xit.zubrein.hadith.R
import xit.zubrein.hadith.Utils.toast
import xit.zubrein.hadith.base.BaseActivity
import xit.zubrein.hadith.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun getView() = R.layout.activity_main

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {

        showNavigationDrawer()

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showNavigationDrawer(){
        toggle = ActionBarDrawerToggle(this,binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            when(it.itemId){
                R.id.item1 -> toast("1")
                R.id.item2 -> toast("2")
                R.id.item3 -> toast("3")
            }
            true
        }
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

}