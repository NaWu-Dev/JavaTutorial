package com.nana.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try{

            // create object mapper
            ObjectMapper objectMapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO : data/sample-lite.json
            Student theStudent = objectMapper.readValue(new File("data/sample-lite.json"), Student.class);

            // print out first name and last name
            System.out.println(theStudent.getFirstName());
            System.out.println(theStudent.getLastName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
