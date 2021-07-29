/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wuzzufjobs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import smile.data.DataFrame;
import smile.data.measure.NominalScale;
import smile.data.vector.BaseVector;

/**
 *
 * @author rohanda
 */
public class ManipulateData {

    
    public DataFrame clean_data(DataFrame wuzdata){
         DataFrame nonNullData= wuzdata.omitNullRows ();
         // TODO Remove duplications
         return nonNullData;
    }
    public Map<String, Integer> count_job(DataFrame wuzdata){
        Map map = wuzdata.stream()
                .collect (Collectors.groupingBy (t ->t.getString("Company"), Collectors.counting ()));
           int[] count_of_jobs = ((Collection<Long>) map.values ())
                .stream ().mapToInt (i -> i.intValue ())
                .toArray (); 
        List<String> companies =  new ArrayList<String>( map.keySet());
        int i = 0;
        Map<String, Integer> comp_map = new HashMap<>();

        while (i < companies.size()) {
            comp_map.put(companies.get(i),count_of_jobs[i]);
            i++;
        }
         Map<String, Integer> result = comp_map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        //Stream<Map.Entry<Object,String>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
    /*
    for (Object name: map.keySet()) {
    String key = name.toString();
    String value = map.get(name).toString();
    System.out.println(key + " " + value);
    }*/
                
        return result;
    }
    
    //counting the title
     public  Map<String, Integer> count_title(DataFrame wuzdata){
        Map map = wuzdata.stream()
                .collect (Collectors.groupingBy (t ->t.getString("Title"), Collectors.counting ()));
       // Stream<Map.Entry<Object,String>> title_sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
    
        
        int[] count_of_titles = ((Collection<Long>) map.values ())
                .stream ().mapToInt (i -> i.intValue ())
                .toArray (); 
        List<String> titles =  new ArrayList<String>( map.keySet());
        int i = 0;
        Map<String, Integer> comp_map = new HashMap<>();

        while (i < titles.size()) {
            comp_map.put(titles.get(i),count_of_titles[i]);
            i++;
        }
         Map<String, Integer> result = comp_map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }   
     

    //counting the location
     public Map<String, Integer> count_area(DataFrame wuzdata){
        Map map = wuzdata.stream()
                .collect (Collectors.groupingBy (t ->t.getString("Country"), Collectors.counting ()));
        //Stream<Map.Entry<Object,String>> area_sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
                int[] count_of_areas = ((Collection<Long>) map.values ())
                .stream ().mapToInt (i -> i.intValue ())
                .toArray (); 
        List<String> area =  new ArrayList<String>( map.keySet());
        int i = 0;
        Map<String, Integer> comp_map = new HashMap<>();

        while (i < area .size()) {
            comp_map.put(area .get(i),count_of_areas[i]);
            i++;
        }
         Map<String, Integer> result_area = comp_map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result_area;
    }   
  
        
        
 
    //there is error counting the location
     public Stream<Map.Entry<Object,String>> count_skills(DataFrame wuzdata){
       // BaseVector skills_column = wuzdata.apply("Skills");
       //skills_column.stream().spliterator().forEachRemaining(t->System.out.println(t));

        Map map = wuzdata.stream().collect (Collectors.groupingBy (t ->t.getString("Skills").split(","), Collectors.counting ()));
       
       Stream<Map.Entry<Object,String>> count_skills = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
  
        return count_skills;
    } 
         public static int[] encodeCategory(DataFrame df, String columnName) {
        String[] values = df.stringVector (columnName).distinct ().toArray (new String[]{});
                System.out.println("*****************");
                System.out.println(values);
                int i =0;
               while( i < values.length){
                   System.out.println(values[i]);
                   i++;
               }
                
        int[] pclassValues = df.stringVector (columnName).factorize (new NominalScale (values)).toIntArray ();
        return pclassValues;
    }

}

