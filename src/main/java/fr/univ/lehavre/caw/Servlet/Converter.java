package fr.univ.lehavre.caw.Servlet;

import fr.univ.lehavre.caw.Outils.Convertisseur;
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
        String requete = request.getQueryString();
        if(requete.length()==1) {
            char caractere = request.getQueryString().charAt(0);
            int val = Convertisseur.conversionDec(caractere);
            String hex = Convertisseur.conversionHex(val);
            String html = Convertisseur.conversionHTML(val);
            String unicode = Convertisseur.conversionUnicode(hex);

            HashMap<String, String> conversions = new HashMap<>();
            conversions.put("dec", Integer.toString(val));
            conversions.put("hex", hex);
            conversions.put("html", html);
            conversions.put("unicode", unicode);
            response.setContentType("application/json; charset=UTF-8;");
            
            String json = Convertisseur.conversionJson(conversions);
            try (PrintWriter out = response.getWriter()) {
                out.println(json);
            }
        } 
    }

}
