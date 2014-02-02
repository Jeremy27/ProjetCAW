package fr.univ.lehavre.caw.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		// TO DO : renvoie sur la page d'accueil
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String carac = request.getParameter("caractere");
		
		int val =(int)carac.charAt(0);
		String carac_decimal = new String(val+""); 
		String carac_hexa = Integer.toString(val, 16);
		String carac_html = "&#"+val;
		String carac_unicode = "&0x"+carac_hexa;

		String s = "{\"carac\":\""+carac+"\",\"decimal\":\""+carac_decimal+"\",\"hexa\":\""+carac_hexa+"\",\"html\":\""+carac_html+"\",\"unicode\":\""+carac_unicode+"\"}";
	
		System.out.println(s);
		
		// TO DO : renvoie les valeurs converties au client
		
	}

}
