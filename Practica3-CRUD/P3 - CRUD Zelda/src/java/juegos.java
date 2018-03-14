/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class juegos {
    
    private String nuevojuego;

    /**
     * @return the nuevojuego
     */
    public String getNuevojuego() {
        return nuevojuego;
    }

    /**
     * @param nuevojuego the nuevojuego to set
     */
    public void setNuevojuego(String nuevojuego) {
        this.nuevojuego = nuevojuego;
    }
    /**
     * Creates a new instance of juegos
     */
    public juegos() {
    }
    public String guardar_J()
    {   String sql="INSERT INTO juegos(nombre) VALUES ('"+getNuevojuego()+"')";
        boolean consulta=MySQL_Util.Ej_Consulta(ficha.Conn, sql);
        
        if (consulta)        
            return "index";
        else
            return "error";
    }
}
