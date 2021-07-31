/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wuzzufjobs;

import com.google.common.collect.Table;
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

    public  DataFrame wuz_data;

    public DataFrame read_csv(String path) throws IOException, URISyntaxException {
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();

        wuz_data = Read.csv(path, format);
        return wuz_data;

    }

    public DataFrame display_summary() {
        return wuz_data.omitNullRows().summary();

    }

    public DataFrame display_structure() {
        return wuz_data.structure();
    }
}
