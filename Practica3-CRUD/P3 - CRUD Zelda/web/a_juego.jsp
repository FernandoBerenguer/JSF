<%-- 
    Document   : a_juego
    Created on : 01-mar-2018, 13:32:29
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
            <title>Añadir juego</title>
            <link rel="stylesheet" type="text/css" href="source\estilos.css">
            <link href="https://fonts.googleapis.com/css?family=Cinzel+Decorative" rel="stylesheet">
        </head>
        <body>
             <div id="principal">
            <h1><img src="source\triforce.png"/> Añadir juego <img src="source\triforce.png"/></h1>
           
            <h:form>
            <div id="box">
            <div id="formulario">
            
             <h3>¿Que juego quieres añadir?</h3>
             <h:inputText value="#{juegos.nuevojuego}"/><br><br>
            
            <div id="btnLogo">
            <img src="source\boton.png"/>
            </div>
            <div id="btnAceptar">
                <h:commandButton value="Aceptar" action="#{juegos.guardar_J}"/>
                <h:commandButton value="Cancelar" action="index"/>
            </div>            
            </h:form>
           
              </div>
                </div>
            </div>
        </body>
    </html>
</f:view>
