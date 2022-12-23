<%@page import = "java.util.ArrayList" %>
<%@page import = "com.SearchEngine.SearchResult" %>

<html>
<head>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<form action = "Search">
            <input type = "text" name = "keyWord">
            <button type = "submit">Search</button>
</form>
    <div class="ResultTable">
    <table border = 2>
    <tr>
        <td> TITLE </td>
        <td> LINK </td>
     </tr>
     <% ArrayList<SearchResult> results = (ArrayList<SearchResult>)request.getAttribute("results");
     for(SearchResult result:results){ %>
     <tr>
       <td><%out.println(result.getPageTitle());%></td>
        <td><a href="<%out.println(result.getPageLink());%>"> <%out.println(result.getPageLink());%></a></td>
       </tr>
       <% } %>
    </table>
    </div>
</body>
</html>