<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Servicio Restful: Tiempo</h1>
        <%
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmyy hhmmss S X");
            String data = dateFormat.format(new Date());
        %>
        <form action="app/restful/time" method="get" target="_blank">
            Hora actual: <input type="text" name="value" value="<%= data%>" readonly>
            <input type="submit" value="Enviar">
        </form>
            
            
            <h1>Servicio Restful: Word</h1>
            <form action="app/restful/word" method="post" target="_blank">
                Palabra (Largo máximo 4): <input type="text" name="data" value="{&quot;data&quot;:&quot;test&quot;}">
                <input type="submit" value="Enviar">
            </form>
        
       
    </body>
</html>
