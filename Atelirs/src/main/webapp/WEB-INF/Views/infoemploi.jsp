<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Arrays"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styleadmin.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wgh@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="main_container">
             <div class="item"   >
               <h1 style="text-align: center; color: black; padding: 5px;">Training schools</h1> 
              <table id="customers">
                  <tr>
                                    <th>Image</th>
                  <th>Id</th>
                    <th>Nom emploi</th>
                    <th>Niveaux</th>
                    <th>abbr</th>
                  </tr>
                   <c:forEach  items="${id}" var ="id" varStatus="status">
                   <tr>
                   <td ><img src="css/image/pic-4.jpg" class="image"></td>
                      <td>${id}</td>
          <td>${Nom_emploi[status.index]}</td>
                    <td>${Niveaux[status.index]}</td>
                    <td>${abbr[status.index]}</td>
                  </tr>
                  </c:forEach>
                </table>
             </div>
             </div>
</body>
</html>