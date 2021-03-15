package com.example.listaparticipantes.di

import com.example.listaparticipantes.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {MainViewModel() }
}