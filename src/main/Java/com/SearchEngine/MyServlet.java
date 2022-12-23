package com.SearchEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/Html");
        PrintWriter out = response.getWriter();
        out.println("<h3> This is My Servlet</h3>");
    }
}
