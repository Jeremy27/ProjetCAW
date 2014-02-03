package fr.univ.lehavre.caw.Outils;

import java.util.Map;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObjectBuilder;

public class MapVersJson {
    public static String conversionJson(Map<String, String> map) {
        JsonBuilderFactory factory = Json.createBuilderFactory(map);
        JsonArrayBuilder array = factory.createArrayBuilder();

        for(Map.Entry<String, String> me:map.entrySet()) {
            JsonObjectBuilder job = factory.createObjectBuilder();
            job.add(me.getKey(), me.getValue());
            array.add(job);
        }

        array.build();
        return array.toString();
    }
}
