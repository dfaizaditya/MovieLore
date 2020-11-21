package id.ac.ui.cs.mobileprogramming.movielore

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import id.ac.ui.cs.mobileprogramming.movielore.databinding.ActivityMainBinding
import id.ac.ui.cs.mobileprogramming.movielore.reciever.NetworkStateReceiver
import kotlinx.android.synthetic.main.download_activity.*
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NetworkStateReceiver.NetworkStateReceiverListener {
    private lateinit var menuController: NavController
    private var networkStateReceiver: NetworkStateReceiver? = null
    private var snackbar: Snackbar? = null
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        snackbar = Snackbar.make(findViewById(R.id.main_activity), R.string.no_internet_connection, Snackbar.LENGTH_INDEFINITE)
        setNetworkStateReceiver()

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
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            return true
        }else if (id == R.id.settings_action1){
            setLocale("en")
            Toast.makeText(this, R.string.setting_clicked,Toast.LENGTH_SHORT).show()
        }else if (id == R.id.settings_action2){
            setLocale("id")
            Toast.makeText(this, R.string.setting_clicked,Toast.LENGTH_SHORT).show()
        }
        else if (id == R.id.settings_action3){
            setLocale("it")
            Toast.makeText(this, R.string.setting_clicked,Toast.LENGTH_SHORT).show()
        }
        else if (id == R.id.settings_action4){
            setLocale("hi")
            Toast.makeText(this, R.string.setting_clicked,Toast.LENGTH_SHORT).show()
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


    //function that sets the network state receiver to the activity
    private fun setNetworkStateReceiver(){
        networkStateReceiver = NetworkStateReceiver(this)
        networkStateReceiver!!.addListener(this)
        applicationContext.registerReceiver(networkStateReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))

    }

    //function invoked when connected to the Internet
    override fun onNetworkAvailable() {
        snackbar!!.dismiss()

    }

    //funtion invoked when disconnected from the Internet
    override fun onNetworkUnavailable() {
        snackbar!!.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    fun startDownload(view: View){
        var a = downloadTask(this@MainActivity,btnDownload,progress_horizontal,txtState)
        a.execute()
        Toast.makeText(this, R.string.setting_clicked,Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }


}
