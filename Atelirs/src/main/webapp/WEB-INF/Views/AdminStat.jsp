<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                       <li><a href="#"><i class="fa fa-bell" aria-hidden="true"></i></a></li>
                       <li><a href="#"><i class="fa fa-user"></i></a></li>
                       <li style="color:#2e4ead; font-size: 20px;">${nom} ${prenom}</li>
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

                   <li><a href="/AdminStat" class="active">
                       <span class="icon"><i class="fa fa-bar-chart" aria-hidden="true"></i>
                       </span>
                       <span class="title">Statistics</span>
                   </a></li>
                   <li><a href="#" >
                    <span class="icon"><i class="fa fa-comment"></i></span>
                    <span class="title">Communication</span>
                   </a></li>

                   <li><a href="#">
                    <span class="icon">
                        <i class="fa fa-cog"></i>
                        </span>
                    <span class="title">Setting</span>
                   </a></li>
               </ul>
           </div> 
           <!-- ---------------------------------------------------------------------------------------------------- -->
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
                    </tr>
                    </table>
                    </div>
                    </div>
                    </div>
                      <!--------------------------------------------------------------------->
               <script src="js/admin.js"></script>
                
</body>
</html>