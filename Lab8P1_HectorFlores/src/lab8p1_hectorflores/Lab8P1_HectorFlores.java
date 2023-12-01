//Fila 3 Asiento 10
//Piedad Eduardo, te quiero <3

package lab8p1_hectorflores;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Lab8P1_HectorFlores {
    static Random random = new Random();
    static Scanner sc = new Scanner (System.in);
    static Game g = new Game();
    
    public static int [][] recibir(int [][]tablero, int [][]next, ArrayList <String> coordenadas){
        int [][] temporal = new int [10][10];
        
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                if (i == 0 || i == 9 || j == 0 || j == 9){
                    temporal[i][j] = 0;
                } else {
                    temporal[i][j] = random.nextInt(2);
                    if (temporal[i][j] == 1){
                        coordenadas.add(i + ":" + j);
                    }
                }
            }
        }
        
        return temporal;
    }
    
    public static void main(String[] args) {
        System.out.println("1. Juego de la vida");
        System.out.println("2. Salir");
        System.out.println("Ingrese su opcion");
        int opcion = sc.nextInt();
        
        while (true){
            if (opcion == 1 || opcion == 2){
                break;
            } else {
                System.out.println("Ingrese 1 o 2");
                opcion = sc.nextInt();
            }
        }
        
        while (opcion == 1){
            System.out.println("Juego de la vida");
            System.out.println("Cuantas rondas desea presenciar?");
            int rondas = sc.nextInt();
            
            int [][] tablero = new int [10][10];
            int [][] tablero_next = new int [10][10];
            ArrayList <String> coordenadas = new ArrayList<>();
            tablero = recibir(tablero, tablero_next, coordenadas);
            
            g.setTablero(tablero);
            
            g.setTablero_next(tablero_next);
            
            g.jugar(rondas);
            
            System.out.println("1. Juego de la vida");
            System.out.println("2. Salir");
            System.out.println("Ingrese su opcion");
            opcion = sc.nextInt();
            
            while (true){
                if (opcion == 1 || opcion == 2){
                    break;
                } else {
                    System.out.println("Ingrese 1 o 2");
                    opcion = sc.nextInt();
                }
            }
        }
        System.out.println("Salio del programa");
    }
    
}
