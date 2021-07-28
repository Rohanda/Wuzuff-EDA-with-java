/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wuzzufjobs;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import smile.data.DataFrame;
import smile.data.vector.BaseVector;
import org.knowm.xchart.*;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.Styler.LegendPosition;
import smile.plot.swing.Histogram;


/**
 *
 * @author rohanda
 */
public class VisualizeData {
    public void plotpiechart(Map<String, Integer> wuzzuf) {
        //filter to get an array of passenger ages
        //BaseVector title = wuzzuf.apply("Title");
        //String[] title_array = title.toStringArray();
        //BaseVector company = wuzzuf.apply("Company");
        //String[] company_array = company.toStringArray();
        //List<String> title_list = Arrays.asList(title_array);
        //List<String> company_list = Arrays.asList(company_array);
           PieChart chart = new PieChartBuilder().width(800).height(600).title("My Pie Chart").theme(ChartTheme.GGPlot2).build();
    // Customize Chart
    chart.getStyler().setLegendVisible(false);
    chart.getStyler().setAnnotationType(AnnotationType.LabelAndPercentage);
    chart.getStyler().setAnnotationDistance(1.15);
    chart.getStyler().setPlotContentSize(.7);
    chart.getStyler().setStartAngleInDegrees(90);
        // Series
     
        int i = 0;
        for (String company : wuzzuf.keySet()) 
            { 
                if (i <5)
                chart.addSeries(company,wuzzuf.get(company));
                i++;
            }
       
        
        // Show it
        new SwingWrapper (chart).displayChart ();
    
}
    public void plotbarchart( List<String> x, List<Integer> y ) throws InterruptedException, InvocationTargetException {
 
 //  int[] newWuzArray = Arrays.copyOfRange(wuzzuf.intVector ("TitleValues").toIntArray(), 15, 100);
   /*      
   Histogram.of (newWuzArray, 10, false)
                .canvas ().setAxisLabels ("Title", "Count")
                .setTitle ("Title frequencies among companies")
                .window ();
*/     List x1 =  x.subList(0, 5);
        List y1 =  y.subList(0, 5);

    CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Popular Title").xAxisTitle("Title").yAxisTitle("Number").build();
 
    // Customize Chart
    chart.getStyler().setHasAnnotations(true);
 
    // Series
    chart.addSeries("test 1", x1, y1);
    
        new SwingWrapper (chart).displayChart ();

    }
    
}
