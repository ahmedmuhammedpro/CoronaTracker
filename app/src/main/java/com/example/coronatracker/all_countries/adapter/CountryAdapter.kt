package com.example.coronatracker.all_countries.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.coronatracker.Constant
import com.example.coronatracker.R
import com.example.coronatracker.data_layer.model.Country
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.country_card.view.*

class CountryAdapter(inputList :List<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    var  list :List<Country>? = null
    init {
        list = inputList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_card, parent, false)
        return CountryViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
       var currentCountry: Country = list!!.get(position)
        holder.countryName!!.text = currentCountry.country
        holder.cases!!.text = "Cases : "+ currentCountry.cases.toString()
        holder.todayCases!!.text = "Today cases : "+ currentCountry.todayCases.toString()
        holder.deaths!!.text = "Death : "+ currentCountry.deaths.toString()
        holder.todayDeaths!!.text = "Today death : "+ currentCountry.todayDeaths.toString()
        holder.active!!.text = "Active : "+currentCountry.active.toString()
        holder.recoverd!!.text = "Recovered: "+currentCountry.recovered.toString()
        Picasso.get()
            .load(currentCountry.countryInfo.flag)
            .placeholder(R.drawable.ic_account)
            .into(holder.countryImage);
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
           // val personJsonString: String = GsonUtils.getGsonParser()!!.toJson(currentCountry)
            bundle.putString(Constant.COUNTRY_NAME, currentCountry.country)
            bundle.putLong(Constant.CASES, currentCountry.cases)
            bundle.putLong(Constant.TODAY_CASES, currentCountry.todayCases)
            bundle.putLong(Constant.DEATHS, currentCountry.deaths)
            bundle.putLong(Constant.TODAT_DEATH, currentCountry.todayDeaths)
            bundle.putLong(Constant.ACTIVE, currentCountry.active)
            bundle.putLong(Constant.RECIVERD, currentCountry.recovered)
            Navigation.findNavController(it)
                .navigate(R.id.action_allCountriesFragment_to_countryStatisticFragment, bundle)
        }
    }
    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryImage :ImageView? = null
        var countryName :TextView? = null
        var cases :TextView? = null
        var todayCases :TextView? = null
        var deaths :TextView? = null
        var todayDeaths :TextView? = null
        var active :TextView? = null
        var recoverd :TextView? = null
        init {
            countryImage = itemView.country_image
            countryName = itemView.countryName
            cases = itemView.casesTextView
            todayCases = itemView.todayCasesTextView
            deaths = itemView.deathTextView
            todayDeaths = itemView.todayDeathsTextView
            active = itemView.activeTextView
            recoverd = itemView.recoveredTextView
        }
    }

}