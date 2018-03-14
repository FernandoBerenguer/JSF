<%-- 
    Document   : saludo
    Created on : 19-oct-2017, 13:48:40
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>The Legend of Zelda</title>
            <link rel="stylesheet" type="text/css" href="source\estilos.css">
            <link href="https://fonts.googleapis.com/css?family=Cinzel+Decorative" rel="stylesheet"> 
        </head>
        <body>
            <div id="principal">
            <h1><img src="source\triforce.png"/> Encuesta sobre The legend of Zelda <img src="source\triforce.png"/></h1>
           
            <div id="box">
            <div id="formulario">  
                
            <p>Nombre:</p>
            <h:outputText value="#{ficha.nombre}"/><br><br>
            
            <p>Edad:</p>
            <h:outputText value="#{ficha.edad}"/><br><br>
            
            <br>
            
            <h3>¿Te gusta el mundo de The Legend of Zelda?</h3>
            <h:outputText value="#{ficha.muestraMundo}"/><br><br>
            
            <h3>¿Cuales son tus personajes favoritos?</h3>
            <h:outputText value="#{ficha.muestraPersonajes}"/><br><br>
            <br>
            
            <h3>¿Que juego te gusta mas?</h3>   
            <h:outputText value="#{ficha.muestraJuego}"/><br><br>
            <br>
            
            <h3>¿En que consola jugaste por primera vez?</h3>
            <h:outputText value="#{ficha.consola}"/><br><br>
              </div>
             </div>
            </div>
        </body>
    </html>
</f:view>
