package com.example.aplicaciomovilsoftware

import android.os.Parcel
import android.os.Parcelable


// PARCELABLE

class BEntrenador(
        val nombre: String?,
        val descripcion: String?,
        val liga: DLiga?

) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(DLiga::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        /*
        if(dest!=null){
            dest.writeString(nombre)
        }
        dest.writeString(nombre)
        */
        dest?.writeString(nombre)
        dest?.writeString(descripcion)
        dest?.writeParcelable(liga, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BEntrenador> {
        override fun createFromParcel(parcel: Parcel): BEntrenador {
            return BEntrenador(parcel)
        }

        override fun newArray(size: Int): Array<BEntrenador?> {
            return arrayOfNulls(size)
        }
    }
}