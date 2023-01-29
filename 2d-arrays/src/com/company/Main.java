package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        homework9demo();
    }

    public static void homework9demo() {
        boolean res = dfs(new boolean[][] {
                {true, true, true, false, false},
                {false, true, false, false, false},
                {false, false, true, false, true},
                {true, false, false, true, false},
                {false, false, false, false, true}
        }, 0, 2);

        System.out.println(res);
    }

    public static boolean dfs(boolean[][] connections, int s, int e) {
        if (s == e) return true;

        for (int i=0; i<connections[s].length; i++) {
            if (connections[s][i] && i != s)
                if (dfs(connections, i, e)) return true;
        }

        return false;
    }

    public static void homework6demo() {
        final int N = 5;
        int[][] arr = homework6(N);
        for (int[] r : arr) {
            System.out.println(Arrays.toString(r));
        }
    }

    public static int[][] homework6(int N) {
        int arr[][] = new int[N][N];

        int z = 1;
        int top = 0, left = 0;
        int bottom = N-1, right = N-1;

        while (z <= N * N) {
            for (int i=left; i<=right; i++) {
                arr[top][i] = z++;
            }
            top++;

            for (int i=top; i<=bottom; i++) {
                arr[i][right] = z++;
            }
            right--;

            for (int i=right; i>=left; i--) {
                arr[bottom][i] = z++;
            }
            bottom--;

            for (int i=bottom; i>=top; i--) {
                arr[i][left] = z++;
            }
            left++;
        }
        return arr;
    }

    public static void homework4demo() {
        homework4(new int[][] {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        });
    }

    public static void homework4(int[][] A) {
        final int rows = A.length;
        final int cols = A[0].length;

        int[] rowSums = new int[rows];
        int[] colSums = new int[cols];
        int sum = 0;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                colSums[j] += A[i][j];
                rowSums[i] += A[i][j];
                sum += A[i][j];
            }
        }

        System.out.println("Sum of rows:");
        System.out.println(Arrays.toString(rowSums));

        System.out.println("Sum of cols:");
        System.out.println(Arrays.toString(colSums));

        System.out.println("Total sum:" + sum);
    }

    public static void homework3(String [][] A, String key) {
        for (int i=0; i<A.length; i++) {
            String[] row = A[i];
            for (int j=0; j<row.length; j++) {
                if (row[j].equals(key)) {
                    System.out.printf("found key at row: %d, col: %d \n", i, j);
                }
            }
        }
    }

    public static void homework2() {
        int[][] A = new int[6][5];
        A[0][3] = 4;
        A[0][2] = -19;
        A[5][3] = 22;
    }

    public static void createDiagonal2DArray(int N) {
        int[][] A = new int[N][N];

        int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
        int k = 1;
        while (k <= N*N) {
            int r = startRow, c = startCol;
            while (c >= endCol) {
                A [r][c] = k++;
                r++;
                c--;
            }

            if (startCol <= N - 2) {
                startRow = 0;
                endRow++;
                startCol++;
                endCol = 0;
            } else {
                startRow++;
                endRow = N - 1;
                startCol = N - 1;
                endCol++;
            }
        }

        for (int[] r : A) {
            System.out.println(Arrays.toString(r));
        }

    }
}
