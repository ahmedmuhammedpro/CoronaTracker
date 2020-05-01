package com.example.coronatracker.subscribed_countries

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.coronatracker.R

class SubscribedCountriesFragment : Fragment() {

    companion object {
        fun newInstance() = SubscribedCountriesFragment()
    }

    private lateinit var viewModel: SubscribedCountriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.subscribed_countries_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SubscribedCountriesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
