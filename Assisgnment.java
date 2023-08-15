/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.assisgnment;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author njain coz legends use intellij or netbeans and not vs code
 */
public class Assisgnment {

    public static void main(String[] args) {
        Random r = new Random();
        int max = 1024;
        int start = 100;
        long[] normalTimes = new long[max];
        long[] recursiveTimes = new long[max];
        long[] strassenTimes = new long[max];
        int runs = 3;
        for (int run = 0; run < runs; run++) {
            for (int z = start; z < max;) {
                long normalTime = 0;
                long recursiveTime = 0;
                long strassenTime = 0;
                int random_array_A[][] = new int[z][z];
                int random_array_B[][] = new int[z][z];

                for (int i = 0; i < z; i++) {
                    for (int j = 0; j < z; j++) {
                        random_array_A[i][j] = r.nextInt(5);
                        random_array_B[i][j] = r.nextInt(5);
                        // System.out.print("Random array A " + random_array_A[i][j] + "\t\n");
                        // System.out.print("Random array B " + random_array_B[i][j] + "\t\n");
                    }
                    // System.out.print("\n");
                }

                System.out.println("Z is " + z);
//            System.out.println("Z1 is " + random_array_A.length);
//            System.out.println("Z2 is " + random_array_B.length);
                z += 10;
                int n = random_array_A[0].length;
                // System.out.println("length is " + n);
                int c[][] = new int[n][n];

                long startTime = System.currentTimeMillis();
                // square matrix multiplication
                algo_1(random_array_A, random_array_B, n, c);
                long endTime = System.currentTimeMillis();
                normalTime += (endTime - startTime);

//            int[][] result = calp.stressin(random_array_A, random_array_B);
//        System.out.println("Final is " + Arrays.deepToString(result));
                SMMResurcive asmmr = new SMMResurcive();
                startTime = System.currentTimeMillis();
                //resursive matrix multiplication
                int[][] result_r = asmmr.smmr(random_array_A, random_array_B, 0, 0, 0, 0, random_array_A.length);
                endTime = System.currentTimeMillis();
                recursiveTime += (endTime - startTime);
//                System.out.println("result 1 is " + Arrays.deepToString(result_r));

                CallAlgo2forPeople calp = new CallAlgo2forPeople();
                startTime = System.currentTimeMillis();
                //strassen matrix multiplication
                int[][] result = calp.stressin(random_array_A, random_array_B);
//                System.out.println("result calp is " + Arrays.deepToString(result));
                endTime = System.currentTimeMillis();
                strassenTime += (endTime - startTime);

                normalTimes[(z - start) / 10] = normalTime / runs;
                recursiveTimes[(z - start) / 10] = recursiveTime / runs;
                strassenTimes[(z - start) / 10] = strassenTime / runs;

//        System.out.println("Final is " + Arrays.deepToString(result_r));
//        int C[][] = algo_recursive_final(random_array_A, random_array_B);
//        System.out.println("Array " + Arrays.deepToString(C));
            }
        }
        String csvFileName = "running_times.csv";

        try (FileWriter writer = new FileWriter(csvFileName)) {
            writer.append("Dimension,Normal Time,Recursive Time,Strassen Time\n");

            for (int i = 0; i < normalTimes.length; i++) {
                writer.append(String.valueOf(i * 10 + 100));
                writer.append(",");
                writer.append(String.valueOf(normalTimes[i]));
                writer.append(",");
                writer.append(String.valueOf(recursiveTimes[i]));
                writer.append(",");
                writer.append(String.valueOf(strassenTimes[i]));
                writer.append("\n");
            }

            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }

    }

    private static void algo_1(int[][] random_array_A, int[][] random_array_B, int n, int c[][]) {

//        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] = c[i][j] + (random_array_A[i][k] * random_array_B[k][j]);
                }
            }
        }
//        long end = System.currentTimeMillis();
//        System.out.println("Elapsed Time in milli seconds: " + (end - start));
//        System.out.println(Arrays.deepToString(random_array_A));
//        System.out.println(Arrays.deepToString(random_array_B));
//        System.out.println(Arrays.deepToString(c));

//        calp.stressin();
//        int[][] A = {{1, 2}, {3, 4}};
//        int[][] B = {{5, 6}, {7, 8}};
//        int[][] result = calp.stressin(A, B);
////        System.out.println("Final is " + Arrays.deepToString(result));
//        SMMResurcive asmmr = new SMMResurcive();
//        
//        int[][] result_r = asmmr.smmr(A, B, 0, 0, 0, 0, A.length);
//        System.out.println("Final is " + Arrays.deepToString(result_r));
    }
}

//unused coz java plots suck 
//class PlotPanel extends JPanel {
//
//    private long[] normalTimes;
//    private long[] recursiveTimes;
//    private long[] strassenTimes;
//
//    public PlotPanel(long[] normalTimes, long[] recursiveTimes, long[] strassenTimes) {
//        this.normalTimes = normalTimes;
//        this.recursiveTimes = recursiveTimes;
//        this.strassenTimes = strassenTimes;
//        setPreferredSize(new Dimension(800, 600));
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//
//        int xAxisLength = getWidth() - 100;
//        int yAxisLength = getHeight() - 100;
//
//        // Draw x-axis
//        g2d.draw(new Line2D.Double(50, getHeight() - 50, getWidth() - 50, getHeight() - 50));
//
//        // Draw y-axis
//        g2d.draw(new Line2D.Double(50, getHeight() - 50, 50, 50));
//
//        // Draw data points for normalTimes, recursiveTimes, and strassenTimes
//        int numPoints = normalTimes.length;
//        int xStep = xAxisLength / numPoints;
//        int x = 50;
//        for (int i = 0; i < numPoints; i++) {
//            int yNormal = (int) (getHeight() - 50 - normalTimes[i]); // Invert y-axis
//            int yRecursive = (int) (getHeight() - 50 - recursiveTimes[i]);
//            int yStrassen = (int) (getHeight() - 50 - strassenTimes[i]);
//
//            g2d.setColor(Color.BLUE);
//            g2d.drawLine(x, yNormal, x, yNormal);
//
//            g2d.setColor(Color.RED);
//            g2d.drawLine(x, yRecursive, x, yRecursive);
//
//            g2d.setColor(Color.GREEN);
//            g2d.drawLine(x, yStrassen, x, yStrassen);
//
//            x += xStep;
//        }
//
//        // Draw labels and legends
//        g2d.drawString("Dimensions", getWidth() - 60, getHeight() - 40);
//        g2d.drawString("Running Time (ms)", 10, 40);
//        g2d.setColor(Color.BLUE);
//        g2d.drawString("Normal", 70, getHeight() - 30);
//        g2d.setColor(Color.RED);
//        g2d.drawString("Recursive", 70, getHeight() - 15);
//        g2d.setColor(Color.GREEN);
//        g2d.drawString("Strassen", 70, getHeight());
//
//        g2d.dispose();
//    }
//}
