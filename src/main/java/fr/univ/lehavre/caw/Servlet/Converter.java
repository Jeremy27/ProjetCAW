package fr.univ.lehavre.caw.Servlet;

import fr.univ.lehavre.caw.Outils.Caractere;
import fr.univ.lehavre.caw.Outils.MapVersJson;
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
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("caractere");
        if(param!=null && param.length()==1) {
            char caractere = param.charAt(0);
            Caractere c = new Caractere(caractere);
            int val = c.getDecimal();
            String hex = c.getHex();
            String html = c.getHtml();
            String unicode = c.getUnicode();

            HashMap<String, String> conversions = new HashMap<>();
            conversions.put("dec", Integer.toString(val));
            conversions.put("hex", hex);
            conversions.put("html", html);
            conversions.put("unicode", unicode);



            response.setContentType("application/json; charset=UTF-8;");
            try(PrintWriter out=response.getWriter()) {
                out.println(MapVersJson.conversionJson(conversions));
            }
            
            
            
            try (PrintWriter out=response.getWriter()){
            
            request.setAttribute("unicode",conversionUnicode(hex));
            request.setAttribute("hex",conversionHex(val));
            request.setAttribute("dec",conversionDec(c));
            request.setAttribute("html",conversionHTML(val));
            
	        dispat = request.getRequestDispatcher("./Converter.jsp");  
            dispat.forward(request, response);
            
            
            
            }
            
            
            
            
            
            
            
        }
    }
}
