<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
          <%@ page import="java.util.Arrays"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
                       <li style="color:#2e4ead; font-size: 20px;">${nnom} ${pprenom}</li>
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

                <li><a href="AdminGere" class="active">
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

                   <li><a href="/Compteadmin">
                    <span class="icon">
                        <i class="fa fa-cog"></i>
                        </span>
                    <span class="title">Setting</span>
                   </a></li>
               </ul>
           </div>
<!-- ----------------------------------------------------------------------------------------------------- -->
           <div class="main_container">
             <div class="item"   >
             <label style="font-size: 25px; padding: 5px;" >  Choose:</label>
               <select id="mySelect" onchange="insFunction()" style="border: 1px solid #ddd;  padding: 15px; background-color:#2e4ead; color: #fff; font-size: 15px; text-align: center;">
                <option value="All">All</option>      
                 <option value="Learn">Learn</option>      
                 <option value="Etab">Etablishment</option>
                 <option value="formm">Former</option>

               </select>
             </div>
            
             <div id="Learn">
               <div class="item">
                  <h1 style="text-align: center; color: black; padding: 5px;">Learn list</h1> 
                <table id="customers">
                    <tr>
                        <th>Id</th>
                      <th>Laste Name</th>
                      <th>First Name</th>
                      <th>Email</th>
                      <th>telephone number</th>
                      <th>PossWord</th>
                      <th>Diploma</th>
                      <th>Add</th>
                    </tr>
                    <c:forEach  items="${id}" var ="id" varStatus="status">
        <tr>
                <form:form method="post" action="/AdminGereApp" modelAttribute="user">
                      <td><form:input path="id" value="${id}" style= "margin:3px;"/></td>
          <td>${nom[status.index]}</td>
          <td>${prenom[status.index]}</td>
          <td>${email[status.index]}</td>
          <td>${n_tel[status.index]}</td>
          <td>${pass[status.index]}</td>
           <td><a href="" download>Diploma1.pdf</a> </td>
                      <td><input class="Add" type="submit" path="type" value="Add" ></td>
                    </form:form>
                    </tr>
                 </c:forEach>
                  </table>
               </div>

               <div class="item">
                  <h1 style="text-align: center; color: black; padding: 5px;">Learn list</h1> 
                <table id="customers">
                    <tr>
                        <th>Id</th>
                      <th>Laste Name</th>
                      <th>First Name</th>
                      <th>Email</th>
                      <th>telephone number</th>
                      <th>PossWord</th>
                      <th>Diploma</th>
                      <th>Delet</th>
                    </tr>
                    <c:forEach  items="${id}" var ="id" varStatus="status">
        <tr> 
                <form:form method="post" action="/AdminGereAppSupp" modelAttribute="user">
                      <td><form:input path="id" value="${id}" style= "margin:3px;"/></td>
          <td>${nom[status.index]}</td>
          <td>${prenom[status.index]}</td>
          <td>${email[status.index]}</td>
          <td>${n_tel[status.index]}</td>
          <td>${pass[status.index]}</td>
           <td><a href="" >Diploma1.pdf</a> </td>
                      <td><input class="Delet" type="submit"  value="Delte" ></td>
                    </form:form>
                    </tr>
                 </c:forEach>
                  </table>
               </div>
               </div>

               <div id="Etab">
               <div class="item">
                <h1 style="text-align: center; color: black; padding: 5px;">Etablishment list</h1> 
              <table id="customers">
                  <tr>
                  <th>Id</th>
                    <th>Laste Name</th>
                    <th>First Name</th>
                    <th>Email</th>
                    <th>telephone number</th>
                    <th>PossWord</th>
                    <th>ville</th>
                    <th>region</th>
                    <th>Niveaux</th>
                    <th>filieres</th>
                    <th>diplomes</th>
                    <th>Add</th>
                  </tr>
                   <c:forEach  items="${idE}" var ="idE" varStatus="status">
                   <tr>
                    <form:form method="post" action="/AdminGereEtab" modelAttribute="user">
                      <td><form:input path="id" value="${idE}" style= "margin:3px;"/></td>
          <td>${nomE[status.index]}</td>
          <td>${prenomE[status.index]}</td>
          <td>${emailE[status.index]}</td>
          <td>${n_telE[status.index]}</td>
          <td>${passE[status.index]}</td>
           <td>${ville[status.index]}</td>
                    <td>${region[status.index]}</td>
                    <td>${Niveaux[status.index]}</td>
                    <td>${filieres[status.index]}</td>
                    <td>${diplomes[status.index]}</td>
                    <td><input class="Add" type="submit" value="Add" ></td>
                    </form:form>
                  </tr>
                  </c:forEach>
                </table>
             </div>                           
               <div class="item">
                <h1 style="text-align: center; color: black; padding: 5px;">Etablishment list</h1> 
              <table id="customers">
                  <tr>
                  <th>Id</th>
                    <th>Laste Name</th>
                    <th>First Name</th>
                    <th>Email</th>
                    <th>telephone number</th>
                    <th>PossWord</th>
                    <th>ville</th>
                    <th>region</th>
                    <th>Niveaux</th>
                    <th>filieres</th>
                    <th>diplomes</th>
                    <th>Add</th>
                  </tr>
                   <c:forEach  items="${idE}" var ="idE" varStatus="status">
                   <tr>
                    <form:form method="post" action="/AdminGereEtabSupp" modelAttribute="user">
                      <td><form:input path="id" value="${idE}" style= "margin:3px;"/></td>
          <td>${nomE[status.index]}</td>
          <td>${prenomE[status.index]}</td>
          <td>${emailE[status.index]}</td>
          <td>${n_telE[status.index]}</td>
          <td>${passE[status.index]}</td>
           <td>${ville[status.index]}</td>
                    <td>${region[status.index]}</td>
                    <td>${Niveaux[status.index]}</td>
                    <td>${filieres[status.index]}</td>
                    <td>${diplomes[status.index]}</td>
                    <td><input class="Delet" type="submit" value="Delet" ></td>
                    </form:form>
                  </tr>
                  </c:forEach>
                </table>
             </div>
             </div>
             <div id="form">
             <div class="item">
                <h1 style="text-align: center; color: black; padding: 5px;">Former list</h1> 
              <table id="customers">
                  <tr>
                     <th>Id</th>  
                    <th>Laste Name</th>
                    <th>First Name</th>
                    <th>Email</th>
                    <th>telephone number</th>
                    <th>PossWord</th>
                    <th>Add</th>
                  </tr>
          <c:forEach  items="${idF}" var ="idF" varStatus="status">
        <tr>
                <form:form method="post" action="/AdminGereForm" modelAttribute="user">
                      <td><form:input path="id" value="${idF}" style= "margin:3px;"/></td>
          <td>${nomF[status.index]}</td>
          <td>${prenomF[status.index]}</td>
          <td>${emailF[status.index]}</td>
          <td>${n_telF[status.index]}</td>
          <td>${passF[status.index]}</td>
                      <td><input class="Add" type="submit"  value="Add" ></td>
                    </form:form>
                    </tr>
                 </c:forEach>
                </table>
            
            </div>
             <div class="item">
                <h1 style="text-align: center; color: black; padding: 5px;">Former list</h1> 
              <table id="customers">
                  <tr>
                     <th>Id</th>  
                    <th>Laste Name</th>
                    <th>First Name</th>
                    <th>Email</th>
                    <th>telephone number</th>
                    <th>PossWord</th>
                    <th>Delet</th>
                  </tr>
          <c:forEach  items="${idF}" var ="idF" varStatus="status">
        <tr>
                <form:form method="post" action="/AdminGereFormSupp" modelAttribute="user">
                      <td><form:input path="id" value="${idF}" style= "margin:3px;"/></td>
          <td>${nomF[status.index]}</td>
          <td>${prenomF[status.index]}</td>
          <td>${emailF[status.index]}</td>
          <td>${n_telF[status.index]}</td>
          <td>${passF[status.index]}</td>
                      <td><input class="Delet" type="submit"  value="Delet" ></td>
                    </form:form>
                    </tr>
                 </c:forEach>
                </table>
            
            </div>
          </div>
              
               </div>

               </div>
               <!--------------------------------------------------------------------->
               <script src="js/admin.js"></script>
                
    </body>
</html>