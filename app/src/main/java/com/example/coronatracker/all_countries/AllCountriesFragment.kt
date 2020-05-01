package com.example.coronatracker.all_countries

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.coronatracker.R
import com.example.mvvmdemo.data_layer.model.Country
import kotlinx.coroutines.*

class AllCountriesFragment : Fragment() {
    private var myJob: Job? = null
    var  list :List<Country>? = null
    private lateinit var viewModel: AllCountriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.all_countries_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AllCountriesViewModel::class.java)
        myJob = CoroutineScope(Dispatchers.IO).launch {
            list  = viewModel.getAllCountriesDataList()

            withContext(Dispatchers.Main) {
            }
        }
    }

}
