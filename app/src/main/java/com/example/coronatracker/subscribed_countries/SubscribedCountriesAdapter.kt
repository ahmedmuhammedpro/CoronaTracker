package com.example.coronatracker.subscribed_countries

import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.coronatracker.Constant
import com.example.coronatracker.R
import com.example.coronatracker.all_countries.adapter.CountryAdapter
import com.example.coronatracker.data_layer.model.Country
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.country_card.view.*

class SubscribedCountriesAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    var list :List<Country>? = null
    lateinit var onSubscribeListener: (View, Country) -> Unit

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.CountryViewHolder {

        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_card, parent, false)
        val countryViewHolder = CountryAdapter.CountryViewHolder(itemView)
        var icon :Icon = Icon.createWithResource(parent.context ,R.drawable.ic_star_colord)
        countryViewHolder.addIcon?.setImageIcon(icon)
        countryViewHolder.addIcon?.setOnClickListener {view ->
            onSubscribeListener(view, list!![countryViewHolder.adapterPosition])
        }
        return countryViewHolder
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: CountryAdapter.CountryViewHolder, position: Int) {
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

    fun setSubscribedCountries(list: List<Country>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun setOnDeleteClickListener(onSubscribeListener: (View, Country) -> Unit) {
        this.onSubscribeListener = onSubscribeListener
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var countryImage : ImageView? = null
        var countryName : TextView? = null
        var cases : TextView? = null
        var todayCases : TextView? = null
        var deaths : TextView? = null
        var todayDeaths : TextView? = null
        var active : TextView? = null
        var recoverd : TextView? = null
        var addIcon : ImageButton? = null
        init {
            countryImage = itemView.country_image
            countryName = itemView.countryName
            cases = itemView.casesTextView
            todayCases = itemView.todayCasesTextView
            deaths = itemView.deathTextView
            todayDeaths = itemView.todayDeathsTextView
            active = itemView.activeTextView
            recoverd = itemView.recoveredTextView
            addIcon = itemView.subscribeOnBtn
        }


    }
}