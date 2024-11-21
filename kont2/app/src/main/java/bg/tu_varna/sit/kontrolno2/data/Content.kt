package bg.tu_varna.sit.kontrolno2.data

import android.os.Parcel
import android.os.Parcelable


data class Content(
    var email:String,
    var phone:String,
    var webAddress:String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(webAddress)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Content> {
        override fun createFromParcel(parcel: Parcel): Content {
            return Content(parcel)
        }

        override fun newArray(size: Int): Array<Content?> {
            return arrayOfNulls(size)
        }
    }


}