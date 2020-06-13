package com.api.java_backend.hobeez.web.controller;

import com.api.java_backend.hobeez.util.JsonParserUtil;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RestController
@RequestMapping(path = "api/hobeez/google")
public class GoogleController {

    String API_KEY = "AIzaSyCL1grfGNMygaod44vtCJQWZSShgweACY0";

    private JsonParserUtil jsonParser;

    public GoogleController() {
        jsonParser = new JsonParserUtil();
    }

    Map<String, String> map_categorie = new HashMap<>();

    @PostConstruct
    public void initialize() {
        this.map_categorie.put("Sport", "gym");
        this.map_categorie.put("Cinema", "movie_theater");
        this.map_categorie.put("Casino", "casino");
        this.map_categorie.put("Boite", "night_club");
        this.map_categorie.put("Bar", "bar");
        this.map_categorie.put("Beauté", "beauty_salon");
        this.map_categorie.put("Librairie", "library");
        this.map_categorie.put("Magasin", "supermarket");
        this.map_categorie.put("Art", "art_gallery");
        this.map_categorie.put("Restauration", "restaurant");
        this.map_categorie.put("Eglise", "church");
        this.map_categorie.put("Mosquée", "mosque");
        this.map_categorie.put("Synagogue", "synagogue");
        this.map_categorie.put("Parc", "park");
        this.map_categorie.put("Coiffeur", "hair_care");
        this.map_categorie.put("Musée", "museum");
        this.map_categorie.put("Zoo", "zoo");
        this.map_categorie.put("Spa", "spa");
        this.map_categorie.put("Stade", "stadium");
        this.map_categorie.put("Parc de jeux", "amusement_park");
        this.map_categorie.put("Bowling", "bowling_alley");
        this.map_categorie.put("Café", "cafe");
        this.map_categorie.put("Shopping", "shopping_mall");
    }

    @GetMapping(path = "/nearby")
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody
    String google_nearby(@RequestParam String perimetre,
                         @RequestParam String longitude,
                         @RequestParam String latitude,
                         @RequestParam String l_type_raw) throws IOException {
        perimetre = perimetre + "000";
        l_type_raw = this.search_in_map(l_type_raw);
        if (l_type_raw == null) {
            l_type_raw = "empty";
        }
        if (l_type_raw.equals("empty")) {
            String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&key=%s", latitude, longitude, perimetre, API_KEY);
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
                String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&type=%s&opennow=true&key=%s&opennow=true", latitude, longitude, perimetre, type, API_KEY);
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
    @PreAuthorize("hasRole('USER')")
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
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody String google_details(@RequestParam String perimetre,
                                               @RequestParam String longitude,
                                               @RequestParam String latitude,
                                               @RequestParam String l_type_raw,
                                               @RequestParam String refresh_token) throws IOException {
        perimetre = perimetre + "000";
        l_type_raw = this.search_in_map(l_type_raw);
        if (l_type_raw == null) {
            l_type_raw = "empty";
        }
        if (l_type_raw.equals("empty")) {
            String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&opennow=true&key=%s", latitude, longitude, perimetre, API_KEY, refresh_token);
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
                String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&type=%s&opennow=true&key=%s&pagetoken=%s", latitude, longitude, perimetre, type, API_KEY);
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

    @PostMapping(path = "/ghome")
    @PreAuthorize("hasRole('GHOME')")
    public @ResponseBody
    String google_home(@RequestBody String body) throws IOException {
        String[] params_from_json = this.getDistanceCategoryCity(body);
        String perimetre;
        if (Integer.parseInt(params_from_json[1]) >= 100) {
            perimetre = "1000000";
        } else {
            perimetre = params_from_json[1] + "000";
        }

        String categorie = this.search_in_map(params_from_json[2]);
        if (categorie == null) {
            categorie = "empty";
        }
        String[] coord = this.getCoordinateFromCity(params_from_json[0]);
        String latitude = coord[1];
        String longitude = coord[0];


        if (categorie.equals("empty")) { // TODO a voir avec Antoine
            String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&opennow=true&key=%s", latitude, longitude, perimetre, API_KEY);
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
            System.out.println(json);

            return jsonParser.createJson(json).toString();


        }
        else{
            String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&type=%s&opennow=true&key=%s", latitude, longitude, perimetre, categorie, API_KEY);
            URL googleapi = new URL(url);
            URLConnection yc = googleapi.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            String json = "";

            while ((inputLine = in.readLine()) != null) {
                json += inputLine;
            }
            in.close();
            return jsonParser.createJson(json).toString();
        }
    }

    public String search_in_map(String categorie_from_ghome) {
        return this.map_categorie.get(categorie_from_ghome);
    }

    public String[] getDistanceCategoryCity(String json) {
        String[] tab_results = new String[3];

        JSONObject response = new JSONObject(json);
        JSONObject query = (JSONObject) response.get("queryResult");
        JSONArray jArray = (JSONArray) query.get("outputContexts");
        JSONObject info = (JSONObject) jArray.get(0);
        JSONObject parameters = (JSONObject) info.get("parameters");
        JSONObject villeJson = (JSONObject) parameters.get("ville");
        JSONObject distanceJson = (JSONObject) parameters.get("distance");
        tab_results[0] = villeJson.get("city").toString();
        String distance_json = distanceJson.get("amount").toString();
        String part_to_remove = distance_json.substring(distance_json.indexOf("."), distance_json.length());
        tab_results[1] = distance_json.replace(part_to_remove, "");
        tab_results[2] = parameters.get("category").toString();

        return tab_results;
    }

    public String[] getCoordinateFromCity(String city) throws IOException {
        String urlString = "https://api-adresse.data.gouv.fr/search/?q=" + city;
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        Scanner s = new Scanner(is).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        JsonParser parser = new com.google.gson.JsonParser();
        String json_features = parser.parse(result).getAsJsonObject().get("features").toString();
        String coordinates = json_features.substring(json_features.indexOf("coordinates") + 14, json_features.indexOf("]"));

        return coordinates.split(",");
    }

    public static void main(String[] args) {
        Map<String, String> map_categorie = new HashMap<>();
        map_categorie.put("Sport", "gym");
        map_categorie.put("Cinema", "movie_theater");
        map_categorie.put("Casino", "casino");
        map_categorie.put("Boite", "night_club");
        map_categorie.put("Bar", "bar");
        map_categorie.put("Beauté", "beauty_salon");
        map_categorie.put("Librairie", "library");
        map_categorie.put("Magasin", "supermarket");
        map_categorie.put("Art", "art_gallery");
        map_categorie.put("Restauration", "restaurant");
        map_categorie.put("Eglise", "church");
        map_categorie.put("Mosquée", "mosque");
        map_categorie.put("Synagogue", "synagogue");
        map_categorie.put("Parc", "park");
        map_categorie.put("Coiffeur", "hair_care");
        map_categorie.put("Musée", "museum");
        map_categorie.put("Zoo", "zoo");
        map_categorie.put("Spa", "spa");
        map_categorie.put("Stade", "stadium");
        map_categorie.put("Parc de jeux", "amusement_park");
        map_categorie.put("Bowling", "bowling_alley");
        map_categorie.put("Café", "cafe");
        map_categorie.put("Shopping", "shopping_mall");
        if (map_categorie.get("t") == null) {
            System.out.println("t");
        }
    }

}

