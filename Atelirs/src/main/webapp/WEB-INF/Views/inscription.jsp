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
         <div>
            <select id="mySelect" onchange="insFunction()" style=" border: 1px solid #ddd;  padding: 15px; background-color:#2e4ead; color: #fff; font-size: 15px; text-align: center;">
                
                <option value="0" style="display: none;">Chosse</option>    
                 <option value="Learn">Learn</option>      
                 <option value="Etab">Etablishment</option>
                 <option value="formm">Former</option>

               </select>
               </div>
               <div id="Learn" style="display: none;">
                        <form:form method="post" action="inscriptionApp" modelAttribute="user">
                    <div class="wrapper">
                        <div class="contact-form">
                    <ul class="form-style-1">
                        <li><label>Full Name <span class="required">*</span></label><form:input type="text"  class="field-divided" placeholder="First" path="Nom" /> <form:input type="text"  class="field-divided" placeholder="Last" path="prenom" /></li>
                        <li>
                            <label>Email <span class="required">*</span></label>
                            <form:input type="email"  class="field-long" path="Email" />
                        </li>
                        <li>
                            <label>Telephone number <span class="required">*</span></label>
                            <form:input type="text"  class="field-long" path="N_Telephone" />
                        </li>
                        <li>
                            <label>PassWord <span class="required">*</span></label>
                            <form:input type="password" class="field-long" path="pass" />
                        </li> 
                        <li>
                            <label>PassWord confirm <span class="required">*</span></label>
                            <form:input type="password"  class="field-long" path="passconf" />
                        </li> 
                        <li>
                            <input type="submit" value="Submit" />
                        </li>
                    </ul>
                    </div> </div>
                    </form:form>
                </div>
                <div id="Etab" style="display: none;">
                          <form:form method="post" action="inscriptionEtab" modelAttribute="user">
                    <div class="wrapper">
                        <div class="contact-form">
                    <ul class="form-style-1">
                        <li><label>Full Name <span class="required">*</span></label><form:input type="text"  class="field-divided" placeholder="First" path="Nom" /> <form:input type="text"  class="field-divided" placeholder="Last" path="prenom" /></li>
                        <li>
                            <label>Email <span class="required">*</span></label>
                            <form:input type="email"  class="field-long" path="Email" />
                        </li>
                        <li>
                            <label>Telephone number <span class="required">*</span></label>
                            <form:input type="text"  class="field-long" path="N_Telephone" />
                        </li>
                        <li>
                            <label>PassWord <span class="required">*</span></label>
                            <form:input type="password" class="field-long" path="pass" />
                        </li> 
                        <li>
                            <label>PassWord confirm <span class="required">*</span></label>
                            <form:input type="password"  class="field-long" path="passconf" />
                        </li> 
                    </ul>
                    <ul class="form-style-1">
                        <li><label>Full Name <span class="required">*</span></label><form:input type="text"  class="field-divided" placeholder="City" path="Ville" /> <form:input type="text"  class="field-divided" placeholder="region" path="region" /></li>
                        <li>
                            <label>filieres <span class="required">*</span></label>
                            <form:input type="text"  class="field-long" path="filieres" />
                        </li>
                        <li>
                            <label>niveau <span class="required">*</span></label>
                            <form:input type="text"  class="field-long" path="niveau" />
                        </li>
                        <li>
                            <label>diplomes <span class="required">*</span></label>
                            <form:input type="text" class="field-long" path="diplomes" />
                        </li> 
                        <li>
                            <input type="submit" value="Submit" />
                        </li>
                    </ul>
                    </div> </div>
                    </form:form> </div>
              <div id="form" style="display: none;">
        <form:form method="post" action="inscriptionFor" modelAttribute="user">
                    <div class="wrapper">
                        <div class="contact-form">
                    <ul class="form-style-1">
                        <li><label>Full Name <span class="required">*</span></label><form:input type="text"  class="field-divided" placeholder="First" path="Nom" /> <form:input type="text"  class="field-divided" placeholder="Last" path="prenom" /></li>
                        <li>
                            <label>Email <span class="required">*</span></label>
                            <form:input type="email"  class="field-long" path="Email" />
                        </li>
                        <li>
                            <label>Telephone number <span class="required">*</span></label>
                            <form:input type="text"  class="field-long" path="N_Telephone" />
                        </li>
                        <li>
                            <label>PassWord <span class="required">*</span></label>
                            <form:input type="password" class="field-long" path="pass" />
                        </li> 
                        <li>
                            <label>PassWord confirm <span class="required">*</span></label>
                            <form:input type="password"  class="field-long" path="passconf" />
                        </li> 
                        <li>
                            <input type="submit" value="Submit" />
                        </li>
                    </ul>
                    </div> </div>
                    </form:form>
           </div>
</div>
        
       
   <!--------------------------------------------------------------------->
   <script src="js/admin.js"></script>
                
        
</body>


</html>