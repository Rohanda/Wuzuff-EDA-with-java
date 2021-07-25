/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package com.wuzzufjobs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.stream.Stream;
import smile.data.DataFrame;

/**
 *
 * @author rohanda
 */
public class Demo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        PrepareData cdata = new PrepareData();
        DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        ManipulateData mdata = new ManipulateData(wuzzuf);
        Stream<Map.Entry<Object,String>> jobs_count = mdata.count_job();

        //System.out.println(wuzzuf.slice(0, 10));
        //System.out.println(cdata.display_summary());
        //System.out.println(cdata.display_structure());
        jobs_count.forEach(s -> System.out.println(s));

        

}

}
