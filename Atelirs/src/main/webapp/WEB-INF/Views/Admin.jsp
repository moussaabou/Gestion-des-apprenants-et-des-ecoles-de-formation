<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

                   <li><a href="#" class="active">
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
              <!-- --------------------------------------------------------------------------------------  -->
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
             <div id="Learn" style="display:none;">
       <div class="item">
                <h1 > The number of learners : ${apprenant}</h1>
                                   </div> </div>
                                   <div id="form" style="display:none;">
                                   <div class="item" >
                <h1 > The number of formature : ${formature}</h1>
                                   </div> </div>
                                   <div id="Etab" style="display:none;">
                                   <div class="item">
                <h1> The number of establishments : ${etablissement}</h1>
                                   </div>
                                    <div class="item">
                <h1> The number of job offers : ${offre_de_emploi}</h1>
                                   </div>
                                    <div class="item">
                <h1> The number of training : ${formation}</h1>
                                   </div> </div>
       
            <div class="item">
                <canvas id="myChart" style="width:100%;max-width:600px;"></canvas>
                            

            </div>
           </div>
       </div>
    <!-- - static ------------------------------------------------------------------------------------------ -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <script>
var xValues = ["apprenant", "Formature", "etablissement", "offre_de_emploi", "formation"];
var yValues = [${apprenant}, ${formature}, ${etablissement}, ${offre_de_emploi}, ${formation}];
var barColors = [
  "#b91d47",
  "#00aba9",
  "#2b5797",
  "#e8c3b9",
  "#1e7145"
];

new Chart("myChart", {
	  type: "doughnut",
	  data: {
	    labels: xValues,
	    datasets: [{
	      backgroundColor: barColors,
	      data: yValues
	    }]
	  },
  options: {
    title: {
      display: true,
      text: ""
    }
  }
});
</script>
               <script src="js/admin.js"></script>
    </body>
</html>
