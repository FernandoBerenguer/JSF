<%-- 
    Document   : a_personaje
    Created on : 01-mar-2018, 12:48:39
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
            <title>Añadir personaje</title>
            <link rel="stylesheet" type="text/css" href="source\estilos.css">
            <link href="https://fonts.googleapis.com/css?family=Cinzel+Decorative" rel="stylesheet">
        </head>
        <body>
             <div id="principal">
            <h1><img src="source\triforce.png"/> Añadir personaje <img src="source\triforce.png"/></h1>
           
            <h:form>
            <div id="box">
            <div id="formulario">
            
             <h3>¿Que personaje quieres añadir?</h3>
             <h:inputText value="#{personajes.nuevopersonaje}"/><br><br>
            
            <div id="btnLogo">
            <img src="source\boton.png"/>
            </div>
            <div id="btnAceptar">
                <h:commandButton value="Aceptar" action="#{personajes.guardar_P}"/>
                <h:commandButton value="Cancelar" action="index"/>
            </div>            
            </h:form>
           
              </div>
                </div>
            </div>
        </body>
    </html>
</f:view>
