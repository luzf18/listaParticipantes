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
        list.postValue(listOf(Participante(ANERODRIGUES, "23 anos", "11965426346"),
                Participante(FELIPERODRIGUES, "26 anos", "11976003188"),
                Participante(FERNANDARODRIGUES, "18 anos", "19991297486"),
                Participante(FERNANDORODRIGUES, "18 anos","11991090427"),
                Participante(TIAGORODRIGUES, "25 anos","11945418403")))
        listener!!.onSetList()
        listener!!.onSearch()
    }
}