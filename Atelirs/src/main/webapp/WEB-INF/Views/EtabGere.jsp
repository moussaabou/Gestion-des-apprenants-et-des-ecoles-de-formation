<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
          <%@ page import="java.util.Arrays"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styleA.css">
        <link rel="stylesheet" href="css/form.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wgh@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    </head>
    <body>
       <div class="wrapper">
           <div class="top_navbar">
               <div class="hamburger">
                  <div></div>
                  <div></div> 
                  <div></div>  
               </div>
               <div class="top_menu">
                   <div class="logo">Dawarat</div>
                   <ul>
                       <li><a href="#"><i class="fa fa-search" aria-hidden="true"></i>
                       </a></li>
                       <li><a href="#"><i class="fa fa-bell" aria-hidden="true"></i></a></li>
                       <li><a href="#"><i class="fa fa-user"></i></a></li>
                       <li>${nom} ${prenom}</li>
                   </ul>
               </div>
           </div>
           <div class="sidebar">
               <ul>
                <li>
                    <a href="">
                    <span class="icon">
                        <i class="fa fa-home"></i>
                        </span>
                    <span class="title">Home</span> </a>
                   </li> 

                <li><a href="Etablissement" class="active">
                    <span class="icon"><i class="fa fa-users" aria-hidden="true"></i>   
                    </span>
                    <span class="title" style="font-size: 14px;">Application processing</span>
                   </a></li>

                   <li><a href="EtabGest" >
                    <span class="icon"><i class="fa fa-graduation-cap" aria-hidden="true"></i>
                    </span>
                    <span class="title">Training course</span>
                   </a></li>

                   <li><a href="Offer_emploi" >
                    <span class="icon"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></span>
                    <span class="title">Jop offer</span>
                   </a></li>


                   <li><a href="#">
                       <span class="icon"><i class="fa fa-bar-chart" aria-hidden="true"></i>
                       </span>
                       <span class="title">Statistics</span>
                   </a></li>

                   <li><a href="#" >
                    <span class="icon"><i class="fa fa-comment"></i></span>
                    <span class="title">Communication</span>
                   </a></li>

                   <li><a href="EtabComp">
                    <span class="icon">
                        <i class="fa fa-cog"></i>
                        </span>
                    <span class="title">Setting</span>
                   </a></li>
               </ul>            </div> 
               
               <!-- ----------------------------------------------------------------------------------------------------- -->
       <div class="main_container">
             <div class="item"   >
               <h1 style="text-align: center; color: black; padding: 5px;">Training offers</h1> 
              <table id="customers">
                  <tr>
                  <th>Id</th>
                    <th>Nom Formatio</th>
                    <th>id Formateur</th>
                    <th>Prix</th>
                    <th>date_fin</th>
                    <th>date_debut</th>
                    <th>Niveaux</th>
                    <th>Delte</th>
                  </tr>
                   <c:forEach  items="${id}" var ="id" varStatus="status">
                   <tr>
                    <form:form method="post" action="/EtabformSupp" modelAttribute="user">
                      <td><form:input path="id" value="${id}" style= "margin:3px;"/></td>
          <td>${NomFormatio[status.index]}</td>
          <td>${idFormateur[status.index]}</td>
          <td>${Prix[status.index]}</td>
           <td>${date_fin[status.index]}</td>
                    <td>${date_debut[status.index]}</td>
                    <td>${Niveaux[status.index]}</td>
                    <td><input class="Delet" type="submit" value="Delet" ></td>
                  </form:form>
                  </tr>
                  </c:forEach>
                </table>
              </div>
               <div class="item"   >
               <h1 style="text-align: center; color: black; padding: 5px;">Training offers</h1> 
              <table id="customers">
                  <tr>
                  <th>Id</th>
                    <th>Nom Formatio</th>
                    <th>id Formateur</th>
                    <th>Prix</th>
                    <th>date_fin</th>
                    <th>date_debut</th>
                    <th>Niveaux</th>
                    <th>Modefir</th>
                  </tr>
                   <c:forEach  items="${id}" var ="id" varStatus="status">
                   <tr>
  <form:form method="post" action="/EtabformModf" modelAttribute="user">
         <td><form:input path="id" value="${id}" style= "margin:3px;"/></td>
          <td><form:input  type="texte" value="${NomFormatio[status.index]}" path="NomFormation"/></td>
          <td><form:input type="texte" value="${idFormateur[status.index]}" path="idFormation"/></td>
          <td><form:input type="texte" value="${Prix[status.index]}" path="prix"/></td>
           <td><form:input type="texte" value="${date_fin[status.index]}" path="DateFin"/></td>
                    <td><form:input type="texte" value="${date_debut[status.index]}" path="DateDebut"/></td>
                    <td><form:input type="texte" value="${Niveaux[status.index]}" path="niveau"/></td>
                    <td><input type="submit" value="Modifer" /></td>
                 
                 </form:form> </tr>
                  </c:forEach>
                </table>
              </div>  </div> </div>
           </body>