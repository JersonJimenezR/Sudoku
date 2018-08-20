
package sudoku;
import java.util.Scanner;

/**
 *
 * @author JersonJr && JHM
 */


public class Index {
    
    
    //--Instancia
    
    Scanner sc = new Scanner(System.in);
    SudokuEasy easy = new SudokuEasy();
    
    
    //-- Menú inicial
    
    public void Menu()
    {                    
        System.out.println("--------Sudoku-------");
        
        System.out.println("1 - Sudoku Fácil");
        System.out.println("2 - Sudoku Intermedio");
        System.out.println("3 - Sudoku Difícil");
        
        this.options(sc.nextInt());             
    }
    
    
    //--Opción seleccionada por el usuario
    
    public void options(int option)
    {
        switch (option) 
        {
            case 1: //--Sudoku Fácil
                
                System.out.println("Seleccionaste sudoku Fácil \n");
                this.printSudoku(easy.initEasy());
                System.out.println();
                System.out.println("¿Resolver S/N ?");
                this.decision(sc.next() , easy.initEasy());
                break;
                
                
            default:
                throw new AssertionError();
        }
    }
    
    //--Pintar sudoku 
    
    public void printSudoku(String[][] sudoku)
    {
        for (int i = 0; i < 9; i++) {
            
            if( i == 0 || i == 3 || i == 6)
            {
                System.out.println("-------------------");
            }
            
            System.out.println("|"+sudoku[i][0]+" "+sudoku[i][1]+" "+sudoku[i][2]+"|"+sudoku[i][3]+" "+sudoku[i][4]+" "+sudoku[i][5]+"|"+sudoku[i][6]+" "+sudoku[i][7]+" "+sudoku[i][8]+"|");
        }
        
        System.out.println("-------------------");
                 
    }
    
    
    public void decision(String s , String[][] sudoku)
    {
        if("N".equals(s))
        {            
            System.out.println("Hasta pronto");            
            
        }else
        {
            //--Resolver soduko
            
            System.out.println(this.solve(sudoku));
        }
    }
    
    
    public String solve(String[][] sudoku)
    {
        //-- Busqueda de matriz 3x3 con menos espacios vacíos 
        
        int[] XY = this.busqueda(sudoku);
        String[][] M3x3 = new String[3][3];
        M3x3 = this.matriz3x3(sudoku, XY[1] , XY[2]);
        return this.poner(sudoku , M3x3 , XY);

    }
    
    public int[] busqueda(String[][] sudoku)
    {        
        int numeros = 0;        
        int C = 3; //-- Posición Columna
        int F = 3; //-- Posición Fila
        int[] M = new int[3]; //--Matriz que lleva el mayor número de números
        int K = 0; //--Última columna de M
        
        for (int i = 0; i < 9; i++) 
        {     
            if(i%F != 0)
            {
                for (int j = C-3; j >= 0; j++) 
                {
                    if(j%C != 0)
                    {  
                        if(sudoku[i][j] != " ")
                        {
                            numeros++;
                        }

                    }else
                    {
                        K = j-1;
                        break;
                    }                      
                }
                
            }else
            {
                //-- Si la cantidad de números de la matriz 3x3 es mayor a la anterior entonces esta será la nueva matriz de busqueda
                
                if(numeros > M[0])
                {
                    M[0] = numeros;
                    M[1] = i;
                    M[2] = K;
                }
                
                C +=3;
                
                if(C > 9)
                {
                    C = 0;
                    i += 3;
                }                
            }            
        }
                
        return M;
    }
    
    
    public String[][] matriz3x3(String[][] sudoku , int a , int b)
    {
        String[][] sudoku3x3 = new String[3][3];
        
        for (int i = a-2; i <= a; i++) 
        {
            for (int j = b-2; j <= b; j++) 
            {
                sudoku3x3[i][j] = sudoku[i][j];
            }
        }
        
        return sudoku3x3;
    }
    
    
    public String poner(String[][] sudoku , String[][] M3x3 , int[] XY)
    {
        String poner = this.evaluarNumero(sudoku, M3x3, XY);
        
        return poner;
    }
    
    
    public String evaluarNumero(String[][] sudoku , String[][] M3x3 , int[] XY)
    {
        int numero = 1; //--Número a evaluar en el sudoku
        int opciones = 0; //--Número de posibilidades que tiene un número evaluado
        int[] vetados = new int[9]; //--Vector de números que no pueden estar en la matriz 3x3
        String poner = " "; //--Número a poner en la matriz        
        boolean V = false; //--Control de condicional vetados
        
        int i = 0; 
        while(i < 3)
        {       
            for (int j = 0; j < 3; j++) 
            {                
                if(" ".equals(M3x3[i][j]))
                {
                    if(this.evaluarNumero3x3(M3x3, Integer.toString(numero)))
                    {
                        if(this.evaluarNumeroFC(sudoku , XY[0] - 2-i , XY[1] - 2-j , Integer.toString(numero)))
                        {
                            poner = Integer.toString(numero);                        
                            opciones++;

                            if(opciones > 1)
                            {
                                vetados[numero-1] = numero;
                                numero++;
                                poner = " ";
                                opciones = 0;
                                V = true;                                                        
                            }
                        }                        
                    }                    
                }
            }
            
            if(V)
            {
                i=0;
                V = false;
            }else
            {
                i++;
            }            
        }
        
        return poner;
    }
    
    
    public boolean evaluarNumero3x3(String[][] M3x3 , String numero)
    {
        boolean respuesta = false;
        
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if(M3x3[i][j] != numero)
                {
                    respuesta = true;
                }
            }
        }
        
        return respuesta;
    }
    
        
    public boolean evaluarNumeroFC(String[][] sudoku , int a , int b , String numero)
    {
        boolean respuesta = false;
        
        for (int i = 0; i < 9; i++) 
        {
            if(sudoku[a][i] != numero)
                respuesta = true;
        } 
        
        for (int i = 0; i < 3; i++) 
        {
            if(sudoku[i][b] == numero)
                respuesta = false;
        }
        
        return respuesta;
    }

}
