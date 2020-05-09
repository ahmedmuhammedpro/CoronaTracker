package com.example.coronatracker.country_statistics

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Pie
import com.anychart.enums.Align
import com.anychart.enums.LegendLayout
import com.example.coronatracker.Constant

import com.example.coronatracker.R
import kotlinx.android.synthetic.main.country_statistic_fragment.view.*

class CountryStatisticFragment : Fragment() {

    companion object {
        fun newInstance() = CountryStatisticFragment()
    }

    private lateinit var viewModel: CountryStatisticViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view  = inflater.inflate(R.layout.country_statistic_fragment, container, false)
        val args = arguments
        val cases :Long = args?.get(Constant.CASES) as Long
        val todayCases = args?.get(Constant.TODAY_CASES) as Long
        val death = args?.get(Constant.DEATHS) as Long
        val todayDeath = args?.get(Constant.TODAT_DEATH) as Long
        val active = args?.get(Constant.ACTIVE) as Long
        val recovered = args?.get(Constant.RECIVERD) as Long
        val country = args?.get(Constant.COUNTRY_NAME)
        val anyChartView: AnyChartView = view.any_chart_view
        anyChartView.setProgressBar(view.progress_bar)
        val pie : Pie = AnyChart.pie()

        val data: MutableList<DataEntry> = ArrayList()
        data.add(ValueDataEntry(Constant.CASES, cases))
        data.add(ValueDataEntry(Constant.DEATHS, death))

        data.add(ValueDataEntry(Constant.TODAY_CASES, todayCases))
        data.add(ValueDataEntry(Constant.TODAT_DEATH, todayDeath))
        data.add(ValueDataEntry(Constant.ACTIVE, active))
        data.add(ValueDataEntry(Constant.RECIVERD, recovered))


        pie.data(data)

        pie.title("Today statistics in "+country)

        pie.labels().position("outside")

        pie.legend().title().enabled(true)
        pie.legend().title()
            .text("Retail channels")
            .padding(0.0, 0.0, 10.0, 0.0)

        pie.legend()
            .position("center-bottom")
            .itemsLayout(LegendLayout.HORIZONTAL)
            .align(Align.CENTER)

        anyChartView.setChart(pie)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CountryStatisticViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
