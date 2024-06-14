<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.Arrays"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
                <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            
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
              <div class="item"   >
             <label style="font-size: 25px; padding: 5px;" >  Choose:</label>
             </div>
             
             <div class="item"   >
               <h1 style="text-align: center; color: black; padding: 5px;"></h1> 
              <table id="customers">
                  <tr>
                  <th></th>
                  
                  <th>Id</th>
                    <th>Laste Name</th>
                    <th>First Name</th>
                    <th>Email</th>
                    <th>telephone number</th>
                    <th>city</th>
                    <th>region</th>
                    <th>Niveaux</th>
                    <th>filieres</th>
                    <th>diplomes</th>
                  </tr>
                              <form:form method="POST" action="/OffreDeEtabR" modelAttribute="user" >
                     <form:select path="ville"  style="border: 1px solid #ddd;  padding: 15px; background-color:#2e4ead; color: #fff; font-size: 15px; text-align: center;">
                <form:option value="0">City</form:option>    
                 <form:option value="1">1</form:option>      
                 <form:option value="2">2</form:option>
                 <form:option value="3">3</form:option>
                  <form:option value="4">4</form:option>
                 <form:option value="5">5</form:option>
               </form:select>
                <form:select path="region"  style="border: 1px solid #ddd;  padding: 15px; background-color:#2e4ead; color: #fff; font-size: 15px; text-align: center;">
                <form:option value="0" >region</form:option>    
                 <form:option value="1">1</form:option>      
                 <form:option value="2">2</form:option>
                 <form:option value="3">3</form:option>
                  <form:option value="4">4</form:option>
                 <form:option value="5">5</form:option>
               </form:select> 
               <form:select path="diplomes"  style="border: 1px solid #ddd;  padding: 15px; background-color:#2e4ead; color: #fff; font-size: 15px; text-align: center;">
                <form:option value="0" >diplomes</form:option>    
                 <form:option value="yes">YES</form:option>      
                 <form:option value="no">NO</form:option>
                 </form:select>
               <input type="submit" value="OK" style="border: 1px solid #ddd;  padding: 15px; background-color:#2e4ead; color: #fff; font-size: 15px; text-align: center;"/>
               </form:form>
                   <c:forEach  items="${id}" var ="id" varStatus="status">
                                   <tr>
                                   <td></td>
                      <td>${id}</td>
          <td>${nom[status.index]}</td>
          <td>${prenom[status.index]}</td>
          <td>${email[status.index]}</td>
          <td>${n_tel[status.index]}</td>
           <td>${ville[status.index]}</td>
                    <td>${region[status.index]}</td>
                    <td>${Niveaux[status.index]}</td>
                    <td>${filieres[status.index]}</td>
                    <td>${diplomes[status.index]}</td>
                   </tr>
                  </c:forEach>
                </table>
             </div> 
             </div>
             </div>
              <!--------------------------------------------------------------------->
   <script src="js/admin.js"></script>
</body>
</html>