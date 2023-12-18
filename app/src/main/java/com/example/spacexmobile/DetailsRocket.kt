package com.example.spacexmobile

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailsRocket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_rocket)

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
        supportActionBar?.title = getString(R.string.toolbar_detalle_noticia)

        var rocket = intent.getParcelableExtra<RocketInfo>("Rocket")

        val nameTV = findViewById<TextView>(R.id.drTV_Name)
        val countryTV = findViewById<TextView>(R.id.drTV_Country)
        val companyTV = findViewById<TextView>(R.id.drTV_Company)
        val costPerLaunchTV = findViewById<TextView>(R.id.drTV_CostPerLaunch)
        val descriptionTV = findViewById<TextView>(R.id.drTV_Description)

        nameTV.text = rocket!!.name
        countryTV.text = getString(R.string.dr_PrevCountry) + " " +rocket.country
        companyTV.text = getString(R.string.dr_PrevCompany) + " " +rocket.company
        costPerLaunchTV.text = getString(R.string.dr_PrevCostPerLaunch) + " " +rocket.cost_per_launch
        descriptionTV.text = rocket.description

        var recyclerview = findViewById<RecyclerView>(R.id.recyclerViewImagesRocket)
        
        var adapter = ImageAdapter(rocket.flickr_images)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
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