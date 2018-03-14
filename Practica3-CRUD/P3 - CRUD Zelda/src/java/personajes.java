/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class personajes {
    
    private String nuevopersonaje;

    /**
     * Creates a new instance of personajes
     */
    public personajes() {
    }
    
    public String guardar_P()
    {   String sql="INSERT INTO personajes(nombre) VALUES ('"+nuevopersonaje+"')";
        boolean consulta=MySQL_Util.Ej_Consulta(ficha.Conn, sql);
        
        if (consulta)        
            return "index";
        else
            return "error";
    }

    /**
     * @return the nuevopersonaje
     */
    public String getNuevopersonaje() {
        return nuevopersonaje;
    }

    /**
     * @param nuevopersonaje the nuevopersonaje to set
     */
    public void setNuevopersonaje(String nuevopersonaje) {
        this.nuevopersonaje = nuevopersonaje;
    }
}
