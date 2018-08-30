/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author JersonJr
 */

public class SudokuHard 
{
    //--Mostrar sudoku fácil
    
    public String[][] initEasy()
    {
        String[][] sudokuHard = new String[9][9];
        
        //--A
        
        sudokuHard[0][0] = " ";
        sudokuHard[0][1] = " ";
        sudokuHard[0][2] = " ";        
        sudokuHard[1][0] = " ";
        sudokuHard[1][1] = " ";
        sudokuHard[1][2] = " ";   
        sudokuHard[2][0] = "1";
        sudokuHard[2][1] = " ";
        sudokuHard[2][2] = "2";  
        
        //--B
        
        sudokuHard[0][3] = "7";
        sudokuHard[0][4] = " ";
        sudokuHard[0][5] = " ";
        sudokuHard[1][3] = " ";
        sudokuHard[1][4] = " ";
        sudokuHard[1][5] = " ";
        sudokuHard[2][3] = " ";
        sudokuHard[2][4] = " ";
        sudokuHard[2][5] = "6";
        
        //--C
        
        sudokuHard[0][6] = " ";
        sudokuHard[0][7] = " ";
        sudokuHard[0][8] = " ";
        sudokuHard[1][6] = "5";
        sudokuHard[1][7] = "2";
        sudokuHard[1][8] = "1";
        sudokuHard[2][6] = " ";
        sudokuHard[2][7] = " ";
        sudokuHard[2][8] = "7";
        
        
        //--D
        
        sudokuHard[3][0] = " ";
        sudokuHard[3][1] = " ";
        sudokuHard[3][2] = " ";        
        sudokuHard[4][0] = "3";
        sudokuHard[4][1] = "2";
        sudokuHard[4][2] = " "; 
        sudokuHard[5][0] = " ";
        sudokuHard[5][1] = " ";
        sudokuHard[5][2] = " ";  
        
        //--E
        
        sudokuHard[3][3] = " ";
        sudokuHard[3][4] = "4";
        sudokuHard[3][5] = " ";
        sudokuHard[4][3] = " ";
        sudokuHard[4][4] = " ";
        sudokuHard[4][5] = " ";
        sudokuHard[5][3] = " ";
        sudokuHard[5][4] = " ";
        sudokuHard[5][5] = " ";
        
        //--F
        
        sudokuHard[3][6] = " ";
        sudokuHard[3][7] = " ";        
        sudokuHard[3][8] = " ";                
        sudokuHard[4][6] = "8";
        sudokuHard[4][7] = "9";
        sudokuHard[4][8] = " ";
        sudokuHard[5][6] = " ";
        sudokuHard[5][7] = " ";
        sudokuHard[5][8] = "2";
        
        //--G
        
        sudokuHard[6][0] = " ";
        sudokuHard[6][1] = "3";
        sudokuHard[6][2] = " ";        
        sudokuHard[7][0] = "5";
        sudokuHard[7][1] = " ";
        sudokuHard[7][2] = "1";  
        sudokuHard[8][0] = " ";
        sudokuHard[8][1] = " ";
        sudokuHard[8][2] = "6";
        
        //--H
        
        sudokuHard[6][3] = "8";
        sudokuHard[6][4] = " ";
        sudokuHard[6][5] = "1";
        sudokuHard[7][3] = " ";
        sudokuHard[7][4] = " ";
        sudokuHard[7][5] = " ";
        sudokuHard[8][3] = " ";
        sudokuHard[8][4] = "5";
        sudokuHard[8][5] = " ";
        
        //--I
        
        sudokuHard[6][6] = " ";
        sudokuHard[6][7] = "7";
        sudokuHard[6][8] = " ";
        sudokuHard[7][6] = " ";
        sudokuHard[7][7] = " ";
        sudokuHard[7][8] = " ";
        sudokuHard[8][6] = "4";
        sudokuHard[8][7] = " ";
        sudokuHard[8][8] = "3";
        
        return sudokuHard;
    }   
}
