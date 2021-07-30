/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wuzzufjobs;

/**
 *
 * @author rohanda
 */
public class WuzzufJob {
    String Title;
    String Company;
    String Location;
    String Skills;

    public WuzzufJob(String Title, String Company, String Location, String Skills) {
        this.Title = Title;
        this.Company = Company;
        this.Location = Location;
        this.Skills = Skills;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String Skills) {
        this.Skills = Skills;
    }

    @Override
    public String toString() {
        return "WuzzufJob{" + "Title=" + Title + ", Skills=" + Skills + '}';
    }
    
    
    
}
