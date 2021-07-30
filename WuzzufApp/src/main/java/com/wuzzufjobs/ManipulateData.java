/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wuzzufjobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import smile.data.DataFrame;
import smile.data.measure.NominalScale;
import smile.data.vector.BaseVector;
import smile.data.vector.Vector;

/**
 *
 * @author rohanda
 */
public class ManipulateData {

    public DataFrame clean_data(DataFrame wuzdata) {
        DataFrame nonNullData = wuzdata.omitNullRows();
        // TODO Remove duplications
        return nonNullData;
    }

    public Map<String, Integer> count_job(DataFrame wuzdata) {
        Map map = wuzdata.stream()
                .collect(Collectors.groupingBy(t -> t.getString("Company"), Collectors.counting()));
        int[] count_of_jobs = ((Collection<Long>) map.values())
                .stream().mapToInt(i -> i.intValue())
                .toArray();
        List<String> companies = new ArrayList<String>(map.keySet());
        int i = 0;
        Map<String, Integer> comp_map = new HashMap<>();

        while (i < companies.size()) {
            comp_map.put(companies.get(i), count_of_jobs[i]);
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
    public Map<String, Integer> count_title(DataFrame wuzdata) {
        Map map = wuzdata.stream()
                .collect(Collectors.groupingBy(t -> t.getString("Title"), Collectors.counting()));
        // Stream<Map.Entry<Object,String>> title_sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());

        int[] count_of_titles = ((Collection<Long>) map.values())
                .stream().mapToInt(i -> i.intValue())
                .toArray();
        List<String> titles = new ArrayList<String>(map.keySet());
        int i = 0;
        Map<String, Integer> comp_map = new HashMap<>();

        while (i < titles.size()) {
            comp_map.put(titles.get(i), count_of_titles[i]);
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
    public Map<String, Integer> count_area(DataFrame wuzdata) {
        Map map = wuzdata.stream()
                .collect(Collectors.groupingBy(t -> t.getString("Country"), Collectors.counting()));
        //Stream<Map.Entry<Object,String>> area_sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
        int[] count_of_areas = ((Collection<Long>) map.values())
                .stream().mapToInt(i -> i.intValue())
                .toArray();
        List<String> area = new ArrayList<String>(map.keySet());
        int i = 0;
        Map<String, Integer> comp_map = new HashMap<>();

        while (i < area.size()) {
            comp_map.put(area.get(i), count_of_areas[i]);
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

    public Map count_skills(DataFrame wuzdata) {

        String[] skills_column = wuzdata.apply("Skills").toStringArray();
        ArrayList<String> skills_str = new ArrayList<String>();

        for (String s : skills_column) {
            String[] s2 = s.split(", ");
            for (String results : s2) {
                skills_str.add(results);
                System.out.println(results);
            }
        }
        //System.out.println(skills_results);

        Map<String, Long> result = skills_str.stream().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        Map<String, Long> finalMap = new LinkedHashMap<>();
        //Sort a map and add to finalMap
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        //How many each repeated skills and order the output
        System.out.println(finalMap);
        return finalMap;

    }

    public static int[] encodeCategory(DataFrame df, String columnName) {
        String[] values = df.stringVector(columnName).distinct().toArray(new String[]{});
        System.out.println("*****************");
        System.out.println(values);
        int i = 0;
        while (i < values.length) {
            System.out.println(values[i]);
            i++;
        }

        int[] pclassValues = df.stringVector(columnName).factorize(new NominalScale(values)).toIntArray();
        return pclassValues;
    }

}
