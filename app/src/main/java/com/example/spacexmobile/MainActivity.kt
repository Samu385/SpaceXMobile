package com.example.spacexmobile

import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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

        //Toast.makeText(this, "online: " + isOnline().toString(), Toast.LENGTH_LONG ).show()

        val recyclerView = findViewById<RecyclerView>(R.id.rv_news)
        val adapter = adapter_cv_news()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

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
                updateUI(request[0])
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

    private fun updateUI(request: RocketInfo)
    {
        runOnUiThread {
            kotlin.run {

                /*binding.
                binding.nzd.text = String.format("NZD: %.2f", request.rates.NZD)
                binding.usd.text = String.format("USD: %.2f", request.rates.USD)
                binding.gbp.text = String.format("GBP: %.2f", request.rates.GBP)*/
                Log.i("Rocketinfo",request.id + " "+  request.description + " "+ request.name)
                //Toast.makeText(this, "resultado: " + request.id + " "+  request.description + " "+ request.name, Toast.LENGTH_LONG ).show()
            }
        }
    }

    fun isOnline(): Boolean {
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}