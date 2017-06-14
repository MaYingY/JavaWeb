package com.company;

import java.util.Scanner;

public class Main {
    static long[] length = new long[100];//带权长度
    static long[][] distance = new long[100][100];//邻接矩阵
    static int count = 0;//节点的个数
     static int tag[] = new int[100];//判断是否找到最短路径
    static long min = 0x3f3f3f3f;
   static boolean p[][] = new boolean[100][100];//节点是否被访问
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //给邻接矩阵赋值
        for(int i = 0; i < distance.length; i ++) {
            for(int j = 0; j < distance.length; j ++) {
                distance[i][j] = min;
            }

        }

        while(scanner.hasNext()) {
            int choice = scanner.nextInt();
            if(choice == 1) {
                System.out.println("请输入要查询的节点：");
                int node = scanner.nextInt();
                System.out.println("到"+node+"节点的最短路径是："+length[node]);
            } else if(choice == 2){
                System.out.println("请输入所需添加的关联边数：");
                int num = scanner.nextInt();
                System.out.println("请输入新节点：");
                int newnode = scanner.nextInt();
                count ++;;
                System.out.println("请输入关联节点以及权值:");
                while (num -- > 0){
                    int oldnode = scanner.nextInt();
                    int w = scanner.nextInt();
                    distance[oldnode][newnode] = w;
                    ShortestPath();
                }
            }
        }
    }
    public static void ShortestPath(){
        int v;
        for( v = 0; v < count; v ++){
            tag[v] = 0;
            length[v] = distance[0][v];
            for(int j = 0; j < count ; j ++){
                p[v][j] = false;
            }
         }
        for(int i = 1; i < count; i ++){
           for(int j = 0;j < count;j ++){
                  if(tag[j] == 0){
                      if(length[j] < min){
                          v = j;
                          min = length[j];
                      }
                  }
           }
           tag[v] = 1;
            for(int j = 0; j < count; j ++){
                if(tag[j] == 0 && (min + distance[v][j] < length [j])){
                    length[j] = min + distance[v][j];
                }
            }
        }
    }
}
