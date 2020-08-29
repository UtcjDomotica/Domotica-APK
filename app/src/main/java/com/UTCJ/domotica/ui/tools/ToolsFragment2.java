package com.UTCJ.domotica.ui.tools;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class ToolsFragment2 extends Fragment {
    private LineChart lineChart;
    private LineDataSet lineDataSet;

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




        lineChart = root.findViewById(R.id.pchart);

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

        //xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        ArrayList<Entry> yValues = new ArrayList<>();
        yValues.add(new Entry(0f, 390f));
        yValues.add(new Entry(1f, 780f));
        yValues.add(new Entry(2f, 1300f));
        yValues.add(new Entry(3f, 836f));
        yValues.add(new Entry(4f, 850f));
        yValues.add(new Entry(5f, 560f));

        lineDataSet = new LineDataSet(yValues, "Consumo en KW");
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setCircleColor(Color.rgb(60,16, 83));
        lineDataSet.setColor(Color.rgb(173,83,137));
        lineDataSet.setLineWidth(8);
        lineDataSet.setCircleRadius(8);
        lineDataSet.setValueTextSize(10);
        lineDataSet.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);


        LineData data = new LineData(dataSets);
        lineChart.setData(data);





        return root;
    }
}