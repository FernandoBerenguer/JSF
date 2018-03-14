<%-- 
    Document   : index
    Created on : 30-nov-2017, 11:00:41
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
                <center>
                    <h:form>
                        <h:panelGrid columns="4" border="1">
                    <f:facet name="header">
                        <h:outputText style="font-size:25px" value="Búsqueda de usuarios"/>
                    </f:facet>
                    <h:outputText value="Nombre:" />
                    <h:inputText value="#{ficha.sNombre}" />
                     <h:commandButton value="Buscar" actionListener="#{ficha.buscar_usuario}" />
                      <h:commandButton value="Limpiar Búsqueda" actionListener="#{ficha.limpiar_buscar_usuario}" />
                </h:panelGrid>
                        
                        
                <h:dataTable border="1" value="#{ficha.rset}" var="fila"
                             binding="#{ficha.tabla}">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="ID"/>
                    </f:facet>
                    <h:outputText value="#{fila.id_usuario}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Nombre"/>
                    </f:facet>
                    <h:outputText value="#{fila.nombre}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Edad"/>
                    </f:facet>
                    <h:outputText value="#{fila.edad}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="¿Te gusta Zelda?"/>
                    </f:facet>
                    <h:outputText value="#{fila.zelda}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Personajes favoritos"/>
                    </f:facet>
                     <h:dataTable value="#{ficha.rspersonajes}" var="item1">
                         <h:column>
                             <h:outputText value="- #{item1.nombre}"/>
                         </h:column>                         
                     </h:dataTable>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Juegos favoritos"/>
                    </f:facet>
                    <h:dataTable value="#{ficha.rsjuegos}" var="item2">
                         <h:column>
                             <h:outputText value="- #{item2.nombre}"/>
                         </h:column>
                     </h:dataTable>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Consola"/>
                    </f:facet>
                    <h:outputText value="#{fila.nombreconsola}"/>
                </h:column>
                <h:column>
                        <f:facet name="header">
                            <h:outputText value="Modificar"/>
                        </f:facet>
                        <h:commandButton value="Modificar" 
                                         action="#{ficha.seleccionLista_Mod}"
                                         />
                </h:column>
                <h:column>
                        <f:facet name="header">
                            <h:outputText value="Borrar"/>
                        </f:facet>
                        <h:commandButton value="Borrar" 
                                         onclick="return confirm('Desea borrar el usuario?')"
                                         action="#{ficha.seleccionLista_Del}"
                                        />
                 </h:column>
                </h:dataTable>
                <h:commandButton value="Añadir Usuario"                               
                                 action="#{ficha.insertar_usuario}"/>
              
                <h:commandButton value="Añadir Personaje"                               
                                 action="#{ficha.insertar_personaje}"/>
                <h:commandButton value="Añadir Juego"                               
                                 action="#{ficha.insertar_juego}"/>
                </h:form>
                </center><br>
            </div>
            </div>
            </div>
        </body>
    </html>
</f:view>
