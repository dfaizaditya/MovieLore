package id.ac.ui.cs.mobileprogramming.movielore

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import id.ac.ui.cs.mobileprogramming.movielore.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import android.content.res.Configuration
import android.content.Context
import android.content.Intent


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var menuController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        menuController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_movie, R.id.nav_favorite
        ).build()
        setupActionBarWithNavController(menuController, appBarConfiguration)
        binding.apply {
            navBottom.setupWithNavController(menuController)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId;
        if (id == R.id.add_action){
            Toast.makeText(this, "item Add Clicked", Toast.LENGTH_SHORT).show()
            return true
        }else if (id == R.id.settings_action1){
            Toast.makeText(this,"Seeting clicked",Toast.LENGTH_SHORT).show()
            setLocale("en")
        }else if (id == R.id.settings_action2){
            Toast.makeText(this,"Seeting clicked",Toast.LENGTH_SHORT).show()
            setLocale("id")
        }
        else if (id == R.id.settings_action3){
            Toast.makeText(this,"Seeting clicked",Toast.LENGTH_SHORT).show()
            setLocale("it")
        }
        else if (id == R.id.settings_action4){
            Toast.makeText(this,"Seeting clicked",Toast.LENGTH_SHORT).show()
            setLocale("hi")
        }
        return super.onOptionsItemSelected(item)
    }

    fun setLocale(lang: String?) {
        val myLocale = Locale(lang)
        val res = resources
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, res.displayMetrics)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
