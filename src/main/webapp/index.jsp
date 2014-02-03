<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<link rel=stylesheet href=css/styles.css>
<body>
<h2>Valeurs numeriques d'un caractere</h2>

<form class="form" name="form" action="traite" method="post">  
    <p >  
      <label for="name">Caractere : </label>  
        <input type= "text" name = "id"/>  
        <input type="submit" value="Envoyer" id = "submit"/>  
   </p>    
</form>



</body>
</html>
