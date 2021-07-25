/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wuzzufjobs;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import smile.data.DataFrame;

/**
 *
 * @author rohanda
 */
public class ManipulateData {
    private static DataFrame wuzdata;

    public ManipulateData(DataFrame data) {
        wuzdata = data;
    }
    
    public DataFrame clean_data(){
         DataFrame nonNullData= wuzdata.omitNullRows ();
         // TODO Remove duplications
         return nonNullData;
    }
    public Stream<Map.Entry<Object,String>> count_job(){
        Map map = wuzdata.stream()
                .collect (Collectors.groupingBy (t ->t.getString("Company"), Collectors.counting ()));
        Stream<Map.Entry<Object,String>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
    /*
    for (Object name: map.keySet()) {
    String key = name.toString();
    String value = map.get(name).toString();
    System.out.println(key + " " + value);
    }*/
                
        return sorted;
    }
    
}
