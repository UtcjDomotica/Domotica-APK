package com.UTCJ.domotica.ui.tools;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.UTCJ.domotica.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class ToolsFragment extends Fragment {
    private LineChart lineChart;

    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);



        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Enero");
        labels.add("Febrero");
        labels.add("Marzo");
        labels.add("Abril");
        labels.add("Mayo");
        labels.add("Junio");
        labels.add("Julio");
        labels.add("Agosto");




        lineChart = (LineChart) root.findViewById(R.id.pchart);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(false);

        Description desc ;
        Legend L;

        L = lineChart.getLegend();
        desc = lineChart.getDescription();
        desc.setText(""); // this is the weirdest way to clear something!!
        L.setEnabled(false);

        YAxis leftAxis = lineChart.getAxisLeft();
        YAxis rightAxis = lineChart.getAxisRight();
        XAxis xAxis = lineChart.getXAxis();

        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawLabels(false);
        leftAxis.setDrawGridLines(false);
        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawLabels(false);
        rightAxis.setDrawGridLines(false);

        ArrayList<Entry> yValues = new ArrayList<>();
        yValues.add(new Entry(0,890f));
        yValues.add(new Entry(1,780));
        yValues.add(new Entry(3,1300));
        yValues.add(new Entry(4,836f));
        yValues.add(new Entry(5,850f));
        yValues.add(new Entry(6,560f));

        LineDataSet set1 = new LineDataSet(yValues, "Consumo en KW");
        set1.setFillAlpha(110);
        set1 = new LineDataSet(yValues, "Consumo en KW");
        set1.setDrawCircleHole(true);
        set1.setCircleColor(Color.rgb(60,16, 83));
        set1.setColor(Color.rgb(173,83,137));
        set1.setLineWidth(8);
        set1.setCircleRadius(8);
        set1.setValueTextSize(13);
        set1.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        lineChart.setData(data);

        lineChart.animateXY(2000,2000);







        return root;
    }
}