package sudoku;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author JersonJr && JHM
 */
public class Index 
{

    //--Instancias
    
    Scanner sc = new Scanner(System.in);
    SudokuEasy easy = new SudokuEasy();
    SudokuEasy easypass = new SudokuEasy();
    SudokuHard hard = new SudokuHard();
    SudokuHard hardpass = new SudokuHard();
    private String[][] pass;

    //-- Menú inicial
    
    public void Menu() 
    {
        System.out.println("--------Sudoku-------");

        System.out.println("1 - Sudoku");     
        System.out.println("2 - Salir");
        //System.out.println("2 - Sudoku Difícil");

        this.options(sc.nextInt());
    }

    //--Opción seleccionada por el usuario
    
    public void options(int option) 
    {
        switch (option) 
        {
            case 1: //--Sudoku Fácil

                System.out.println("Seleccionaste sudoku \n"); //--Sudoku Fácil
                this.printSudoku(easy.initEasy());
                System.out.println();
                System.out.println("¿Resolver S/N ?");
                this.decision(sc.next(), easy.initEasy(), easypass.initEasy());
                break;

            case 2: //--Sudoku Difícil
                   
                /*
                
                System.out.println("Seleccionaste sudoku Difícil \n");
                this.printSudoku(hard.initHard());
                System.out.println();
                System.out.println("¿Resolver S/N ?");
                this.decision(sc.next(), hard.initHard(), hardpass.initHard());
                
                */
                
                System.out.println("Hasta pronto");
                break;

            default:
                throw new AssertionError();
        }
    }

    /*
    * Pintar sudoku 9x9
    *
    *
    * @param String[][]
    * @return Message
     */
    public void printSudoku(String[][] sudoku) 
    {
        for (int i = 0; i < 9; i++) {

            if (i == 0 || i == 3 || i == 6) {
                System.out.println("-------------------");
            }

            System.out.println("|" + sudoku[i][0] + " " + sudoku[i][1] + " " + sudoku[i][2] + "|" + sudoku[i][3] + " " + sudoku[i][4] + " " + sudoku[i][5] + "|" + sudoku[i][6] + " " + sudoku[i][7] + " " + sudoku[i][8] + "|");
        }

        System.out.println("-------------------");

    }

    /*
    * Válida si se debe iniciar el proceso para resolver el sudoku
    *
    * @param String , String[][]
    * @return Message
    */
    
    public void decision(String s, String[][] sudoku, String[][] pass) 
    {
        if ("N".equals(s)) 
        {
            System.out.println("Hasta pronto ☺");

        } else 
        {
            //--Resolver soduko
            
            int matrizVetados[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //--Almacenará los números (1,2,3,...) de las matrices que se vayan vetando
            this.printSudoku(this.solve(sudoku, matrizVetados, pass));
        }
    }

    /*
    * Realiza todas las validaciones necesarias para entregar un sudoku resuelto
    *
    * @param String[][] , int[] , String[][]
    * @return String[][]
    */
    
    public String[][] solve(String[][] sudoku, int[] matrizVetados, String[][] pass) 
    {
        String[][] sudokuRespuesta = null;

        //-- Busqueda de matriz 3x3 con más números o menos espacios vacíos 
        
        int[] XY = this.busqueda(sudoku, matrizVetados);

        if (XY[0] != 0) 
        {            
            sudokuRespuesta = this.poner(sudoku, this.matriz3x3(sudoku, XY[1], XY[2]), XY);

            if (Arrays.deepEquals(sudokuRespuesta, pass)) 
            {
                matrizVetados[this.posicionM3x3(XY[1], XY[2])] = this.posicionM3x3(XY[1], XY[2]);
            } else 
            {
                pass = this.poner(pass, this.matriz3x3(pass, XY[1], XY[2]), XY);
                
                //--Limpiar vector vetados
                
                matrizVetados = this.cleanVetados(matrizVetados);

            }
            
            
            /*
                Validar si el sudoku está resuelto, de lo contrario se llamará recursivamente.           
            */
            
            if (this.isComplete(sudokuRespuesta)) 
            {
                return sudokuRespuesta;
            } else 
            {
                this.solve(sudokuRespuesta, matrizVetados, pass);
            }
            
            
        } else 
        {   
            //--Limpiar vector vetados
            
            matrizVetados = this.cleanVetados(matrizVetados);
            int[] XY2 = this.busqueda2(sudoku, matrizVetados);
            
            sudokuRespuesta = this.poner2(sudoku, this.matriz3x3(sudoku, XY2[1], XY2[2]), XY2);
            if (!Arrays.deepEquals(sudokuRespuesta, pass)) 
            {
                pass = this.poner2(pass, this.matriz3x3(pass, XY2[1], XY2[2]), XY2);
            }
            
            if (this.isComplete(sudokuRespuesta)) 
            {
                return sudokuRespuesta;
            } else {
                this.solve(sudokuRespuesta, matrizVetados, pass);
            }
        }
        
         return sudokuRespuesta;
    }
    
    
    public int[] cleanVetados(int[] matrizVetados)
    {
        for (int i = 0; i < 10; i++) 
        {
            matrizVetados[i] = 0;
        }
        
        return matrizVetados;
    }

    /*
    * Valida si el sudoku no tiene espacios vacíos
    *
    * @params String[][]
    * @return Boolean
    */
    
    public boolean isComplete(String[][] sudoku) {
        boolean respuesta = true;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (" ".equals(sudoku[i][j])) {
                    respuesta = false;
                }
            }
        }

        return respuesta;
    }

    /*
        Retorna la posición que corresponde a la matriz 3x3
        
     */
    public int posicionM3x3(int a, int b) {
        int respuesta = 0;

        if (a >= 0 && a <= 2 && b >= 0 && b <= 2) {
            respuesta = 1;

        } else if (a >= 0 && a <= 2 && b >= 3 && b <= 5) {
            respuesta = 2;

        } else if (a >= 0 && a <= 2 && b >= 6 && b <= 8) {
            respuesta = 3;

        } else if (a >= 3 && a <= 5 && b >= 0 && b <= 2) {
            respuesta = 4;
        } else if (a >= 3 && a <= 5 && b >= 3 && b <= 5) {
            respuesta = 5;

        } else if (a >= 3 && a <= 5 && b >= 6 && b <= 8) {
            respuesta = 6;
        } else if (a >= 6 && a <= 8 && b >= 0 && b <= 2) {
            respuesta = 7;

        } else if (a >= 6 && a <= 8 && b >= 3 && b <= 5) {
            respuesta = 8;
        } else if (a >= 6 && a <= 8 && b >= 6 && b <= 8) {
            respuesta = 9;

        }

        return respuesta;
    }

    /*
        Recorre toda la matriz 9x9 en busqueda de la matriz 3x3 que más números contenga (Menos espacios vacíos y retorna un vector donde las posiciones son:
            [0] = Cantidad de números encontrados en una matriz 3x3
            [1] = Coordenada final en X de la matriz 3x3 donde se encontró el mayor número de números
            [2] = Coordenada final en Y de la matriz 3x3 donde se encontró el mayor número de números
    
        @param String[][] , int[]
        @return int[]
    
    */
    
    public int[] busqueda(String[][] sudoku, int[] matrizVetados) {

        int numerosEncontrados = 0;
        int Columna = 3; //-- Posición Columna
        int Fila = 3; //-- Posición Fila
        int[] M = new int[3]; //--Vector que lleva el mayor número de números, y la posicion del número
        M[0] = 0;
        int posicionX = 0; //--Última columna de M

        int i = 0;

        for (int k = 0; k < 36; k++) //--36 es el número de ciclos que debe hacer, por cada 3x3 se hacen 4 iteraciones
        {
            if (i < Fila) {
                for (int j = Columna - 3; j < Columna; j++) {
                    if (this.posicionM3x3(i, j) != matrizVetados[this.posicionM3x3(i, j)]) {
                        if (!" ".equals(sudoku[i][j])) {
                            numerosEncontrados++;
                        }
                        posicionX = j;
                    }
                }

                i++;
            } else {
                //-- Si la cantidad de números de la matriz 3x3 es mayor a la anterior entonces esta será la nueva matriz de busqueda

                if (numerosEncontrados > M[0]) {
                    M[0] = numerosEncontrados;
                    M[1] = i - 1;
                    M[2] = posicionX;
                }

                numerosEncontrados = 0;
                Columna += 3;

                if (Columna == 12) {
                    Columna = 3;
                    Fila += 3;
                }

                i = Fila - 3;

            }
        }

        return M;
    }

    
    
    /*
        Recorre toda la matriz 9x9 en busqueda de la matriz 3x3 que más números contenga (Menos espacios vacíos y retorna un vector donde las posiciones son:
            [0] = Cantidad de números encontrados en una matriz 3x3
            [1] = Coordenada final en X de la matriz 3x3 donde se encontró el mayor número de números
            [2] = Coordenada final en Y de la matriz 3x3 donde se encontró el mayor número de números
    
        @param String[][]
        @return int[]
    
    */
    
    public int[] busqueda2(String[][] sudoku, int[] matrizVetados) {

        int vacios = 0;
        int Columna = 3; //-- Posición Columna
        int Fila = 3; //-- Posición Fila
        int[] M = new int[3]; //--Vector que lleva el mayor número de números, y la posicion del número
        M[0] = 0;
        int posicionX = 0; //--Última columna de M

        int i = 0;

        for (int k = 0; k < 36; k++) //--36 es el número de ciclos que debe hacer, por cada 3x3 se hacen 4 iteraciones
        {
            if (i < Fila) {
                for (int j = Columna - 3; j < Columna; j++) {
                    if (this.posicionM3x3(i, j) != matrizVetados[this.posicionM3x3(i, j)]) {
                        if (" ".equals(sudoku[i][j])) {
                            vacios++;
                        }
                        posicionX = j;
                    }
                }

                i++;
            } else {
                //-- Si la cantidad de números de la matriz 3x3 es mayor a la anterior entonces esta será la nueva matriz de busqueda

                if (vacios > M[0]) {
                    M[0] = vacios;
                    M[1] = i - 1;
                    M[2] = posicionX;
                }

                vacios = 0;
                Columna += 3;

                if (Columna == 12) {
                    Columna = 3;
                    Fila += 3;
                }

                i = Fila - 3;

            }
        }

        return M;
    }


    /*
    * Reconstruir la matrix 3x3 (A,B,C,D,E,...) a partir de dos números finales de la matriz 3x3
    * Ejemplo:
    *   De la matriz A tendríamos los números [2,2] que son las posiciones finales de la matriz A
    *
    * @param
    * @return
    */
    
    public String[][] matriz3x3(String[][] sudoku, int a, int b) {
        String[][] sudoku3x3 = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sudoku3x3[i][j] = sudoku[a - 2 + i][b - 2 + j];
            }
        }

        return sudoku3x3;
    }

    /*
    * Encuentra un número único para poner
    *
    */
    
    
    public String[][] poner(String[][] M9x9, String[][] M3x3, int[] XY) {
        String[] poner = this.evaluarNumero(M9x9, M3x3, XY);
        if ("1".equals(poner[0])) {
            M9x9[Integer.parseInt(poner[2])][Integer.parseInt(poner[3])] = poner[1];
        }

        return M9x9;
    }

    public String[][] poner2(String[][] M9x9, String[][] M3x3, int[] XY) {
        String[] poner = this.evaluarNumero2(M9x9, M3x3, XY);
        if ("1".equals(poner[0])) {
            M9x9[Integer.parseInt(poner[2])][Integer.parseInt(poner[3])] = poner[1];
        }

        return M9x9;
    }

    /*
        Retorna el número que se pondrá en el sudoku y su respectiva posición
    
        @param String[][] , String[][] , int[]
        @return String 
    */
    
    public String[] evaluarNumero(String[][] sudoku, String[][] M3x3, int[] XY) {
        String[] posible = new String[4]; // Posible en la posición [0] es el estado, [1] Posible número, [2] posición X , [3] posición Y.        
        int[] vectorOpcionesNumero = new int[2];

        for (int numero = 1; numero < 10; numero++) {
            if (this.evaluarNumero3x3(M3x3, Integer.toString(numero))) {
                vectorOpcionesNumero = this.evaluarNumeroFC(sudoku, XY[1] - 2, XY[2] - 2, Integer.toString(numero), M3x3);
                if (vectorOpcionesNumero[0] == 1) {
                    posible[0] = "1";
                    posible[1] = Integer.toString(numero);
                    posible[2] = Integer.toString(vectorOpcionesNumero[1]);
                    posible[3] = Integer.toString(vectorOpcionesNumero[2]);

                    break;

                } else {
                    posible[0] = "0";
                    //System.out.println("Entrando a falso evaluación FC " + numero);
                }

            } else {
                posible[0] = "0";
                //System.out.println("Entrando a falso evaluación 3x3 " + numero);
            }

        }

        return posible;
    }

    public String[] evaluarNumero2(String[][] sudoku, String[][] M3x3, int[] XY) {
        String[] posible = new String[4]; // Posible en la posición [0] es el estado, [1] Posible número, [2] posición X , [3] posición Y.        
        int[] vectorOpcionesNumero = new int[2];

        for (int numero = 1; numero < 10; numero++) {
            if (this.evaluarNumero3x3(M3x3, Integer.toString(numero))) {
                vectorOpcionesNumero = this.evaluarNumeroFC2(sudoku, XY[1] - 2, XY[2] - 2, Integer.toString(numero), M3x3);
                if (vectorOpcionesNumero[0] == 1) {
                    posible[0] = "1";
                    posible[1] = Integer.toString(numero);
                    posible[2] = Integer.toString(vectorOpcionesNumero[1]);
                    posible[3] = Integer.toString(vectorOpcionesNumero[2]);

                    break;

                } else {
                    posible[0] = "0";
                    //System.out.println("Entrando a falso evaluación FC " + numero);
                }

            } else {
                posible[0] = "0";
                //System.out.println("Entrando a falso evaluación 3x3 " + numero);
            }

        }

        return posible;
    }


    /*
    *   Válida que el número que se le entrega no exista en la matriz 3x3, si lo encuentra retornará false
    *
    * @param String[][] , String
    * @return Boolean
     */
    public boolean evaluarNumero3x3(String[][] M3x3, String numero) {
        boolean respuesta = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (M3x3[i][j].equals(numero)) {
                    respuesta = false;
                }
            }
        }

        return respuesta;
    }

    /*
    * Recorre la fila y la columna buscando el número entregado
    *
    *
    * @param String[][] , int , int , String
    * @return
     */
    public int[] evaluarNumeroFC(String[][] sudoku, int a, int b, String numero, String[][] M3x3) {
        int opciones = 0;
        int[] vectorOpcionesNumero = new int[3];
        vectorOpcionesNumero[0] = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (" ".equals(M3x3[i][j])) {
                    for (int k = 0; k < 9; k++) {

                        // Busca el número en toda la fila X y Columna Y
                        if (sudoku[k][b + j].equals(numero) || sudoku[a + i][k].equals(numero)) {
                            vectorOpcionesNumero[0] = 0;
                        }

                    }

                    if (vectorOpcionesNumero[0] == 1) {
                        opciones++;
                        vectorOpcionesNumero[1] = a + i;
                        vectorOpcionesNumero[2] = b + j;
                    }

                    vectorOpcionesNumero[0] = 1;
                }
            }
        }

        if (opciones == 1) {
            vectorOpcionesNumero[0] = 1;
        } else {

            vectorOpcionesNumero[0] = 0;
        }

        return vectorOpcionesNumero;
    }

    public int[] evaluarNumeroFC2(String[][] sudoku, int a, int b, String numero, String[][] M3x3) {
        int opciones = 0;
        int[] vectorOpcionesNumero = new int[3];
        vectorOpcionesNumero[0] = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (" ".equals(M3x3[i][j])) {
                    for (int k = 0; k < 9; k++) {

                        // Busca el número en toda la fila X y Columna Y
                        if (sudoku[k][b + j].equals(numero) || sudoku[a + i][k].equals(numero)) {
                            vectorOpcionesNumero[0] = 0;
                        }

                    }

                    if (vectorOpcionesNumero[0] == 1) {
                        opciones++;
                        vectorOpcionesNumero[1] = a + i;
                        vectorOpcionesNumero[2] = b + j;
                    }

                    vectorOpcionesNumero[0] = 1;
                }
            }
        }

        if (opciones <= 2) {
            vectorOpcionesNumero[0] = 1;
        } else {

            vectorOpcionesNumero[0] = 0;
        }

        return vectorOpcionesNumero;
    }

    private boolean assertArrayEquals(String[][] sudokuRespuesta, String[][] sudokuCopia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
