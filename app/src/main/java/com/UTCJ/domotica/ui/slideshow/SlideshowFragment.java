package com.UTCJ.domotica.ui.slideshow;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.UTCJ.domotica.Consumo;
import com.UTCJ.domotica.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.android.material.slider.LabelFormatter;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {
    private BarChart chart;
    private LineDataSet lineDataSet;


    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        chart = root.findViewById(R.id.chart);


        Description desc ;
        Legend L;

        L = chart.getLegend();
        desc = chart.getDescription();
        desc.setText(""); // this is the weirdest way to clear something!!
        L.setEnabled(false);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Foco 1");
        labels.add("Foco 2");
        labels.add("A/C");
        labels.add("TV");
        labels.add("PC1");
        labels.add("PC2");
        labels.add("Impr");
        labels.add("Serv");


        YAxis leftAxis = chart.getAxisLeft();
        YAxis rightAxis = chart.getAxisRight();
        XAxis xAxis = chart.getXAxis();


        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(true);
        xAxis.setDrawAxisLine(false);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        leftAxis.setDrawAxisLine(false);


        leftAxis.setTextSize(10f);
        leftAxis.setDrawLabels(false);
        leftAxis.setDrawGridLines(false);

        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawLabels(false);


        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 10f));
        entries.add(new BarEntry(1, 10f));
        entries.add(new BarEntry(2, 56f));
        entries.add(new BarEntry(3, 15f));
        entries.add(new BarEntry(4, 3f));
        entries.add(new BarEntry(5, 4f));
        entries.add(new BarEntry(6, 13f));
        entries.add(new BarEntry(7, 2f));

        BarDataSet set = new BarDataSet(entries, "");
        set.setValueTextSize(15);
        set.setColor(Color.rgb(173, 83, 137));
        BarData data = new BarData(set);
        data.setBarWidth(0.9f);
        chart.setData(data);

        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh
        chart.setScaleEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);
        chart.animateXY(2000, 2000);
        chart.setDrawBorders(false);
        chart.setDescription(desc);
        chart.setDrawValueAboveBar(true);




        return root;
    }

}