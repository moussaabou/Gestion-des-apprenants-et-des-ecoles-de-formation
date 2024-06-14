<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Training course</title>
 <link rel="stylesheet" type="text/css" href="css/styleA.css">
        <link rel="stylesheet" href="css/form.css">

        <link href="https://fonts.googleapis.com/css2?family=Roboto:wgh@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    </head>
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
                    </i></span>
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

                   <li><a href="EtabComp" >
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
                       <form:form method="post" action="/EtabAddform" modelAttribute="user">
            <fieldset>
            <table>
               <tr>
				<td><form:label path="NomFormation">Nom Formation </form:label></td>
				<td><form:input  type="text" path="NomFormation" /></td>
			</tr>
			<tr>
				<td><form:label path="prix">prix</form:label></td>
				<td><form:input  type="text" path="prix" /></td>
			</tr>
			<tr>
				<td><form:label path="DateDebut">Date Debut</form:label></td>
				<td><form:input  type="text" path="DateDebut" /></td>
			</tr>
			<tr>
				<td><form:label path="DateFin">Date Fin:</form:label></td>
				<td><form:input  type="text" path="DateFin" /></td>
			</tr>
			
			<tr>
				<td><form:label path="idFormation">id Formateur</form:label></td>
				<td><form:input  type="text" path="idFormation"/></td>
			</tr>
			 </table>
			<h1>${Eruure}</h1>
			<input type="submit" value="Modifer" style="border: 1px solid #ddd;  padding: 5px; margin: 5px ;background-color:#2e4ead; color: #fff; font-size: 15px; text-align: center;">
            </fieldset>
        </form:form> </div> </div>
           </body>
           </html>