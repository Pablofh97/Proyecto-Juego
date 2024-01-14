import java.util.Random;
import java.util.Scanner;

public class JuegoNumero {
        
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion=0;
        do{
        System.out.println("Bienvenido al juego de adivinar el numero entre 0 y 100.");
        System.out.println("El programa tiene dos modos de juego, elija la opcion a la que desee jugar:");
        System.out.println("1. Pistas de mayor o menor.");
        System.out.println("2. Pistas matematicas.");
        
        System.out.println("----------------------------------------------------------------------------");
        opcion = teclado.nextInt();
        
        }while(opcion!=1 && opcion!=2);
        switch (opcion){
        
            case 1:
                primerModoJuego();
                break;  
            case 2:
                segundoModoJuego();
                break;     
            default:
                System.out.println("Opcion no valida.");
                break;     
        }
        teclado.close();
        }


    public static void primerModoJuego(){    
        Random random = new Random();
        int numeroAdivinar = random.nextInt(101);

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ha elejido las pistas de mayor o menor.");

        int intento;
        boolean acertado = false;

        while (acertado == false) {
            System.out.print("Introduce tu intento: ");
            intento = teclado.nextInt();

            if (intento == numeroAdivinar) {
                acertado = true;
                System.out.println("¡Felicidades! ¡Has adivinado el número!");
            } else if (intento < numeroAdivinar) {
                System.out.println("El número a adivinar es mayor. Intenta de nuevo.");
            } else {
                System.out.println("El número a adivinar es menor. Intenta de nuevo.");
            }
        }

        teclado.close();
    }
    public static void segundoModoJuego(){    
        Random random = new Random();
        int numeroAdivinar = random.nextInt(101);

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ha elejido las pistas matematicas.");
        int numIntento=1;
        int intento=-1;
        boolean acertado = false;
        out:
        while (acertado == false) {
            if (intento == numeroAdivinar){
                System.out.println("¡Felicidades! ¡Has adivinado el número!");
                acertado = true;
                break out;
            }else{
            System.out.println("Intrdouce tu intento numero "+numIntento);
            }
            switch (numIntento) {
                case 1:
                    if(numeroAdivinar <= 50 ){
                        System.out.println("El numero a adivinar esta entre [0,50].");
                    }else{
                        System.out.println("El numero a adivinar esta entre [51,100]. ");
                    }
                    break;
                case 2:
                    if(numeroAdivinar%2 == 0){
                        System.out.println("El numero a adivinar es par.");
                    }else{
                        System.out.println("El numero a adivinar es impar.");
                    }
                    break;
                case 3:
                    System.out.println("El numero a adivinar empieza por "+primerDigito(numeroAdivinar));    
                    
                default:
                    break;
            }
            intento = teclado.nextInt();
            numIntento++;

    }
    teclado.close();
    }
    public static int primerDigito(int numero){
        String numeroComoCadena = Integer.toString(numero);
        int primerDigito = Character.getNumericValue(numeroComoCadena.charAt(0));

        return primerDigito;

    }
}

