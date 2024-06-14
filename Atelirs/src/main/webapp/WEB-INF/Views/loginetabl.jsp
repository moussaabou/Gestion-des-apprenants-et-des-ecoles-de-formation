<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/from.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="admin.js"></script>

<link href="https://fonts.googleapis.com/css2?family=Roboto:wgh@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
     <div class="container">
         <div class="navbar">
           <img src="css/image/4917919.png" class="logo">
                 <nav>
                     <i class="fa fa-time" onclick="hideMenu()"></i>
                      <ul>
                         <li> <a href="/">Home</a></li>
                         <li> <a href="info">Training offers</a></li>
                         <li> <a href="OffreDeEtab">Training schools</a></li>
                         <li> <a href="infoemploi">Job offers</a></li>
                     </ul>
                 </nav>
                 <img src="image/menu.png" class="menu-icon">
         </div>
         <form:form method="post" action="/Etablissement" modelAttribute="user">
                    <div class="wrapper">
                        <div class="contact-form">
                    <ul class="form-style-1">
                                         <h2 style="color:#000">Hello etablissement</h2>
                    
                        <li>
                            <label>Email <span class="required">*</span></label>
                            <form:input type="email"  class="field-long" path="Email" />
                        </li>
                        <li>
                            <label>PassWord <span class="required">*</span></label>
                            <form:input type="password" class="field-long" path="pass" />
                        </li> 
                        <li>
                            <input type="submit" value="Submit" />
                        </li>
                    </ul>
                    </div> </div>
                    </form:form>
                    </div>
                    </body>