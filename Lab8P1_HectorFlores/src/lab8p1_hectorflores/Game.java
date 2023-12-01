package lab8p1_hectorflores;

import java.util.ArrayList;

public class Game {
    int [][] tablero;
    int [][] tablero_next;
    ArrayList <String> coordenadas = new ArrayList<>();
    int rondas;

    public Game() {
    }

    public Game(int[][] tablero) {
        this.tablero = tablero;
    }

    public Game(ArrayList<String> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Game(int rondas) {
        this.rondas = rondas;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public int[][] getTablero_next() {
        return tablero_next;
    }

    public void setTablero_next(int[][] tablero_next) {
        this.tablero_next = tablero_next;
    }

    public ArrayList<String> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<String> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }
    
    public void jugar (int rondas){
        for (int i = 0; i <= rondas; i++){
            if (i == 0){
                System.out.println("----------Generacion 0----------");
            } else {
                System.out.println("----------Ronda " + i + "----------");
            }
            nextGen();
            Print(coordenadas);
        }
    }

    public int contarVecinosVivos(int [][] tablero, int i, int j){
        int vivos = 0;
        
        if (tablero[i-1][j-1] == 1){
        vivos++;
        }
        if (tablero[i-1][j] == 1){
            vivos++;
        }
        if (tablero[i-1][j+1] == 1){
            vivos++;
        }
        if (tablero[i][j-1] == 1){
            vivos++;
        }
        if (tablero[i][j+1] == 1){
            vivos++;
        }
        if (tablero[i+1][j-1] == 1){
            vivos++;
        }
        if (tablero[i+1][j] == 1){
            vivos++;
        }
        if (tablero[i+1][j+1] == 1){
            vivos++;
        }
        
        return vivos;
    }
    
    public ArrayList <String> nextGen(){
        tablero_next = new int [10][10];
        coordenadas.clear();
        
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                
                if (i == 0 || i == 9 || j == 0 || j == 9){
                    continue;
                } else {
                    if (tablero [i][j] == 1 && contarVecinosVivos(tablero, i, j) < 2){
                        tablero_next [i][j] = 0;
                    } else if (tablero [i][j] == 1 && contarVecinosVivos(tablero, i, j) > 3){
                        tablero_next [i][j] = 0;
                    } else if (tablero [i][j] == 0 && contarVecinosVivos(tablero, i, j) == 3){
                        tablero_next [i][j] = 1;
                    } else if (tablero [i][j] == 1 && contarVecinosVivos(tablero, i, j) == 2){
                        tablero_next [i][j] = 1;
                    }
                }
            }
        }
        
        tablero = tablero_next;
        
        for (int i = 0; i < tablero_next.length; i++){
            for (int j = 0; j < tablero_next[i].length; j++){
                if (tablero_next [i][j] == 1){
                    coordenadas.add(i + ":" + j);
                }
            }
        }
        
        System.out.println("Arraylist:");
        
        return coordenadas;
        
    }
    
    public void Print(ArrayList <String> coordenadas){
        String coordenada;
        int coordenada_x = ' ';
        int coordenada_y = ' ';
        int [][] temporal = new int [10][10];
        
        for (int i = 0; i < coordenadas.size(); i++){
            coordenada = coordenadas.get(i);
            coordenada_x = coordenada.charAt(0) - '0';
            coordenada_y = coordenada.charAt(2) - '0';
            temporal[coordenada_x][coordenada_y] = 1;
        }
        
        imprimirArrayList(coordenadas);
        imprimirMat(temporal);
    }
    
    public void imprimirMat(int [][]x){
        for (int i = 0; i < x.length; i++){
            for (int j = 0; j < x[i].length; j++){
                System.out.print("[" + x[i][j] + "]");
            }
            System.out.println("");
        }
    }
    
    public void imprimirArrayList(ArrayList <String> x){
        System.out.print("[");
        for (int i = 0; i < x.size(); i++){
            if (i != x.size() - 1){
                System.out.print(x.get(i) + ", ");
            } else {
                System.out.print(x.get(i) + "]");
            }
        }
        System.out.println("");
    }
}
