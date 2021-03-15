package com.example.listaparticipantes.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listaparticipantes.model.Participante
import com.example.listaparticipantes.utils.Constants.ANERODRIGUES
import com.example.listaparticipantes.utils.Constants.FELIPERODRIGUES
import com.example.listaparticipantes.utils.Constants.FERNANDARODRIGUES
import com.example.listaparticipantes.utils.Constants.FERNANDORODRIGUES
import com.example.listaparticipantes.utils.Constants.TIAGORODRIGUES

class MainViewModel : ViewModel() {
    var listener: MainListener? = null

    val list: MutableLiveData<List<Participante>> = MutableLiveData()

    fun initViewModel() {
        list.postValue(listOf(Participante(ANERODRIGUES), Participante(FELIPERODRIGUES), Participante(
                FERNANDARODRIGUES), Participante(FERNANDORODRIGUES), Participante(TIAGORODRIGUES)))
        listener!!.onSetList()
        listener!!.onSearch()
    }
}