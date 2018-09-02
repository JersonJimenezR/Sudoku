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


public class SudokuEasy {
 
    //--Mostrar sudoku fácil
    
    public String[][] initEasy()
    {
        String[][] sudokuEasy = new String[9][9];
        
        //--A
        
        sudokuEasy[0][0] = " ";
        sudokuEasy[0][1] = " ";
        sudokuEasy[0][2] = "3";        
        sudokuEasy[1][0] = " ";
        sudokuEasy[1][1] = "4";
        sudokuEasy[1][2] = " ";   
        sudokuEasy[2][0] = " ";
        sudokuEasy[2][1] = "7";
        sudokuEasy[2][2] = " ";  
        
        //--B
        
        sudokuEasy[0][3] = "8";
        sudokuEasy[0][4] = " ";
        sudokuEasy[0][5] = " ";
        sudokuEasy[1][3] = "5";
        sudokuEasy[1][4] = "6";
        sudokuEasy[1][5] = "1";
        sudokuEasy[2][3] = " ";
        sudokuEasy[2][4] = "2";
        sudokuEasy[2][5] = " ";
        
        //--C
        
        sudokuEasy[0][6] = " ";
        sudokuEasy[0][7] = "9";
        sudokuEasy[0][8] = " ";
        sudokuEasy[1][6] = "3";
        sudokuEasy[1][7] = "7";
        sudokuEasy[1][8] = " ";
        sudokuEasy[2][6] = " ";
        sudokuEasy[2][7] = " ";
        sudokuEasy[2][8] = " ";
        
        
        //--D
        
        sudokuEasy[3][0] = " ";
        sudokuEasy[3][1] = "6";
        sudokuEasy[3][2] = " ";        
        sudokuEasy[4][0] = "9";
        sudokuEasy[4][1] = " ";
        sudokuEasy[4][2] = " "; 
        sudokuEasy[5][0] = " ";
        sudokuEasy[5][1] = "1";
        sudokuEasy[5][2] = "2";  
        
        //--E
        
        sudokuEasy[3][3] = " ";
        sudokuEasy[3][4] = "5";
        sudokuEasy[3][5] = "4";
        sudokuEasy[4][3] = "2";
        sudokuEasy[4][4] = " ";
        sudokuEasy[4][5] = " ";
        sudokuEasy[5][3] = " ";
        sudokuEasy[5][4] = " ";
        sudokuEasy[5][5] = " ";
        
        //--F
        
        sudokuEasy[3][6] = " ";
        sudokuEasy[3][7] = " ";        
        sudokuEasy[3][8] = " ";                
        sudokuEasy[4][6] = " ";
        sudokuEasy[4][7] = " ";
        sudokuEasy[4][8] = "6";
        sudokuEasy[5][6] = " ";
        sudokuEasy[5][7] = "5";
        sudokuEasy[5][8] = "8";
        
        //--G
        
        sudokuEasy[6][0] = "1";
        sudokuEasy[6][1] = "2";
        sudokuEasy[6][2] = " ";        
        sudokuEasy[7][0] = "3";
        sudokuEasy[7][1] = "9";
        sudokuEasy[7][2] = "6";  
        sudokuEasy[8][0] = " ";
        sudokuEasy[8][1] = " ";
        sudokuEasy[8][2] = " ";
        
        //--H
        
        sudokuEasy[6][3] = "3";
        sudokuEasy[6][4] = "9";
        sudokuEasy[6][5] = " ";
        sudokuEasy[7][3] = "7";
        sudokuEasy[7][4] = " ";
        sudokuEasy[7][5] = " ";
        sudokuEasy[8][3] = " ";
        sudokuEasy[8][4] = "1";
        sudokuEasy[8][5] = "6";
        
        //--I
        
        sudokuEasy[6][6] = "8";
        sudokuEasy[6][7] = " ";
        sudokuEasy[6][8] = "7";
        sudokuEasy[7][6] = "5";
        sudokuEasy[7][7] = " ";
        sudokuEasy[7][8] = " ";
        sudokuEasy[8][6] = " ";
        sudokuEasy[8][7] = " ";
        sudokuEasy[8][8] = " ";
        
        return sudokuEasy;
    }
}
