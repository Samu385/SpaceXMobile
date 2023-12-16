package com.example.spacexmobile

class RocketInfo(
    var name : String,
    var type : type,
    var active : Boolean,
    var stages : Int,
    var boosters : Int,
    var cost_per_launch : Float,
    var success_rate_pct : Int,
    var first_flight : String,
    var country: String,
    var company: String,
    var description: String,
    var id : String)
{


}


enum class type{
    Rocket,
    Ship,
}