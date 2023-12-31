package com.example.spacexmobile

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexmobile.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Colores de arriba y abajo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.Spektra_RojoRosado)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = ContextCompat.getColor(this, R.color.Spektra_RojoRosado)
        }

        //Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.toolbar_noticias)

        //Toast.makeText(this, "online: " + isOnline().toString(), Toast.LENGTH_LONG ).show()

        fetchCurrencyData().start()
    }

    private fun fetchCurrencyData(): Thread
    {
        return Thread {
            val url = URL("https://api.spacexdata.com/v4/rockets")
            val connection  = url.openConnection() as HttpsURLConnection

            if(connection.responseCode == 200)
            {
                val inputSystem = connection.inputStream
                val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")
                val request = Gson().fromJson(inputStreamReader, Array<RocketInfo>::class.java)
                updateUI(request)
                inputStreamReader.close()
                inputSystem.close()


            }
            else
            {
                //Toast.makeText(this, "resultado: " + connection.responseCode.toString(), Toast.LENGTH_LONG ).show()
                //binding.baseCurrency.text = "Failed Connection"
            }
        }
    }

    private fun updateUI(request: Array<RocketInfo>)
    {
        runOnUiThread {
            kotlin.run {
                val recyclerView = findViewById<RecyclerView>(R.id.rv_news)
                val adapter = adapter_cv_RocketPreview(request)

                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter

                adapter.onItemClick ={
                    val intent = Intent(this, DetailsRocket::class.java)
                    intent.putExtra("Rocket", it)
                    //finish()
                    startActivity(intent)
                }


                /*binding.
                binding.nzd.text = String.format("NZD: %.2f", request.rates.NZD)
                binding.usd.text = String.format("USD: %.2f", request.rates.USD)
                binding.gbp.text = String.format("GBP: %.2f", request.rates.GBP)*/
                Log.i("Costeeee",request[0].flickr_images[0])
                //Toast.makeText(this, "resultado: " + request.id + " "+  request.description + " "+ request.name, Toast.LENGTH_LONG ).show()
            }
        }
    }

    fun isOnline(): Boolean {
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.basic_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Acción al presionar la flecha hacia atrás
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}