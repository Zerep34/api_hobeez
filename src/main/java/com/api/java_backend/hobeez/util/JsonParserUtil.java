package com.api.java_backend.hobeez.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class JsonParserUtil {

    public ArrayList<String[]> getElementFromJson(String reponse){
        JsonObject resultJson = new com.google.gson.JsonParser().parse(reponse).getAsJsonObject();
        String results = resultJson.get("results").toString();

        String[] split_list = results.split(",\"");

        ArrayList<String[]> l_reponse = new ArrayList<>();
        String[] t = new String[3];
        int compt = 0;
        for (String s: split_list) {
            System.out.println(s);
            if (s.contains("name") || s.contains("vicinity") || s.contains("rating\":")){
                if(s.contains("name")) {
                    s = s.replace("name\":\"","");
                    s = s.substring(0, s.length()-1);
                }
                else if(s.contains("vicinity")){
                    s = s.replace("vicinity\":\"","");
                    s = s.substring(0, s.indexOf("\""));
                }
                else{
                    s = s.replace("rating\":", "");
                }
                t[compt] = s;
                compt++;
                if(compt == 3){
                    compt = 0;
                    l_reponse.add(t);
                }
            }
        }
        return l_reponse;
    }

    public JsonObject createJson(String reponse){
        ArrayList<String[]> liste = this.getElementFromJson(reponse);

        int rand = (int) Math.random() * ( liste.size() );

        String phrase = "L'activité se trouve à " + liste.get(rand)[2] + ", le nom de l'activité est " + liste.get(rand)[0] +
                " elle a une note de " + liste.get(rand)[1] + " sur Google";

        String json = String.format("{\"fulfillmentText\": \"%s\"}", phrase);

        System.out.println(json);
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        return jsonObject;
    }
}
