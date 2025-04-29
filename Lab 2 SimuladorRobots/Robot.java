//Clase Robot
public class Robot{
    private String nombre;
    private int puntosDeVida;
    private int ataque;
        
    //Metodo constructor estandar
    public Robot( String nombre, int puntosDeVida, int ataque){
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.ataque = ataque;
    }

    //Setters y getters
    public void setPuntosDeVida(int puntosDeVida){
        this.puntosDeVida = puntosDeVida;
    }
    public int getPuntosDeVida(){
        return this.puntosDeVida;
    }
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    public int getAtaque(){
        return this.ataque;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    //Funciones
    public void atacar(Robot robotAtacado){
        int nuevosPuntosDeVida = robotAtacado.getPuntosDeVida() - this.ataque; //Reducir puntos de vida del robot atacado.
        robotAtacado.setPuntosDeVida( nuevosPuntosDeVida); //Nuevos puntos de vida
    }
    public boolean estarVivo(){
        return this.puntosDeVida > 0; //devuelve true or false, en caso de que el Robot tenga puntos de vida o no.
    
    }

}