package com.example.listaparticipantes.ui.main

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.listaparticipantes.ParticipantesAdapter
import com.example.listaparticipantes.R
import com.example.listaparticipantes.databinding.ActivityMainBinding
import com.example.listaparticipantes.model.Participante

class MainActivity : AppCompatActivity(), MainListener {

    private val adapterParticipantes = ParticipantesAdapter()
    private var listaParticipantes: RecyclerView? = null
    private var searchView: SearchView? = null
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        setupRecyclerView()
        searchView = findViewById(R.id.searchView)

    }

    private fun initViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel =
                ViewModelProviders.of(this, ViewModelFactory()).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.listener = this

        listaParticipantes = binding.listaParticipantes

        viewModel.initViewModel()

    }

    private fun setupRecyclerView() {
        listaParticipantes?.adapter = adapterParticipantes
        val manager = androidx.recyclerview.widget.LinearLayoutManager(this@MainActivity)
        listaParticipantes?.layoutManager = manager
    }


    override fun onSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapterParticipantes.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapterParticipantes.filter.filter(newText)
                return true
            }

        })
    }

    override fun onSetList() {
        val observableList = Observer<List<Participante>> { participantes ->
            adapterParticipantes.items = participantes
            adapterParticipantes.participanteItems = participantes
            adapterParticipantes.notifyDataSetChanged()
        }
        viewModel.list.observe(this, observableList)
    }
}
