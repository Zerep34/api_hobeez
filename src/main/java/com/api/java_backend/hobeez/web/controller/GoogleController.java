package com.api.java_backend.hobeez.web.controller;

import com.api.java_backend.hobeez.util.JsonParserUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

@RestController
@RequestMapping(path="api/hobeez/google")
public class GoogleController {

    String API_KEY = "AIzaSyCL1grfGNMygaod44vtCJQWZSShgweACY0";

    private JsonParserUtil jsonParser;

    public GoogleController(){
        this.jsonParser = new JsonParserUtil();
    }

    @GetMapping(path="/nearby")
    public @ResponseBody String google_nearby (@RequestParam String perimetre,
                                               @RequestParam String longitude,
                                               @RequestParam String lattitude,
                                               @RequestParam String l_type_raw) throws IOException {
        perimetre = perimetre + "000";

        if(l_type_raw.equals("empty")){
            String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&key=%s", lattitude, longitude, perimetre, API_KEY);
            System.out.println(url);
            URL googleapi = new URL(url);
            URLConnection yc = googleapi.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            String json = "";

            while ((inputLine = in.readLine()) != null){
                json += inputLine;
            }
            in.close();
            return json;
        }
        else{
            String result = "";
            String[] l_type = l_type_raw.split(",");
            for (String type: l_type) {
                String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&type=%s&opennow=true&key=%s&opennow=true", lattitude, longitude, perimetre, type, API_KEY);
                URL googleapi = new URL(url);
                URLConnection yc = googleapi.openConnection();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                yc.getInputStream()));
                String inputLine;

                String json = "";

                while ((inputLine = in.readLine()) != null){
                    json += inputLine;
                }
                in.close();
                result += json;
            }
            return result;
        }
    }

    @GetMapping(path="/details")
    public @ResponseBody String google_details (@RequestParam String place_id) throws IOException {
        String url = String.format("https://maps.googleapis.com/maps/api/place/details/json?place_id=%s&fields=address_component,adr_address,formatted_address,geometry,icon,name,plus_code,type,formatted_phone_number,opening_hours,website,price_level,rating&key=%s", place_id, API_KEY);
        URL googleapi = new URL(url);
        URLConnection yc = googleapi.openConnection();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        String json = "";

        while ((inputLine = in.readLine()) != null){
            json += inputLine;
        }
        in.close();
        return json;
    }

    @GetMapping(path="/refresh")
    public @ResponseBody String google_details (@RequestParam String perimetre,
                                                @RequestParam String longitude,
                                                @RequestParam String lattitude,
                                                @RequestParam String l_type_raw,
                                                @RequestParam String refresh_token) throws IOException {
        perimetre = perimetre + "000";

        if(l_type_raw.equals("empty")){
            String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&opennow=true&key=%s", lattitude, longitude, perimetre, API_KEY, refresh_token);
            URL googleapi = new URL(url);
            URLConnection yc = googleapi.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            String json = "";

            while ((inputLine = in.readLine()) != null){
                json += inputLine;
            }
            in.close();
            return json;
        }
        else{
            String result = "";
            String[] l_type = l_type_raw.split(",");
            for (String type: l_type) {
                String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&type=%s&opennow=true&key=%s&pagetoken=%s", lattitude, longitude, perimetre, type, API_KEY);
                URL googleapi = new URL(url);
                URLConnection yc = googleapi.openConnection();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                yc.getInputStream()));
                String inputLine;

                String json = "";

                while ((inputLine = in.readLine()) != null){
                    json += inputLine;
                }
                in.close();
                result += json;
            }
            return result;
        }
    }

    @PostMapping(path="/ghome")
    public @ResponseBody String google_home (@RequestParam String perimetre,
                                                @RequestParam String longitude,
                                                @RequestParam String lattitude,
                                                @RequestParam String categorie) throws IOException {
        perimetre = perimetre + "000";

        if(categorie.equals("empty")){ // TODO a voir avec Antoine
            String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&opennow=true&key=%s", lattitude, longitude, perimetre, API_KEY);
            URL googleapi = new URL(url);
            URLConnection yc = googleapi.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            String json = "";

            while ((inputLine = in.readLine()) != null){
                json += inputLine;
            }
            in.close();

            return jsonParser.createJson(json).toString();


        }
        else{
            String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&type=%s&opennow=true&key=%s&pagetoken=%s", lattitude, longitude, perimetre, categorie, API_KEY);
            URL googleapi = new URL(url);
            URLConnection yc = googleapi.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            String json = "";

            while ((inputLine = in.readLine()) != null){
                json += inputLine;
            }
            in.close();
            return jsonParser.createJson(json).toString();
        }
    }

}

