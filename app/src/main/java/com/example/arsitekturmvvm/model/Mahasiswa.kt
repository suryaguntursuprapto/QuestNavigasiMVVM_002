package com.example.arsitekturmvvm.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class Mahasiswa(
    val nama: String = "",
    val gender: String = "",
    val email: String = "",
    val NoHP: String = "",
    val alamat: String = ""
)
