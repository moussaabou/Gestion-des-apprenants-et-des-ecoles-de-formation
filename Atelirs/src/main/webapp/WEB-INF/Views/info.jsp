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
               <h1 style="text-align: center; color: black; padding: 5px;">Training offers</h1> 
              <table id="customers">
                  <tr>
                  <th></th>
                  <th>Id</th>
                    <th>Nom Formatio</th>
                    <th>id Formateur</th>
                    <th>Prix</th>
                    <th>date_fin</th>
                    <th>date_debut</th>
                    <th>Niveaux</th>
                  </tr>
                   <c:forEach  items="${id}" var ="id" varStatus="status">
                   <tr>
                   <td><img src="image/OIP.jpg" class="image"style= "margin:5px"></td>
                      <td>${id}</td>
          <td>${NomFormatio[status.index]}</td>
          <td>${idFormateur[status.index]}</td>
          <td>${Prix[status.index]}</td>
           <td>${date_fin[status.index]}</td>
                    <td>${date_debut[status.index]}</td>
                    <td>${Niveaux[status.index]}</td>
                  </tr>
                  </c:forEach>
                </table>
             </div>
             </div>
</body>
</html>