/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.*;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
/**
 *
 * @author usuario
 */
public class ficha {
    
    public static Connection Conn;
    private String[] mensajeError=new String[1];
    private HtmlDataTable tabla;
    public static String sID_Usuario;

    String consultaSQL="SELECT distinct usuario.id_usuario, usuario.nombre, usuario.edad, usuario.zelda, consolas.nombreconsola\n" +
                        "FROM usuario, consolas\n" +
                        "WHERE usuario.id_consola = consolas.id_consola";
    String sWhere="";
    private ResultSet rset;
    private String serror;
    private ResultSet rspersonajes;
    private ResultSet rsjuegos;
    
    //busquedas
    private String sNombre;
    /**
     * Creates a new instance of ficha
     */
    public ficha() {
       mensajeError[0]="Todo Bien";
        Conn=MySQL_Util.Conectar("localhost","root", "", "zelda", mensajeError);
    }
    
    public void buscar_usuario(ActionEvent e)
    {
    if (sNombre.trim().length()>0)
        {sWhere+= " AND usuario.nombre like '%"+sNombre+"%'";}
    }
    
    public void limpiar_buscar_usuario(ActionEvent e)
    {
    sNombre="";
    sWhere="";
    }
    
    
     public String seleccionLista_Del()
    {
    String borrarusuario;    
    String sid_borrar=Obtener_ID();
    
    String borrarfp="DELETE FROM personajes_favoritos WHERE id_usuario="+sid_borrar;
    String borrarjf="DELETE FROM juegos_favoritos WHERE id_usuario="+sid_borrar;
    boolean resultadoPersonajes=MySQL_Util.Ej_Consulta(Conn, borrarfp);
    boolean resultadoJuegos=MySQL_Util.Ej_Consulta(Conn, borrarjf);

    if (resultadoPersonajes && resultadoJuegos)
         {borrarusuario ="DELETE FROM usuario WHERE id_usuario="+sid_borrar;
         boolean resultadoUsuario=MySQL_Util.Ej_Consulta(Conn, borrarusuario);
          if (resultadoUsuario)
             {return "index";}
          else
             {return "error";}
         }
    else
         return "error";
    }
    
    public String Obtener_ID()
    {
           Map <String,Object> fila;
           String valorDevuelto;
           fila= (Map <String,Object>) tabla.getRowData();
           valorDevuelto=fila.get("id_usuario").toString();
           return valorDevuelto;
    }
    
    public String seleccionLista_Mod()
    { 
        sID_Usuario=Obtener_ID();
        return "a_usuario";
    }
    
    public String insertar_usuario()
    {
    sID_Usuario="";
    return "a_usuario";
    }
    
    public String insertar_personaje()
    {
    sID_Usuario="";
    return "a_personaje";
    }
    
    public String insertar_juego()
    {
    sID_Usuario="";
    return "a_juego";
    }
    
    public ArrayList getListaPersonajes()
    {
    ArrayList lista=MySQL_Util.Llenar_Lista(Conn, "select id_personaje as ID, nombre as NOMBRE from personajes");
    return lista;
    }
    
    public ArrayList getListaJuegos()
    {
    ArrayList lista=MySQL_Util.Llenar_Lista(Conn, "select id_juego as ID, nombre as NOMBRE from juegos");
    return lista;
    }
    
    public ArrayList getListaConsolas()
    {
    ArrayList lista=MySQL_Util.Llenar_Lista(Conn, "select id_consola as ID, nombreconsola as NOMBRE from consolas");
    return lista;
    }

    /**
     * @return the rset
     */
    public ResultSet getRset() {
        
        rset=MySQL_Util.Sel_Consulta(Conn, consultaSQL+sWhere, mensajeError);
        return rset;
    }

    /**
     * @param rset the rset to set
     */
    public void setRset(ResultSet rset) {
        this.rset = rset;
    }

    /**
     * @return the serror
     */
    public String getSerror() {
        return serror;
    }

    /**
     * @param serror the serror to set
     */
    public void setSerror(String serror) {
        this.serror = serror;
    }

    /**
     * @return the rspersonajes
     */
    public ResultSet getRspersonajes() {
          try
        {
           String consultaPersonajes="SELECT personajes.nombre\n" +
                "FROM personajes, personajes_favoritos\n" +
                "WHERE personajes_favoritos.id_usuario ="+rset.getString("id_usuario")+
                " AND personajes.id_personaje = personajes_favoritos.id_personaje";
           rspersonajes=MySQL_Util.Sel_Consulta(Conn, consultaPersonajes, mensajeError);
        }
        catch (Exception e)
        {
            rspersonajes=null;
        }
        return rspersonajes;
    }

    /**
     * @param rspersonajes the rspersonajes to set
     */
    public void setRspersonajes(ResultSet rspersonajes) {
        this.rspersonajes = rspersonajes;
    }

    /**
     * @return the rsjuegos
     */
    public ResultSet getRsjuegos() {
        try
        {
            String consultaJuegos="SELECT juegos.nombre\n" +
                "FROM juegos, juegos_favoritos\n" +
                "WHERE juegos_favoritos.id_usuario ="+rset.getString("id_usuario")+
                " AND juegos.id_juego = juegos_favoritos.id_juego";
           rsjuegos=MySQL_Util.Sel_Consulta(Conn, consultaJuegos, mensajeError);
        }
        catch (Exception e)
        {
            serror=e.toString();
        }
        
        return rsjuegos;
    }

    /**
     * @param rsjuegos the rsjuegos to set
     */
    public void setRsjuegos(ResultSet rsjuegos) {
        this.rsjuegos = rsjuegos;
    }
    
       /**
     * @return the tabla
     */
    public HtmlDataTable getTabla() {
        return tabla;
    }

    /**
     * @param tabla the tabla to set
     */
    public void setTabla(HtmlDataTable tabla) {
        this.tabla = tabla;
    }    

    /**
     * @return the sNombre
     */
    public String getsNombre() {
        return sNombre;
    }

    /**
     * @param sNombre the sNombre to set
     */
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }
}
