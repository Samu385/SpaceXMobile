package com.example.spacexmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsRocket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_rocket)

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
    }
}