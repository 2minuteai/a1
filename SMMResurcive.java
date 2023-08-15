/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assisgnment;

/**
 *
 * @author njain
 * coz legends use intellij or netbeans and not vs code 
 */
public class SMMResurcive {
    
     public int[][] smmr(int[][] A, int[][] B, int rowA, int colA,
                                   int rowB, int colB, int n) {
        int[][] C = new int[n][n];
        if (n == 1) {
            C[0][0] = A[rowA][colA] * B[rowB][colB];
        } else {
            int size = (int) (n / 2.0);
            
             Utils.recurseAdd(C, smmr(A, B, rowA, colA, rowB, colB, size),
                smmr(A, B, rowA, colA + size, rowB + size, colB, size), 
                0, 0);

             Utils.recurseAdd(C, smmr(A, B, rowA, colA, rowB, colB + size, size),
                smmr(A, B, rowA, colA + size, rowB + size, colB + size, size),
                0, size);

             Utils.recurseAdd(C, smmr(A, B, rowA + size, colA, rowB, colB, size),
                smmr(A, B, rowA + size, colA + size, rowB + size, colB, size),
                size, 0);

            Utils.recurseAdd(C, smmr(A, B, rowA + size, colA, rowB, colB + size, size),
                smmr(A, B, rowA + size, colA + size, rowB + size, colB + size, size),
                size, size);
        }

        return C;
    }
}
