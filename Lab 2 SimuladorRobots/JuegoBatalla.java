import java.util.Scanner;
import java.util.Random;

public class JuegoBatalla {
    private Robot[] participantes; //Declarar array

    //Funciones
    public void iniciarBatalla(){
        Random rand = new Random();
        for( int i = 0; 1 < participantes.length; i++){ //contador para recorrer cada una de las "casillas" de array
            if(participantes[i] != null && participantes[i].estarVivo()){ //garantiza que el robot que va a realizar el ataque este vivo
                int otroRobot; //declarar robot a atacar
                do {
                    otroRobot = rand.nextInt(participantes.length); //eleccion al azar del robot atacado
                } while( otroRobot == i || participantes[otroRobot] == null || !participantes[otroRobot].estarVivo()); //garantizar que el robot a atacar este vivo y que sea distinto al que ataca
                participantes[i].atacar(participantes[otroRobot]);
                System.out.println(participantes[i].getNombre() + " atacó a " + 
                participantes[otroRobot].getNombre());
            }
        }
    }
    public void mostrarGanador(){
        for (int i = 0; i < participantes.length; i++) { //recorrer cada casilla 
            if(participantes[i] != null && participantes[i].estarVivo()) {
                System.out.println("¡El robot ganador es " + participantes[i].getNombre() + "!");
                return;
                }
            
            System.out.println("¡No hay robots vivos!");
        
            }
        }
    
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println( "Ingrese cantidad de robot(2-10) = "); //Pide al usuario un numero de robot entre 2 y 10
        int numeroDeRobots = scanner.nextInt();
        scanner.nextLine();
        
        if (numeroDeRobots < 2 || numeroDeRobots > 10) { //respaldo por si el numero no coincide
            System.out.println("La cantidad es invalida");
            scanner.close();
            return;
        }

        Robot[] luchadores = new Robot[numeroDeRobots];//inicialización del array de objetos

        for(int i = 0; i < numeroDeRobots; i++) { //recorre el array poniendo nombres y atributos a los robots
            System.out.println("\nRobot " + (i+1) + ":");
            System.out.println("Ingrese nombre :");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese cantidad de vida (50-100)"+ ":");
            int vida = scanner.nextInt();
            System.out.print("Ingrese cantidad de daño en ataque (10-20) " + ":");
            int cantidadDeAtaque = scanner.nextInt();
            scanner.nextLine();
            luchadores[i] = new Robot(nombre, vida, cantidadDeAtaque); //ejecuta el constructor
        }

        JuegoBatalla juego = new JuegoBatalla(); 
        juego.participantes = luchadores;
        
        System.out.println("\n¡COMIENZA LA BATALLA!");
        juego.iniciarBatalla();
        juego.mostrarGanador();
        
        scanner.close();
    }

}
    