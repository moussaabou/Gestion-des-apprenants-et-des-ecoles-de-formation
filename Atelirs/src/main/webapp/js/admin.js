function insFunction() {
                  var x = document.getElementById("mySelect").value;
                  var Etab = document.getElementById("Etab");
                  var form = document.getElementById("form");
                  var Learn = document.getElementById("Learn");
                  if(x=="Etab")
                  {
                    form.style.display = "none";
                    Learn.style.display = "none";
                    Etab.style.display="block";
                  }
                  if(x=="Learn")
                  {
                    form.style.display = "none";
                    Learn.style.display = "block";
                    Etab.style.display="none";
                  }
                  if(x =="formm")
                  {
                    form.style.display = "block";
                    Learn.style.display = "none";
                    Etab.style.display="none";
                  }
                  if(x =="All")
                  {
                    form.style.display = "block";
                    Learn.style.display = "block";
                    Etab.style.display="block";
                  }
}
                function cityFunction() {
                  var x = document.getElementById("mySelect").value;
                  var c1 = document.getElementById("1");
                  var c2 = document.getElementById("2");
                  var c3 = document.getElementById("3");
                  if(x=="1")
                  {
                    c3.style.display = "none";
                    c2.style.display = "none";
                    c1.style.display="block";
                  }
                  if(x=="c2")
                  {
                   c3.style.display = "none";
                    c1.style.display = "none";
                    c2.style.display="block";
                  }
                  if(x =="c3")
                  {
                    c1.style.display = "none";
                    c2.style.display = "none";
                    c3.style.display="block";
                  }
                  }
                
         