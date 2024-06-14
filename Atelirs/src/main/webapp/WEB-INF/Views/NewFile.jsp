<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="inscription" modelAttribute="user">
         <div class="wrapper">
             <div class="contact-form">
                 <div class="input-fields">
                     <form:input type="text" class="input" placeholder="Laste Name" path="Nom"/>
                     <form:input type="text" class="input" placeholder="First Name" path="prenom"/>
                     <form:input type="email" class="input" placeholder="Email" path="Email"/>
                     <form:input type="text" class="input" placeholder="telephone number" path="N_Telephone"/>
                     <form:input type="password" class="input" placeholder="PossWord" path="pass"/>
                     <form:input type="password" class="input" placeholder="PossWord confirm" path="passconf"/>
                 </div>
                 <div class="msg">
                     <form:input type="number" min="1" max="52" class="input" placeholder="City" path="Ville"/>
                     <form:input type="number" min="1" max="52" class="input" placeholder="Region" path="region"/>
                     <form:input type="text" class="input" placeholder="diplomas" path="diplomes"/>
                     <form:select path="type" class="input">
			<form:option value="Apprenant" ></form:option>
			<form:option value="Etablissement"></form:option>
			<form:option value="Formateur"></form:option>
			</form:select>
                     <form:input type="radio" id="contactChoice1" path="type" value="Apprenant"style="margin-top: 15px;" />
    <form:label  class="input" for="contactChoice1" style="color: #FFF; padding: 1px; margin-top: 15px; " path="type">Learn</form:label>

    <form:input type="radio" id="contactChoice2" path="type" value="Etablissement" />
    <form:label  class="input" for="contactChoice2"style="color: #FFF; padding: 1px; margin-top: 15px;" path="type">Etablishment</form:label>

    <form:input type="radio" id="contactChoice3" path="type" value="Formateur" />
    <form:label   class="input" for="contactChoice3"style="color: #FFF; padding: 1px; margin-top: 15px;" path="type">Former</form:label>
                    <br>
                     <div class="txt_field">
                        <form:input type="submit" value="Submit" style="margin-top:30px;" />
                      </div>
                 </div>
             </div>
         </div>
        </form:form>

</body>
<Admin>
${a}
<a href="Compteadmin">Compteadmin</a>


<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>


<canvas id="myChart" style="width:100%;max-width:600px"></canvas>

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
  type: "pie",
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
      text: "World Wide Wine Production 2018"
    }
  }
});
</script></Admin>
</html>