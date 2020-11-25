package pt.atp.bobi.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import pt.atp.bobi.R
import pt.atp.bobi.presentation.MainViewModel
import pt.atp.bobi.presentation.ui.fragments.AboutFragment
import pt.atp.bobi.presentation.ui.fragments.BreedsFragment
import pt.atp.bobi.presentation.ui.fragments.FavouritesFragment
import pt.atp.bobi.presentation.ui.fragments.HomeFragment

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private val homeFragment by lazy { HomeFragment() }
    private val breedsFragment by lazy { BreedsFragment() }
    private val favouritesFragment by lazy { FavouritesFragment() }
    private val aboutFragment by lazy { AboutFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(homeFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.home -> {
                    loadFragment(homeFragment)
                    true
                }

                R.id.breeds -> {
                    loadFragment(breedsFragment)
                    true
                }

                R.id.favourites -> {
                    loadFragment(favouritesFragment)
                    true
                }

                R.id.about -> {
                    loadFragment(aboutFragment)
                    true
                }

                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navigationContainer, fragment)
            .commit()
    }
}