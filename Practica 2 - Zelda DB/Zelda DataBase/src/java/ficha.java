/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author usuario
 */
public class ficha {
    String sdriver="com.mysql.jdbc.Driver";  
    String sUrl_JDBC="jdbc:mysql://localhost:3306/zelda";
    String consultaSQL="SELECT usuario.id_usuario, usuario.nombre, usuario.edad, usuario.zelda, consolas.nombreconsola\n" +
                        "FROM usuario, consolas\n" +
                        "WHERE usuario.id_consola = consolas.id_consola";
    private Statement stmt;
    private Connection conn;
    private ResultSet rset;
    private String serror;
    private ResultSet rspersonajes;
    private ResultSet rsjuegos;
    /**
     * Creates a new instance of ficha
     */
    public ficha() {
        try
        {
            Class.forName(sdriver);
     
        }
        catch (Exception e)
        {
            serror=e.toString();
        }
        
        //crear objeto connection
         try
        {
            conn=DriverManager.getConnection(sUrl_JDBC,"root","");
            serror="conexión realizada con éxito";
        }
        catch (Exception e)
        {
            serror=e.toString();
        }
           //crear objeto statetement y proceso
         try
        {
           stmt=conn.createStatement();
           rset=stmt.executeQuery(consultaSQL);
           serror+=", ejecuta la select";
        }
        catch (Exception e)
        {
            serror=e.toString();
        }
    }

    /**
     * @return the rset
     */
    public ResultSet getRset() {
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
           Statement stmt2=conn.createStatement();
           rspersonajes=stmt2.executeQuery(consultaPersonajes);
        }
        catch (Exception e)
        {
            serror=e.toString();
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
           Statement stmt3=conn.createStatement();
           rsjuegos=stmt3.executeQuery(consultaJuegos);
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
    
}
