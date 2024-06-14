<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="css/styleA.css">
        <link rel="stylesheet" href="css/form.css">

        <link href="https://fonts.googleapis.com/css2?family=Roboto:wgh@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script>
            $(document).ready(function(){
                $(".hamburger").click(function(){
                   $(".wrapper").toggleClass("collapse"); 
                });
            });

        </script>
  
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
                       <li>Moussaab Boucetta</li>
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

                <li><a href="#">
                    <span class="icon"><i class="fa fa-users" aria-hidden="true"></i>   
                    </span>
                    <span class="title" style="font-size: 14px;">Application processing</span>
                   </a></li>

                   <li><a href="#">
                    <span class="icon"><i class="fa fa-graduation-cap" aria-hidden="true"></i>
                    </i></span>
                    <span class="title">Training course</span>
                   </a></li>

                   <li><a href="#"  class="active" >
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

                   <li><a href="#">
                    <span class="icon">
                        <i class="fa fa-cog"></i>
                        </span>
                    <span class="title">Setting</span>
                   </a></li>
               </ul>
                  </div>
                  </div>
               <!-- ----------------------------------------------------------------------------------------------------- -->
       
         
           <div class="center">
            <form method="post">
              <h1>Add a job offer</h1>
                <div class="txt_field">
                            <input  type="text" style="font-size: 25PX;" required>
                    <label for="">Worck name</label>
                </div>
                <div class="txt_field">
                             <input  type="text" style="font-size: 25PX;" required>
                     <label for="">Level</label>
                </div>
                <div class="txt_field">
                    <select>
                        <option>
                            HHD
                        </option>
                        <option>
                            HHS
                        </option>
                    </select>
       </div>
                <div class="txt_field">
                    <input  type="file"  required>
       </div>
                   <input type="submit" value="Add">
                 
                </form>
                
    </body>
</html>