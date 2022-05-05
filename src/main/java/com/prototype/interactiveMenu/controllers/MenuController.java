package com.prototype.interactiveMenu.controllers;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @GetMapping
    public Object getMenu() throws FileNotFoundException {
        try (FileReader reader = new FileReader("config/menu.json")) {
            JSONParser parser = new JSONParser(reader);
            System.out.println("here");
            Object obj  = parser.parse();
            return  obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
