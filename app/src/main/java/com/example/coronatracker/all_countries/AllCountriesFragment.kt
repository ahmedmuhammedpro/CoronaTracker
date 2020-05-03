package com.example.coronatracker.all_countries

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.coronatracker.R
import com.example.coronatracker.all_countries.adapter.CountryAdapter
import com.example.mvvmdemo.data_layer.model.Country
import kotlinx.android.synthetic.main.all_countries_fragment.view.*
import kotlinx.coroutines.*

class AllCountriesFragment : Fragment() {
    private var myJob: Job? = null
    var  list :List<Country>? = null
    var countryAdapter : CountryAdapter? = null
    var recyclerView : RecyclerView? = null
    var swipeRefreshLayout : SwipeRefreshLayout? = null
    private lateinit var viewModel: AllCountriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.all_countries_fragment, container, false)
        recyclerView = view.recyclerView
        swipeRefreshLayout = view.swipeContainer
        swipeRefreshLayout!!.setOnRefreshListener {
        setUI()
            swipeRefreshLayout!!.isRefreshing = false
            Toast.makeText(context, "Refresh", Toast.LENGTH_SHORT).show();
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AllCountriesViewModel::class.java)
       setUI()
    }
fun setUI()
{
    myJob = CoroutineScope(Dispatchers.IO).launch {
        list  = viewModel.getAllCountriesDataList()

        withContext(Dispatchers.Main) {
            countryAdapter = CountryAdapter(list!!)
            Log.i("ee"," "+ list!!.size)
            val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
            recyclerView!!.setLayoutManager(mLayoutManager)
            recyclerView!!.setAdapter(countryAdapter)
        }
    }
}
}
