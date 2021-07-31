/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wuzzufjobs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import smile.data.DataFrame;

/**
 *
 * @author rohanda
 *
 */
@Controller

public class WuzzufController {

    @RequestMapping(value = "/")
    public String Home(Map<String, Object> model) throws IOException, URISyntaxException {
        PrepareData cdata = new PrepareData();
        return "index";
    }

    @RequestMapping(value = "/displayData")
    public String getData(Map<String, Object> model) throws IOException, URISyntaxException {
        PrepareData cdata = new PrepareData();
        //DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        PrepareData mdata = new PrepareData();
        DataFrame read_csv = mdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        ManipulateData newdata = new ManipulateData();

        // HashMap<String, Object> data = new HashMap<String, Object>();
        //data.put("labels", wuzzuf.names());
        //data.put("values", "HI");
        //model.put("DataStructure", dm.convertTable2StringList(structure));
        //model.put("StructureHeads", dm.getTableHeads(structure));
        //  model.put("DataSummary", dm.convertTable2StringList(summary));
        //model.put("SummaryHeads", dm.getTableHeads(summary));
        String[] titles = read_csv.apply("Title").toStringArray();
        String[] companies = read_csv.apply("Company").toStringArray();
        String[] locations = read_csv.apply("Location").toStringArray();
        String[] types = read_csv.apply("Type").toStringArray();
        String[] level = read_csv.apply("Level").toStringArray();
        String[] years_of_Exp = read_csv.apply("YearsExp").toStringArray();
        String[] countries = read_csv.apply("Country").toStringArray();
        String[] skills = read_csv.apply("Skills").toStringArray();
        
        

        model.put("titles", titles);
        model.put("companies", companies);
        model.put("locations", locations);
        model.put("level", level);
        model.put("types", types);
        model.put("years_of_Exp", years_of_Exp);
        model.put("countries", countries);
        model.put("skills", skills);
        

        return "read";
    }
    
        @RequestMapping(value = "/summarydisplay")
        public String summary(Map<String, Object> model) throws IOException, URISyntaxException {

            //PrepareData cdata = new PrepareData();
            //DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
            //ManipulateData mdata = new ManipulateData();
            //DataFrame cleaned_data = mdata.clean_data(wuzzuf);
            //Map<String, Long> displaySummary = mdata.displaySummary(wuzzuf);
            //Set<String> a = displaySummary.keySet();
            //List<String> x_values = new ArrayList<>(a);
            //Collection<Long> b = count_skills.values();
            //List<Long> y_values = new ArrayList<>(b);
            //model.put("b", y_values);
            //model.put("a", x_values);

              
            
            
            
            return "summary";
        }

    @RequestMapping(value = "/displayCleanData")
    public String getCleanedData(Map<String, Object> model) throws IOException, URISyntaxException {
        PrepareData cdata = new PrepareData();
        DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        ManipulateData mdata = new ManipulateData();
        DataFrame cleaned_data = mdata.clean_data(wuzzuf);

        // HashMap<String, Object> data = new HashMap<String, Object>();
        //data.put("labels", wuzzuf.names());
        //data.put("values", "HI");
        //model.put("DataStructure", dm.convertTable2StringList(structure));
        //model.put("StructureHeads", dm.getTableHeads(structure));
        //  model.put("DataSummary", dm.convertTable2StringList(summary));
        //model.put("SummaryHeads", dm.getTableHeads(summary));
        String[] titles = cleaned_data.apply("Title").toStringArray();
        String[] companies = cleaned_data.apply("Company").toStringArray();
        String[] locations = cleaned_data.apply("Location").toStringArray();
        String[] types = cleaned_data.apply("Type").toStringArray();
        String[] level = cleaned_data.apply("Level").toStringArray();
        String[] years_of_Exp = cleaned_data.apply("YearsExp").toStringArray();
        String[] countries = cleaned_data.apply("Country").toStringArray();
        String[] skills = cleaned_data.apply("Skills").toStringArray();

        model.put("titles", titles);
        model.put("companies", companies);
        model.put("locations", locations);
        model.put("level", level);
        model.put("types", types);
        model.put("years_of_Exp", years_of_Exp);
        model.put("countries", countries);
        model.put("skills", skills);

        return "cleandata";
    }
    
        @RequestMapping(value = "/displayfactorizedyear")
    public String getfactorizedData(Map<String, Object> model) throws IOException, URISyntaxException {
        PrepareData cdata = new PrepareData();
        //DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        PrepareData mdata = new PrepareData();
        DataFrame read_csv = mdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        ManipulateData newdata = new ManipulateData();

        // HashMap<String, Object> data = new HashMap<String, Object>();
        //data.put("labels", wuzzuf.names());
        //data.put("values", "HI");
        //model.put("DataStructure", dm.convertTable2StringList(structure));
        //model.put("StructureHeads", dm.getTableHeads(structure));
        //  model.put("DataSummary", dm.convertTable2StringList(summary));
        //model.put("SummaryHeads", dm.getTableHeads(summary));
        String[] titles = read_csv.apply("Title").toStringArray();
        String[] companies = read_csv.apply("Company").toStringArray();
        String[] locations = read_csv.apply("Location").toStringArray();
        String[] types = read_csv.apply("Type").toStringArray();
        String[] level = read_csv.apply("Level").toStringArray();
        String[] years_of_Exp = read_csv.apply("YearsExp").toStringArray();
        String[] countries = read_csv.apply("Country").toStringArray();
        String[] skills = read_csv.apply("Skills").toStringArray();
        String[] factorize_yearsExp = newdata.encodeCategory(read_csv, "YearsExp");
        

        model.put("titles", titles);
        model.put("companies", companies);
        model.put("locations", locations);
        model.put("level", level);
        model.put("types", types);
        model.put("years_of_Exp", years_of_Exp);
        model.put("countries", countries);
        model.put("skills", skills);
        model.put("factorize_yearsExp", factorize_yearsExp);

        return "readyears";
    }

    @RequestMapping(value = "/popularjobtitle")
    public String mostjobs(Map<String, Object> model) throws IOException, URISyntaxException {
        PrepareData cdata = new PrepareData();
        DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        ManipulateData mdata = new ManipulateData();
        DataFrame cleaned_data = mdata.clean_data(wuzzuf);
        Map<String, Integer> count_title = mdata.count_title(wuzzuf);
        Set<String> titles = count_title.keySet();
        List<String> x_values = new ArrayList<>(titles);
        Collection<Integer> value_title = count_title.values();
        List<Integer> y_values = new ArrayList<>(value_title);
        model.put("value_title", y_values);
        model.put("titles", x_values);

        return "popularjobtitle";
    }

    @RequestMapping(value = "/popularjobpercompany")
    public String mostjobspercompany(Map<String, Object> model) throws IOException, URISyntaxException {
        PrepareData cdata = new PrepareData();
        DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        ManipulateData mdata = new ManipulateData();
        DataFrame cleaned_data = mdata.clean_data(wuzzuf);
        Map<String, Integer> count_job = mdata.count_job(wuzzuf);
        Set<String> a = count_job.keySet();
        List<String> x_values = new ArrayList<>(a);
        Collection<Integer> b = count_job.values();
        List<Integer> y_values = new ArrayList<>(b);
        model.put("b", y_values);
        model.put("a", x_values);

        return "mostjobscompany";
    }

    @RequestMapping(value = "/populararea")
    public String mostarea(Map<String, Object> model) throws IOException, URISyntaxException {

        PrepareData cdata = new PrepareData();
        DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        ManipulateData mdata = new ManipulateData();
        DataFrame cleaned_data = mdata.clean_data(wuzzuf);
        Map<String, Integer> count_area = mdata.count_area(wuzzuf);
        Set<String> a = count_area.keySet();
        List<String> x_values = new ArrayList<>(a);
        Collection<Integer> b = count_area.values();
        List<Integer> y_values = new ArrayList<>(b);
        model.put("b", y_values);
        model.put("a", x_values);
        return "mostpopulararea";
    }

        @RequestMapping(value = "/skill")
        public String mostskill(Map<String, Object> model) throws IOException, URISyntaxException {

            PrepareData cdata = new PrepareData();
            DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
            ManipulateData mdata = new ManipulateData();
            DataFrame cleaned_data = mdata.clean_data(wuzzuf);
            Map<String, Long> count_skills = mdata.count_skills(wuzzuf);
            Set<String> a = count_skills.keySet();
            List<String> x_values = new ArrayList<>(a);
            Collection<Long> b = count_skills.values();
            List<Long> y_values = new ArrayList<>(b);
            model.put("b", y_values);
            model.put("a", x_values);

              
            
            
            
            return "skills";
        } 

    @RequestMapping(value = "/titleChart")
    public String title_chart(Model model) throws IOException, URISyntaxException {
        PrepareData cdata = new PrepareData();
        DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        ManipulateData mdata = new ManipulateData();
        DataFrame cleaned_data = mdata.clean_data(wuzzuf);
        Map<String, Integer> count_title = mdata.count_title(wuzzuf);
        Set<String> a = count_title.keySet();
        List<String> x_values = new ArrayList<>(a);
        Collection<Integer> b = count_title.values();
        List<Integer> y_values = new ArrayList<>(b);
        List<List> chart_data = new ArrayList<List>();

        // Take only a subset of the map data
        HashMap sub_titles = new HashMap();
        int i = 0;
        for (String name : count_title.keySet()) {
            if (i > 4) {
                break;
            }
            sub_titles.put(name, count_title.get(name));
            i++;
        }

        model.addAttribute("chartData", sub_titles);

        return "populartitlechart";
    }

    @RequestMapping(value = "/companyChart")
    public String company_chart(Model model) throws IOException, URISyntaxException {
        PrepareData cdata = new PrepareData();
        DataFrame wuzzuf = cdata.read_csv("src/main/resources/static/Wuzzuf_Jobs.csv");
        ManipulateData mdata = new ManipulateData();
        DataFrame cleaned_data = mdata.clean_data(wuzzuf);
        Map<String, Integer> count_comp = mdata.count_job(wuzzuf);
        Set<String> a = count_comp.keySet();
        List<String> x_values = new ArrayList<>(a);
        Collection<Integer> b = count_comp.values();
        List<Integer> y_values = new ArrayList<>(b);
        List<List> chart_data = new ArrayList<List>();

        HashMap companies = new HashMap();
        int i = 0;
        for (String name : count_comp.keySet()) {
            if (i > 3) {
                break;
            }
            companies.put(name, count_comp.get(name));
            i++;
        }
        model.addAttribute("chartData", companies);

        return "jobspercompanychart";
    }

}
