<%@page import = "java.util.ArrayList" %>
<%@page import = "com.SearchEngine.HistoryResult" %>

<html>
<head>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<form action = "Search">
            <input type = "text" name = "keyWord">
            <button type = "submit">Search</button>
</form>
<div class = "ResultTable">
    <table border = 2>
    <tr>
        <td> KeyWord </td>
        <td> LINK </td>
     </tr>
     <% ArrayList<HistoryResult> results = (ArrayList<HistoryResult>)request.getAttribute("results");
     for(HistoryResult result:results){ %>
     <tr>
       <td><%out.println(result.getKeyWord());%></td>
       <td><a href="<%out.println(result.getLink());%>" ><%out.println(result.getLink());%></a></td>
       </tr>
       <% } %>
    </table>
    </div>
</body>
</html>