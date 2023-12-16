package com.example.spacexmobile

import android.os.Parcel
import android.os.Parcelable

class RocketInfo(
    var name: String,
    var active: Boolean,
    var stages: Int,
    var boosters: Int,
    var cost_per_launch: Int,
    var successRatePct: Int,
    var first_flight: String,
    var country: String,
    var company: String,
    var description: String,
    var id: String,
    var flickr_images: Array<String>
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createStringArray()!! // Agrega la lectura de flickr_images
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeByte(if (active) 1 else 0)
        parcel.writeInt(stages)
        parcel.writeInt(boosters)
        parcel.writeInt(cost_per_launch)
        parcel.writeInt(successRatePct)
        parcel.writeString(first_flight)
        parcel.writeString(country)
        parcel.writeString(company)
        parcel.writeString(description)
        parcel.writeString(id)
        parcel.writeStringArray(flickr_images) // Agrega la escritura de flickr_images
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RocketInfo> {
        override fun createFromParcel(parcel: Parcel): RocketInfo {
            return RocketInfo(parcel)
        }

        override fun newArray(size: Int): Array<RocketInfo?> {
            return arrayOfNulls(size)
        }
    }
}
