<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/aladin.css">
        <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.js"></script>

        <title>CharConverter</title>
    </head>
    <body>

        <h2>Valeurs numériques d'un caractère</h2>

        <form id="myform" method="post">
            <label for="caractere">Caractère :</label>
            <input type="text" name="caractere" maxlength="1" id="caractere"/>
            <input type="button" id="submit" value="Send"/>
        </form>

        <table class = "table table-hover" border="1" id="tab">  

         <tr> 
                  <th> Caractère </th> 
                  <th> Décimal </th> 
                  <th> Hexadécimal </th> 
                  <th> HTML </th> 
		  <th> Unicode </th>
         </tr> 
        </table> 

        <script>

            $(document).ready(function()
            {
                // si l'on appuie sur entrer
                $('#caractere').keydown(function(e)
                {
                    if (e.keyCode === 13)
                    {
                        // on fait la meme chose que pour send
                        e.preventDefault();
                        $('input#submit').click();

                    }
                });

                // si l'on clique sur send
                $("#submit").click(function()
                {
                    // on recupere le caractere rentre
                    var caractere = $('#caractere').val();

                    // si l'utilisateur a bien rentre un caractere
                    if (caractere !== "")
                    {
                        // envoie le caractere au serveur
                        $.ajax(
                                {
                                    url: 'Converter',
                                    type: 'POST',
                                    dataType: 'json',
                                    data: {caractere: caractere},
                                    success: function(data)
                                    {
    
                          		  $("#tab").append(
                          		  "<tr>
                          		  <td>"+caractere+"</td>
                          		  <td>"+data.dec+"</td>
                          		  <td>"+data.hex+"</td>
                          		  <td>"+data.html+"</td>
                          		  <td>"+data.unicode+"</td>
                          		  </tr>"
                          		  );

                                    },
                                    error: function(e)
                                    {
                                        alert(e.status);
                                    }
                                });
                    }

                    // si pas de caractere rentre
                    else
                    {
                        alert("Veuillez rentrer un caractère !");
                    }
                });
            });

        </script>
    </body>
</html>
