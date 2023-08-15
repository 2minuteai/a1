/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assisgnment;

import java.util.Arrays;

/**
 *
 * @author njain coz legends use intellij or netbea
 * ns and not vs code
 */
public class CallAlgo2forPeople {

    public int[][] stressin(int[][] A, int[][] B) {
        int n = A.length;
        int m = B.length;
//        System.out.println("N is " + n);
//        System.out.println("M is " + m);

        if (n != m) {
            System.out.println("Yo not equal");
        }
        int[][] C = new int[n][n];

        if (n <= 64) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        } else {
            int size = n / 2;

            int[][] A11 = new int[size][size];
            int[][] A12 = new int[size][size];
            int[][] A21 = new int[size][size];
            int[][] A22 = new int[size][size];

            int[][] B11 = new int[size][size];
            int[][] B12 = new int[size][size];
            int[][] B21 = new int[size][size];
            int[][] B22 = new int[size][size];

            int[][] C1 = stressin(Utils.add(A11, A22), Utils.add(B11, B22));
            int[][] C2 = stressin(Utils.add(A21, A22), B11);
            int[][] C3 = stressin(A11, Utils.subtract(B12, B22));
            int[][] C4 = stressin(A22, Utils.subtract(B21, B11));
            int[][] C5 = stressin(Utils.add(A11, A12), B22);
            int[][] C6 = stressin(Utils.subtract(A21, A11), Utils.add(B11, B12));
            int[][] C7 = stressin(Utils.subtract(A12, A22), Utils.add(B21, B22));

            int[][] C00 = Utils.add(Utils.subtract(Utils.add(C1, C4), C5), C7);
            int[][] C01 = Utils.add(C3, C5);
            int[][] C10 = Utils.add(C2, C4);
            int[][] C11 = Utils.add(Utils.subtract(Utils.add(C1, C3), C2), C6);

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    C[i][j] = C00[i][j];
                    C[i][j + size] = C01[i][j];
                    C[i + size][j] = C10[i][j];
                    C[i + size][j + size] = C11[i][j];
                }
            }
        }

        return C;

    }

}
