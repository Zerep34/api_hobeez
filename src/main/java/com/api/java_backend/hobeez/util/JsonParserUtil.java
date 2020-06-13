package com.api.java_backend.hobeez.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonParserUtil {

    public ArrayList<Map<String, String>> getElementFromJson(String reponse) {
        JsonObject resultJson = new com.google.gson.JsonParser().parse(reponse).getAsJsonObject();
        String results = resultJson.get("results").toString();

        String[] split_list = results.split(",\"");

        ArrayList<Map<String, String>> l_reponse = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        int compt = 0;
        for (String s : split_list) {
            if (s.contains("name") || s.contains("vicinity") || s.contains("rating\":")) {
                if (s.contains("name")) {
                    s = s.replace("name\":\"", "");
                    s = s.substring(0, s.length() - 1);
                    map.put("nom", s);
                } else if (s.contains("vicinity")) {
                    s = s.replace("vicinity\":\"", "");
                    s = s.substring(0, s.indexOf("\""));
                    map.put("adresse", s);
                } else {
                    s = s.replace("rating\":", "");
                    map.put("note", s);
                }

                compt++;
                if (compt == 3) {
                    compt = 0;
                    l_reponse.add(map);
                    map = new HashMap<>();
                }
            }
        }
        return l_reponse;
    }

    public JsonObject createJson(String response) {
        String phrase;

        if (!response.contains("ZERO_RESULTS")) {
            ArrayList<Map<String, String>> liste = this.getElementFromJson(response);


            int rand = (int) (Math.random() * (liste.size()));


            phrase = "L'activité se trouve au " + liste.get(rand).get("adresse") + ", le nom de l'activité est " + liste.get(rand).get("nom") +
                    " et elle a une note de " + liste.get(rand).get("note") + " sur Google";
        } else {
            phrase = "Aucune activité n'a été trouvée pour les paramètres donnés.";
        }

        String json = String.format("{\"fulfillmentText\": \"%s\"}", phrase);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        return jsonObject;
    }
}
