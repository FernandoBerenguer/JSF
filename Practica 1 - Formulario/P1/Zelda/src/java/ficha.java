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
public class ficha {

   private String nombre;
   private int edad;
   private String mundo;
   private String[] personajes;
   private String[] juego;
   private String consola;
   
   private ArrayList listaMundo=null;
   private ArrayList listaPersonajes=null;
   private ArrayList listaJuego=null;
   private String muestraJuego;
   private String muestraPersonajes;
   private String muestraMundo;


   
    public ficha() {
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
        setListaPersonajes(new ArrayList());
        listaPersonajes.add(new SelectItem("Link", "Link"));
        listaPersonajes.add(new SelectItem("Zelda", "Zelda"));
        listaPersonajes.add(new SelectItem("Ganondorf", "Ganondorf"));
        listaPersonajes.add(new SelectItem("Tingle", "Tingle"));
        return listaPersonajes;
    }
      
      
      public ArrayList getListaJuego() {
        setListaJuego(new ArrayList());
        listaJuego.add(new SelectItem("The Legend of Zelda", "The Legend of Zelda"));
        listaJuego.add(new SelectItem("A Link to the past", "A Link to the past"));
        listaJuego.add(new SelectItem("Link's Awakening", "Link's Awakening"));
        listaJuego.add(new SelectItem("Ocarina of Time", "Ocarina of Time"));
        listaJuego.add(new SelectItem("Twilight Princess", "Twilight Princess"));
        listaJuego.add(new SelectItem("Skyward Sword", "Skyward Sword"));
        return listaJuego;
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
    public String getConsola() {
        return consola;
    }

    /**
     * @param consola the consola to set
     */
    public void setConsola(String consola) {
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
}

