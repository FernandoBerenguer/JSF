<%-- 
    Document   : a_usuario
    Created on : 14-feb-2018, 22:58:22
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
            <h1><img src="source\triforce.png"/> Modificacion datos de usuario <img src="source\triforce.png"/></h1>
           
            <h:form>
            <div id="box">
            <div id="formulario">  
                
            <p>Introduzca su nombre:</p>
            <h:inputText value="#{usuarios.nombre}"/><br><br>
            
            <p>Introduzca su edad:</p>
            <h:inputText value="#{usuarios.edad}"/><br><br>
            
            <h3>¿Te gusta el mundo de The Legend of Zelda?</h3>
            <h:selectOneRadio value="#{usuarios.mundo}">
                <f:selectItems value="#{usuarios.listaMundo}"/>
            </h:selectOneRadio><br>
            
              <h3>¿Cuales son tus personajes favoritos?</h3>
             <h:selectManyListbox value="#{usuarios.personajes}">
                <f:selectItems value="#{usuarios.listaPersonajes}"/>
            </h:selectManyListbox ><br>
            
            <h3>¿Que juego te gusta mas?</h3>            
            <h:selectManyCheckbox value="#{usuarios.juego}">
                <f:selectItems value="#{usuarios.listaJuego}"/>
            </h:selectManyCheckbox><br>            
                
            <h3>¿En que consola jugaste por primera vez?</h3>
            <h:selectOneMenu value="#{usuarios.consola}">    
                <f:selectItems value="#{usuarios.listaConsolas}"/>
            </h:selectOneMenu>  <br>
            
            <div id="btnLogo">
            <img src="source\boton.png"/>
            </div>
            <div id="btnAceptar">
                <h:commandButton value="Aceptar" action="#{usuarios.guardar_U}"/>
                <h:commandButton value="Cancelar" action="index"/>
            </div>            
            </h:form>
           
              </div>
                </div>
            </div>
        </body>
    </html>
</f:view>
