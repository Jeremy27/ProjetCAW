package fr.univ.lehavre.caw.Outils;

import java.util.Map;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObjectBuilder;

public class MapVersJson {
    public static String conversionJson(Map<String, String> map) {
        JsonBuilderFactory factory = Json.createBuilderFactory(map);
        JsonObjectBuilder job = factory.createObjectBuilder();
        for(Map.Entry<String, String> me:map.entrySet()) {
            
            job.add(me.getKey(), me.getValue());
        }

        return job.build().toString();
    }
}
