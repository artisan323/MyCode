package com.artisan.sparsearray;

//稀疏数组与基本数组的相互转化
public class SparseArray {
    public static void main(String[] args) {

        //创建基本数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 7;
        for (int[] row : chessArr1){
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转换为稀疏数组
        int sum = 0;
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 1;
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (chessArr1[i][j] != 0){
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }

        System.out.println("=====================================");
        //输出稀疏数组
        for (int[] row : sparseArray){
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //稀疏数组转为普通数组
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++){
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //输出普通数组
        System.out.println("=================================");
        for (int[] row : chessArray2){
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}