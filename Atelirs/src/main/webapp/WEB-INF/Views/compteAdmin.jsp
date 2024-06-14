<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Admin</title>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styleadmin.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wgh@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>        <script>
            $(document).ready(function(){
                $(".hamburger").click(function(){
                   $(".wrapper").toggleClass("collapse"); 
                });
            });
        </script>
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
                       <li><a href="#"><i class="fa fa-bell" aria-hidden="true"></i></i></a></li>
                       <li><a href="#"><i class="fa fa-user"></i></a></li>
                       <li style="color:#2e4ead; font-size: 20px;">${nom} ${prnom}</li>
                   </ul>
               </div>
           </div>
           <div class="sidebar">
               <ul>
                <li>
                    <span class="icon">
                        
                        </span>
                    <span class="title"></span>
                   </li> 

                <li><a href="AdminGere" >
                    <span class="icon"><i class="fa fa-users" aria-hidden="true"></i>
                        
                    </span>
                    <span class="title" style="font-size: 14px;">Manage registration</span>
                   </a></li>

                   <li><a href="/AdminStat">
                       <span class="icon"><i class="fa fa-bar-chart" aria-hidden="true"></i>
                       </span>
                       <span class="title">Statistics</span>
                   </a></li>
                   <li><a href="#" >
                    <span class="icon"><i class="fa fa-comment"></i></span>
                    <span class="title">Communication</span>
                   </a></li>

                   <li><a href="/Compteadmin" class="active">
                    <span class="icon">
                        <i class="fa fa-cog"></i>
                        </span>
                    <span class="title">Setting</span>
                   </a></li>
               </ul>
           </div>
           <!-- --------------------------------------------------------------- -->
            <div class="main_container">
            <div class="item">
  <form:form method="post" action="/Modiferadmin" modelAttribute="user">
            <fieldset>
            <table>
            <tr>
				<td><form:label path="idAdmin">Id </form:label></td>
				<td><form:input  type="text" path="idAdmin" value="${a[0]}"/></td>
			</tr>
               <tr>
				<td><form:label path="Nom">Nom </form:label></td>
				<td><form:input  type="text" path="Nom" value="${a[1]}"/></td>
			</tr>
			<tr>
				<td><form:label path="prenom">prenom</form:label></td>
				<td><form:input  type="text" path="prenom" value="${a[2]}"/></td>
			</tr>
			<tr>
				<td><form:label path="Email">Email:</form:label></td>
				<td><form:input  type="email" path="Email" value="${a[3]}"/></td>
			</tr>
			<tr>
				<td><form:label path="pass">mot passe</form:label></td>
				<td><form:input  type="password" path="pass" value="${a[4]}"/></td>
			</tr>
			<tr>
				<td><form:label path="N_Telephone">N_Telephone:</form:label></td>
				<td><form:input  type="text" path="N_Telephone"/></td>
			</tr>
			<tr><td> </table>
			<h1>${Eruure}</h1>
			

			<input type="submit" value="Modifer" style="border: 1px solid #ddd;  padding: 15px; background-color:#2e4ead; color: #fff; font-size: 15px; text-align: center;"/>
            </fieldset>
        </form:form>
        </div></div></div>
</body>
</html>