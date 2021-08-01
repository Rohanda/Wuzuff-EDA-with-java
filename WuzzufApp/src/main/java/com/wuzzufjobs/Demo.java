/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wuzzufjobs;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import smile.data.DataFrame;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JFrame;
import javax.swing.JTable;
import static org.roaringbitmap.RoaringBitmapWriter.writer;

/**
 *
 * @author rohanda
 */
public class Demo {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException, InvocationTargetException {
        // Read the data
        PrepareData cdata = new PrepareData();
        DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");

        // create an object from data manipulator class
        ManipulateData mdata = new ManipulateData();
        // create an object from data visualizer class
        VisualizeData vdata = new VisualizeData();
        // Count number of  jobs per company
        Map<String, Integer> jobs_count = mdata.count_job(wuzzuf);
        //System.out.print(jobs_count);
        // Get most popular jobs
        Map<String, Integer> count_title = mdata.count_title(wuzzuf);
        // Create a pie chart for number of  jobs per company
        //vdata.plotpiechart(jobs_count);
        // Get Most popular areas
        Map<String, Integer> count_area = mdata.count_area(wuzzuf);

        // Create a histogram for most popular titles
        Set<String> a = count_title.keySet();
        Collection<Integer> b = count_title.values();
        List<String> x_values = new ArrayList<>(a);
        List<Integer> y_values = new ArrayList<>(b);
        //vdata.plotbarchart(x_values, y_values);
        //System.out.println(wuzzuf.slice(0, 10));
        //System.out.println(cdata.display_summary());
        System.out.println(cdata.display_structure());
        //jobs_count.forEach(s -> System.out.println(s));
        //count_title.forEach(s -> System.out.println(s));
        //count_area.forEach(s -> System.out.println(s));

        // Create a histogram for most popular area
        Set<String> a2 = count_area.keySet();
        Collection<Integer> b2 = count_area.values();
        List<String> x_values2 = new ArrayList<>(a2);
        List<Integer> y_values2 = new ArrayList<>(b2);
        //vdata.plotbarchart2(x_values2, y_values2);

        //Get Most important Skills
        Map<String, Long> count_skills = mdata.count_skills(wuzzuf);
        //Most important skills in pie chart
        //vdata.plotpiechart3(count_skills);

        //display summary in a list of lists
        System.out.println("Display Summary: " + mdata.displaySummary());

         System.out.println("Factorize of YearsExp: " + Arrays.toString(mdata.encodeCategory(wuzzuf, "YearsExp")));

    }

}
