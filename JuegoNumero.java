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

        System.out.println("¿Desea volver a jugar? (1: Sí / 0: No)");
        int jugarNuevamente = teclado.nextInt();
    
        if (jugarNuevamente == 1) {
            main(args);
        } 
        else{
            System.out.println("¡Gracias por jugar! Hasta luego.");
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
                break;
            } 
            else if(intento < numeroAdivinar) {
                System.out.println("El número a adivinar es mayor. Intenta de nuevo.");
            } 
            else{
                System.out.println("El número a adivinar es menor. Intenta de nuevo.");
            }
        }
    }

    public static void segundoModoJuego(){    
        Random random = new Random();
        int numeroAdivinar = random.nextInt(101);

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ha elejido las pistas matematicas.");
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
                default:
                    break;
            }
            intento = teclado.nextInt();
            numIntento++;
        } 
    }

    public static int primerDigito(int numero){
        String numeroComoCadena = Integer.toString(numero);
        int primerDigito = Character.getNumericValue(numeroComoCadena.charAt(0));

        return primerDigito;

    }

    public static boolean esPrimo(int numero){

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                //Si el número es divisible por algún otro número, no es primo
                return false;
            }
        }
        return true;
    }
    public static boolean esPerfecto(int numero){
        int suma=0;
        for (int i = numero - 1; i >= 1; i--) {
            if (numero%i == 0){
                suma += i;
            }
        }
    
        if (numero == suma) {
            return true;
        } else {
            return false;
            }
    
    }
    public static boolean esDefectivo(int numero){
        int suma=0;
        for (int i = 1 ; i <= 1; i++) {
                    if (numero%i == 0){
                        suma += i;
                    }
                }
    
                if (numero > suma) {
                    return true;
                } else {
                    return false;
                    }
    }
    public static boolean esAbundante(int numero){
        int suma=0;
        for (int i = 1; i <= numero ; i++) {
                    if (numero%i == 0){
                        suma = suma + i;
                    }
                }
    
                if (suma > 2*numero) {
                    return true;
                } else {
                    return false;
                }
    }

}

    