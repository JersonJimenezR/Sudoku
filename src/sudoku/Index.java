
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
            case 1:
                
                System.out.println("Seleccionaste sudoku Fácil \n");
                this.printSudoku(easy.initEasy());
                System.out.println();
                System.out.println("¿Resolver S/N ?");
                this.decision(sc.next());
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
    
    
    public void decision(String s)
    {
        if("N".equals(s))
        {            
            System.out.println("Hasta pronto");            
            
        }else
        {
            //--Resolver soduko
            
            //this.solve();
        }
    }
    

}
