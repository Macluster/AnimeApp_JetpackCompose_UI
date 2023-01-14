package com.example.mangareader

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ItemViewModel :ViewModel() {

    var list= mutableStateListOf<AnimeModel>(

        AnimeModel("Naruto","https://th.bing.com/th/id/R.124f1b67d20b5d484123d4d63a810cb8?rik=VrFO2crRQcdHdg&riu=http%3a%2f%2fpre09.deviantart.net%2ffb7b%2fth%2fpre%2ff%2f2012%2f286%2fd%2f3%2fnaruto_uzumaki_artbook_poster_by_simodluffy-d5hnt72.png&ehk=7D9HgfQXTCx%2fMSM%2bXFtObnNKXliNNI88K9Iub%2fs8dBc%3d&risl=&pid=ImgRaw&r=0"),
        AnimeModel("Jujutsu Kaisen","https://static.displate.com/280x392/displate/2021-09-05/34b3f1a02b8ad0a62915dc9fda9c2d77_703f3c2ac7dcf6b4243ad78de829a5bf.jpg"),
        AnimeModel("Demon Slayer","https://images.wallpapersden.com/image/download/4k-demon-slayer-kimetsu-no-yaiba-poster-2022_bWdlbG2UmZqaraWkpJRnZmtlrWhtaWU.jpg")
    );
}