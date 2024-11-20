package com.example.arsitekturmvvm

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.arsitekturmvvm.ui.viewmodel.MahasiswaViewModel

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
        val uiState by viewModel.dataModel.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost, startDestination = Halaman.Form.name
        ){

        }
    }
}

