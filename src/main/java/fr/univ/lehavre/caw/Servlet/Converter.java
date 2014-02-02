package fr.univ.lehavre.caw.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObjectBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Converter
 */
public class Converter extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @param request le contenu de la requête transmise au serveur
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        char caractere = request.getQueryString().charAt(0);
        int val = conversionDec(caractere);
        String hex = conversionHex(val);
        String html = conversionHTML(val);
        String unicode = conversionUnicode(hex);
        
        HashMap<String, String> conversions = new HashMap<>();
        conversions.put("dec", Integer.toString(val));
        conversions.put("hex", hex);
        conversions.put("html", html);
        conversions.put("unicode", unicode);
        
        
        JsonBuilderFactory factory = Json.createBuilderFactory(conversions);
        JsonArrayBuilder array = factory.createArrayBuilder();
        
        for(Map.Entry<String, String> me:conversions.entrySet()) {
            JsonObjectBuilder job = factory.createObjectBuilder();
            job.add(me.getKey(), me.getValue());
            array.add(job);
        }
        
        array.build();
        
        response.setContentType("application/json; charset=UTF-8;");
        try (PrintWriter out = response.getWriter()) {
            out.println(array.toString());
        }
    }
    
    private String conversionHex(int val) {
        return Integer.toHexString(val);
    }
    
    private int conversionDec(char c) {
        return Character.getNumericValue(c);
    }
    
    private String conversionHTML(int val) {
        return "&#" + val + ";";
    }
    
    private String conversionUnicode(String hex) {
        return "\\u" + hex;
    }

}
