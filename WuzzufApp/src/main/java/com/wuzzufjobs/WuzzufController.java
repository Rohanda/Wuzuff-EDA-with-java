/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wuzzufjobs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
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
@RestController


public class WuzzufController {

	@GetMapping(value = "/")
	public String getData() throws IOException, URISyntaxException {
            PrepareData cdata = new PrepareData();
            DataFrame wuzzuf = cdata.read_csv("src/main/resources/Wuzzuf_Jobs.csv");
            HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("labels", wuzzuf.names());
		data.put("values", "HI");

		JSONObject response = new JSONObject(data);
                
            return "index";
	}
    
    
}
