package com.SearchEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
@WebServlet("/History")
public class History extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            Connection connection = DataBaseConnection.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from HistoryTable");
            ArrayList<HistoryResult> results = new ArrayList<HistoryResult>();
            while(resultSet.next()){
                HistoryResult result = new HistoryResult();
                result.setKeyWord(resultSet.getString("keyword"));
                result.setLink(resultSet.getString("pageLink"));
                results.add(result);
            }
            request.setAttribute("results",results);
            request.getRequestDispatcher("/History.jsp").forward(request,response);
            response.setContentType("text/Html");
            PrintWriter out = response.getWriter();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
