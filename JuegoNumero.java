import java.util.Random;
import java.util.Scanner;

public class JuegoNumero {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int opcion = seleccionarModoJuego(teclado);

            switch (opcion) {
                case 1:
                    primerModoJuego();
                    break;
                case 2:
                    segundoModoJuego();
                    break;
                case 3:
                    finalizarJuego();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            reiniciarJuego(teclado);
        }
    }

    public static int seleccionarModoJuego(Scanner teclado) {
        int opcion;

        do {
            System.out.println("Bienvenido al juego de adivinar el número entre 0 y 100.");
            System.out.println("El programa tiene dos modos de juego, elija la opcion a la que desee jugar:");
            System.out.println("1. Pistas de mayor o menor.");
            System.out.println("2. Pistas matemáticas.");
            System.out.println("3. Finalizar el juego y salir.");
            System.out.println("----------------------------------------------------------------------------");
            opcion = teclado.nextInt();
        } while (opcion != 1 && opcion != 2 && opcion != 3);

        return opcion;
    }

    public static void finalizarJuego() {
        System.out.println("¡Gracias por jugar! Hasta luego.");
    }

    public static void primerModoJuego() {
        Random random = new Random();
        int numeroAdivinar = random.nextInt(101);


        System.out.println("Ha elegido las pistas de mayor o menor.");

        int intento;
        boolean acertado = false;

        while (acertado == false) {
            System.out.print("Introduce tu intento: ");
            intento = teclado.nextInt();

            if(intento == numeroAdivinar){
                acertado = true;
                System.out.println("¡Felicidades! ¡Has adivinado el número!");
                break;
            } 
            else if(intento < numeroAdivinar){
                System.out.println("El número a adivinar es mayor. Intenta de nuevo.");
            } 
            else{
                System.out.println("El número a adivinar es menor. Intenta de nuevo.");
            }
        }
    }

    public static void segundoModoJuego() {
        Random random = new Random();
        int numeroAdivinar = random.nextInt(101);


        System.out.println("Ha elegido las pistas matematicas.");

        int numIntento=1;
        int intento=-1;
        boolean acertado = false;

        while (acertado == false) {
            if (intento == numeroAdivinar){
                System.out.println("¡Felicidades! ¡Has adivinado el número!");
                acertado = true;
                break;
            }
            else{
            System.out.println("Introduce tu intento número "+numIntento);
            }
            switch (numIntento) {
                case 1:
                    if(numeroAdivinar <= 50 ){
                        System.out.println("El número a adivinar esta entre [0,50].");
                    }
                    else{
                        System.out.println("El número a adivinar esta entre [51,100]. ");
                    }
                    break;
                case 2:
                    if(numeroAdivinar%2 == 0){
                        System.out.println("El número a adivinar es par.");
                    }
                    else{
                        System.out.println("El número a adivinar es impar.");
                    }
                    break;
                case 3:
                    if(esPrimo(numeroAdivinar)== true){
                        System.out.println("El número a adivinar es primo.");
                    }
                    else{
                        System.out.println("El número a adivinar no es primo.");
                    }
                    break;
                case 4:
                    if(esPerfecto(numeroAdivinar)){
                        System.out.println("El número a adivinar es perfecto.");
                    }
                    else{
                        System.out.println("El número a adivinar no es perfecto.");
                    }
                    break; 
                case 5:
                    if(esAbundante(numeroAdivinar)){
                        System.out.println("El número a adivinar es abundante.");
                    }
                    else{
                        System.out.println("El número a adivinar no es abundante.");
                    }
                    break;  
                case 6:
                    if(esDefectivo(numeroAdivinar)){
                        System.out.println("El número a adivinar es defectivo.");
                    }
                    else{
                        System.out.println("El número a adivinar no es defectivo.");
                    }
                    break;         

                case 7:
                    System.out.println("El número a adivinar empieza por "+primerDigito(numeroAdivinar));    
                    break;
                case 8:
                    System.out.println("El número a adivinar se encuentra entre "+(numeroAdivinar-1)+" y "+(numeroAdivinar+1)+".");
                    break;
                default:
                    break;
            }

            intento = teclado.nextInt();
            numIntento++;
        } 
    }

    public static void reiniciarJuego(Scanner teclado) {
        System.out.println("¿Desea volver a jugar? (1: Sí / 0: No)");
        int jugarNuevamente = teclado.nextInt();

        if (jugarNuevamente == 1) {
            
        } else {
            System.out.println("¡Gracias por jugar! Hasta luego.");
            
        }
    }
}


    