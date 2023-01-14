package com.example.mangareader

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class AnimeModel(val Aname:String,var AImage:String):Parcelable {

    var AnimeName:String
    var AnimeImage:String
    init
    {
        this.AnimeName=Aname;
        this.AnimeImage=AImage;
    }
}