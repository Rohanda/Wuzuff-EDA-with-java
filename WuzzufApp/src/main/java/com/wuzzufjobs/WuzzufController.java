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
               String[] titles =  cleaned_data.apply("Title").toStringArray();
               String[] companies =  cleaned_data.apply("Company").toStringArray();
               String[] locations =  cleaned_data.apply("Location").toStringArray();
               String[] types =  cleaned_data.apply("Type").toStringArray();
               String[] level =  cleaned_data.apply("Level").toStringArray();
               String[] years_of_Exp =  cleaned_data.apply("YearsExp").toStringArray();
              String[] countries =  cleaned_data.apply("Country").toStringArray();
              String[] skills =  cleaned_data.apply("Skills").toStringArray();



         
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
            List<List>  chart_data = new ArrayList<List>();
            /*
            for(int i = 0;i<5;i++){
                chart_data.add(new ArrayList<>(Arrays.asList(x_values.get(i),y_values.get(i))));
                
            }
             
*/
            HashMap sub_titles = new HashMap();
            int i =0;
            for (String name : count_title.keySet()){
                if (i > 4)
                    break;
                sub_titles.put(name,count_title.get(name));
                i++;
            }
            model.addAttribute("chartData", sub_titles); 
         
                
            //model.addAttribute("chartData", getChartData()); 
            return "popularjobtitle";
        }
    
    
}
