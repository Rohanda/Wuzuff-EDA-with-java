/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package com.wuzzufjobs;

import static com.wuzzufjobs.ManipulateData.encodeCategory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import smile.data.DataFrame;
import smile.data.vector.BaseVector;
import smile.data.vector.IntVector;

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
        // Get most popular jobs
        Map<String, Integer> count_title = mdata.count_title(wuzzuf);
        // Create a pie chart for number of  jobs per company
        vdata.plotpiechart(jobs_count);
        // Get Most popular areas
        Stream<Map.Entry<Object,String>> count_area = mdata.count_area(wuzzuf);
        // Get Most popular Skills
        Stream<Map.Entry<Object,String>>count_skills = mdata.count_skills(wuzzuf);
        // Create a histogram for most popular titles
        Set<String> a = count_title.keySet();
        Collection<Integer> b = count_title.values();
        List<String> x_values = new ArrayList<>(a);
        List<Integer> y_values = new ArrayList<>(b);
        vdata.plotbarchart(x_values,y_values);
        //System.out.println(wuzzuf.slice(0, 10));
        //System.out.println(cdata.display_summary());
        //System.out.println(cdata.display_structure());
        //jobs_count.forEach(s -> System.out.println(s));
        //count_title.forEach(s -> System.out.println(s));
        //count_area.forEach(s -> System.out.println(s));
        //System.out.println(count_skills);

        

}

}
