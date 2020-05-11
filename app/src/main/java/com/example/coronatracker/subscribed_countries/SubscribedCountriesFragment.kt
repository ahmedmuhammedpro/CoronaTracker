package com.example.coronatracker.subscribed_countries

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.coronatracker.R
import com.example.coronatracker.data_layer.LocalRepository
import com.example.coronatracker.data_layer.LocalRepositoryImp
import com.example.coronatracker.data_layer.model.Country
import kotlinx.android.synthetic.main.subscribed_countries_fragment.*

class SubscribedCountriesFragment : Fragment() {

    lateinit var subscribedRecyclerview: RecyclerView
    private val localRepository: LocalRepository by lazy {
        LocalRepositoryImp(activity?.application!!)
    }

    companion object {
        fun newInstance() = SubscribedCountriesFragment()
    }

    private lateinit var viewModel: SubscribedCountriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.subscribed_countries_fragment, container, false)
        subscribedRecyclerview = view.findViewById(R.id.subscribedRecyclerview)
        subscribedRecyclerview.layoutManager = LinearLayoutManager(context)

        val localRepo: LocalRepository = LocalRepositoryImp(activity?.application!!)
        localRepo.getAllCountries().observe(viewLifecycleOwner, Observer { countries ->
            Log.i("ahmed", "size = ${countries.size}")
            val adapter = SubscribedCountriesAdapter()
            adapter.setSubscribedCountries(countries)
            adapter.setOnDeleteClickListener(this@SubscribedCountriesFragment::deleteCountry)
            subscribedRecyclerview.adapter = adapter
        })

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SubscribedCountriesViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun deleteCountry(view: View, country: Country) {
        localRepository.deleteCountries(country)
    }

}
