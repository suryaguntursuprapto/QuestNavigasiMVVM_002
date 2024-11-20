package com.example.arsitekturmvvm

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arsitekturmvvm.model.ListGender
import com.example.arsitekturmvvm.ui.view.FormMahasiswaView
import com.example.arsitekturmvvm.ui.viewmodel.MahasiswaViewModel
import java.text.Normalizer.Form

enum class Halaman{
    Form,
    Data
}
@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    Scaffold { isipadding ->
        val dataModel by viewModel.dataModel.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost, startDestination = Halaman.Form.name
        ){
            composable(route = Halaman.Form.name) {
                val konteks = LocalContext.current
                FormMahasiswaView(listGender = ListGender.listGender.map {id ->
                    konteks.resources.getString(id)
                }, onSubmitClick = {
                    viewModel.saveDataMhs(it)
                    navHost.navigate(Halaman.Data.name)
                } )
            }

        }
    }
}

