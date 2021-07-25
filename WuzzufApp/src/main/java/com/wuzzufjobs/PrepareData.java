/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wuzzufjobs;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.io.Read;

/**
 *
 * @author rohanda
 */
public class PrepareData {
    private static  DataFrame wuz_data;
  
    
    public DataFrame read_csv(String path) throws IOException, URISyntaxException{
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();

        wuz_data = Read.csv(path, format);

        return wuz_data;
      
}
    
    public DataFrame display_summary() throws IOException, URISyntaxException{
        return wuz_data.summary();
    }
    public DataFrame display_structure() throws IOException, URISyntaxException{
        return wuz_data.structure();
    }
}
