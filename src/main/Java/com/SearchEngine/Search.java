package com.SearchEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Search")
public class Search extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String keyword = request.getParameter("keyWord");


        try{
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into HistoryTable values(?,?)");
            preparedStatement.setString(1,keyword);
            preparedStatement.setString(2,"http://localhost:8080/SearchEngine/Search?keyWord="+keyword);
            preparedStatement.executeUpdate();
            ResultSet resultSet = connection.createStatement().executeQuery("select pageTitle, pageLink, (length(lower(pageContent)) - length(replace(lower(pageContent),'"+keyword+"',\"\")))/length('"+keyword+"') as occurence from pages order by occurence desc;");
            ArrayList<SearchResult> results = new ArrayList<SearchResult>();
            while (resultSet.next()){
                SearchResult searchResult = new SearchResult();
                searchResult.setPageTitle(resultSet.getString("pageTitle"));
                searchResult.setPageLink(resultSet.getString("pageLink"));
                results.add(searchResult);
            }
            request.setAttribute("results", results);
            request.getRequestDispatcher("/search.jsp").forward(request,response);


        }catch (Exception sqlException){
            sqlException.printStackTrace();
        }
    }
}
