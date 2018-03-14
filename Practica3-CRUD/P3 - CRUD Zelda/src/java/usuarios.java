import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class usuarios {

   private String nombre;
   private int edad;
   private String mundo;
   private String[] personajes;
   private String[] juego;
   private int consola;
   
   private ArrayList listaMundo=null;
   private ArrayList listaPersonajes=null;
   private ArrayList listaJuego=null;
   private ArrayList listaConsolas=null;
   private String muestraConsola;
   private String muestraJuego;
   private String muestraPersonajes;
   private String muestraMundo;


   
    public usuarios() {
        
        if (!ficha.sID_Usuario.equals(""))
        {
        recoge_usuarios(ficha.sID_Usuario);
        }
    }
    
     private void recoge_usuarios(String sID_Usuario) {
        
         String sql="select * from usuario where id_usuario="+sID_Usuario;
         ResultSet rs=MySQL_Util.Sel_Consulta(ficha.Conn, sql);
         nombre=MySQL_Util.Leer_Campo(rs, "nombre");
         edad=parseInt(MySQL_Util.Leer_Campo(rs, "edad"));
         mundo=MySQL_Util.Leer_Campo(rs, "zelda");
         consola=parseInt(MySQL_Util.Leer_Campo(rs, "id_consola"));
         
         String sqlPersonajes="select id_personaje from personajes_favoritos where id_usuario="+sID_Usuario;
         personajes=MySQL_Util.Llenar_Seleccionados(ficha.Conn,sqlPersonajes,"id_personaje");
         
         String sqlJuegos="select id_juego from juegos_favoritos where id_usuario="+sID_Usuario;
         juego=MySQL_Util.Llenar_Seleccionados(ficha.Conn,sqlJuegos,"id_juego");
    }
     
     public String guardar_U()
    {
    boolean bRes=false;
    if (ficha.sID_Usuario.equals(""))
    /*Si estoy añadiendo un usuario*/
    {
        bRes=insertar_U();
    }    
    else
        /* estoy modificando un usuario */
    {bRes=actualizar_U();}
     if(bRes)
                return "index";
     else
            return "error";
    
    }
     
    public boolean insertar_U()
    {
        String sqlInsertar="insert into usuario (nombre, edad, zelda, id_consola) "
                + "VALUES ('"+nombre+"', "+edad+", '"+mundo+"', '"+consola+"')";
        int n=MySQL_Util.Ej_Consulta_ID_Auto(ficha.Conn,sqlInsertar);
        String[] sInsertsPersonajes=new String[personajes.length];
        
        for (int i=0;i<personajes.length;i++)
        {
            sInsertsPersonajes[i]="INSERT INTO personajes_favoritos VALUES("+n+","+personajes[i]+")";
        }
        String[] sInsertsJuegos=new String[juego.length];
        for (int i=0;i<juego.length;i++)
        {
            sInsertsJuegos[i]="INSERT INTO juegos_favoritos VALUES("+n+","+juego[i]+")";
        }
        
        return (MySQL_Util.Ej_Consulta_Trans(ficha.Conn, sInsertsPersonajes) && MySQL_Util.Ej_Consulta_Trans(ficha.Conn, sInsertsJuegos));
    }
    
     public boolean actualizar_U()
    {
        String[] cadJuegos=new String[juego.length+1];
        String[] cadPersonajes=new String[personajes.length+1];
        String cadUpdate="UPDATE usuario SET nombre='"+nombre+"',edad='"+edad+"',zelda='"+mundo+"',id_consola='"+consola+"' WHERE id_usuario="+ficha.sID_Usuario;
        if (MySQL_Util.Ej_Consulta(ficha.Conn, cadUpdate))
        {
            cadJuegos[0]="delete from juegos_favoritos where id_usuario="+ficha.sID_Usuario;
            for (int i=0;i<juego.length;i++)
            {
                cadJuegos[i+1]="Insert into juegos_favoritos(id_usuario, id_juego) VALUES ('"+ficha.sID_Usuario+"','"+juego[i]+"')";
            }
            cadPersonajes[0]="delete from personajes_favoritos where id_usuario="+ficha.sID_Usuario;
            for (int i=0;i<personajes.length;i++)
            {
                cadPersonajes[i+1]="Insert into personajes_favoritos(id_usuario, id_personaje) VALUES ('"+ficha.sID_Usuario+"','"+personajes[i]+"')";
            }
        }
        return (MySQL_Util.Ej_Consulta_Trans(ficha.Conn, cadJuegos) && MySQL_Util.Ej_Consulta_Trans(ficha.Conn, cadPersonajes));
    }    

    /**
     * @return the muestraMundo
     */
    public String getMuestraMundo() {
        return mundo;
    }
    
        /**
     * @param muestraJuego the muestraJuego to set
     */
    public void setMuestraJuego(String muestraJuego) {
        this.muestraJuego = muestraJuego;
    }

    /**
     * @return the muestraPersonajes
     */
    public String getMuestraPersonajes() {
        return concatenar(personajes);
    }

    /**
     * @param muestraPersonajes the muestraPersonajes to set
     */
    public void setMuestraPersonajes(String muestraPersonajes) {
        this.muestraPersonajes = muestraPersonajes;
    }

    /**
     * @param muestraMundo the muestraMundo to set
     */
    public void setMuestraMundo(String muestraMundo) {
        this.muestraMundo = muestraMundo;
    }
  
    public String getMuestraJuego(){
        return concatenar(juego);
        
    }
    public String concatenar (String[] vector){
        String cad="";
        for (String s:vector){
            cad+=s+", ";
        }
        return cad.substring(0, cad.length()-2);
    }

    public ArrayList getListaPersonajes() {
        return (MySQL_Util.Llenar_Lista(ficha.Conn, "select id_personaje as ID, nombre as NOMBRE from personajes"));
    }
      
      
      public ArrayList getListaJuego() {
        return (MySQL_Util.Llenar_Lista(ficha.Conn, "select id_juego as ID, nombre as NOMBRE from juegos"));
    }

     /**
     * @return the listaConsolas
     */
    public ArrayList getListaConsolas() {
        return (MySQL_Util.Llenar_Lista(ficha.Conn, "select id_consola as ID, nombreconsola as NOMBRE from consolas"));
    }
    
    
      public ArrayList getListaMundo() {
        setListaMundo(new ArrayList());
        listaMundo.add(new SelectItem("Si", "Si"));
        listaMundo.add(new SelectItem("No", "No"));
        return listaMundo;
    }    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the mundo
     */
    public String getMundo() {
        return mundo;
    }

    /**
     * @param mundo the mundo to set
     */
    public void setMundo(String mundo) {
        this.mundo = mundo;
    }

    /**
     * @return the personajes
     */
    public String[] getPersonajes() {
        return personajes;
    }

    /**
     * @param personajes the personajes to set
     */
    public void setPersonajes(String[] personajes) {
        this.personajes = personajes;
    }

    /**
     * @return the juego
     */
    public String[] getJuego() {
        return juego;
    }

    /**
     * @param juego the juego to set
     */
    public void setJuego(String[] juego) {
        this.juego = juego;
    }

    /**
     * @return the consola
     */
    public int getConsola() {
        return consola;
    }

    /**
     * @param consola the consola to set
     */
    public void setConsola(int consola) {
        this.consola = consola;
    }

    /**
     * @param listaMundo the listaMundo to set
     */
    public void setListaMundo(ArrayList listaMundo) {
        this.listaMundo = listaMundo;
    }

    /**
     * @param listaPersonajes the listaPersonajes to set
     */
    public void setListaPersonajes(ArrayList listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    /**
     * @param listaJuego the listaJuego to set
     */
    public void setListaJuego(ArrayList listaJuego) {
        this.listaJuego = listaJuego;
    }

    /**
     * @param listaConsolas the listaConsolas to set
     */
    public void setListaConsolas(ArrayList listaConsolas) {
        this.listaConsolas = listaConsolas;
    }

    /**
     * @return the muestraConsola
     */
    public String getMuestraConsola() {
        return muestraConsola;
    }

    /**
     * @param muestraConsola the muestraConsola to set
     */
    public void setMuestraConsola(String muestraConsola) {
        this.muestraConsola = muestraConsola;
    }
}

