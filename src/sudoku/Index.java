
package sudoku;
import java.util.Arrays;
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
            case 1:
                
                System.out.println("Seleccionaste sudoku Fácil");
                this.printSudoku(easy.initEasy());
                break;
                
                
            default:
                throw new AssertionError();
        }
    }
    
    //--Pintar sudoku 
    
    public void printSudoku(int[][] sudoku)
    {
        for (int i = 0; i < 9; i++) 
        {            
            for (int j = 0; j < 9; j++) 
            {    
                if(i == 0 && j == 0 || i == 8 && j == 8)
                {
                    System.out.println("-------------");
                }
                
                System.out.println(sudoku[i][j]);
            }
            
            System.out.println();
        }
    }
    
    

}
