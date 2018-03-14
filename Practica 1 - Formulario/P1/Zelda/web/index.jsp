<%-- 
    Document   : index
    Created on : 16-oct-2017, 18:18:32
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
           
            <h:form>
            <div id="box">
            <div id="formulario">  
                
            <p>Introduzca su nombre:</p>
            <h:inputText value="#{ficha.nombre}"/><br><br>
            
            <p>Introduzca su edad:</p>
            <h:inputText value="#{ficha.edad}"/><br><br>
            
            <h3>¿Te gusta el mundo de The Legend of Zelda?</h3>
            <h:selectOneRadio value="#{ficha.mundo}">
                <f:selectItems value="#{ficha.listaMundo}"/>
            </h:selectOneRadio><br>
            
              <h3>¿Cuales son tus personajes favoritos?</h3>
            <h:selectManyListbox value="#{ficha.personajes}">
                <f:selectItems value="#{ficha.listaPersonajes}"/>
            </h:selectManyListbox ><br>
            
             <h3>¿Que juego te gusta mas?</h3>            
            <h:selectManyCheckbox value="#{ficha.juego}">
                <f:selectItems value="#{ficha.listaJuego}"/>
            </h:selectManyCheckbox><br>            
                
            <h3>¿En que consola jugaste por primera vez?</h3>
            <h:selectOneMenu value="#{ficha.consola}">    
                <f:selectItem itemValue="NES" itemLabel="NES" />
                <f:selectItem itemValue="Nintendo 64" itemLabel="Nintendo 64" />
                <f:selectItem itemValue="GameBoy" itemLabel="GameBoy" />
                <f:selectItem itemValue="GameCube" itemLabel="GameCube" />
                <f:selectItem itemValue="Wii" itemLabel="Wii" />
            </h:selectOneMenu>    <br>
            
            <div id="btnLogo">
            <img src="source\boton.png"/>
            </div>
            
            <div id="btnAceptar">
                <h:commandButton value="Aceptar" action="welcome"/>
            </div>
            
            </h:form>
           
              </div>
                </div>
            </div>
        </body>
    </html>
</f:view>
