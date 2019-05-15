
package classes;

/**
 *
 * @author SaraPdrui
 */
public class Game {
    
    private String nombre; //String que recoge el nombre de una partida
    private MainCharacter personaje;//Personaje que recoge el personaje de una partida
    private Philosopher filosofos; // Array list que recoge a los filósofos superados en la partida
    
    /**
     * Constructor de la una Partida
     * @param nombre
     * @param personaje
     * @param filosofos 
     */
    public Game(String nombre, MainCharacter personaje, Philosopher filosofos) {
        this.nombre = nombre;
        this.personaje = personaje;
        this.filosofos = filosofos;
    }
    
    /**
     * Obtiene un nombre tipo String
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece un nombre tipo String
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene un personaje tipo personaje
     * @return personaje
     */
    public MainCharacter getPersonaje() {
        return personaje;
    }
    
    /**
     * Establece un personaje tipo Personaje
     * @param personaje 
     */
    public void setPersonaje(MainCharacter personaje) {
        this.personaje = personaje;
    }
    
    /**
     * Obtiene un array list de filosofos tipo Filosofo
     * @return filosofos
     */
    public Philosopher getFilosofos() {
        return filosofos;
    }
    
    /**
     * Establece un array list de filosofos tipo Filosofo
     * @param filosofos 
     */
    public void setFilosofos(Philosopher filosofos) {
        this.filosofos = filosofos;
    }
    
    
    
}//Fin clase
