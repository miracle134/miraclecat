package com.mc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /**
         *  트리 규칙 : (2)1+(1)3+(0)5
         *  2씩 커지고 빈공간은 총 층수 - 현재층
         **/
        tree(sc.nextInt());

    }

    private static void tree(int floor) {
        int totalStar = floor * 2 - 1; // 마지막층 총 별
        int empty, star; // 왼쪽 빈공간 , 별 개수

        // 층 반복
        for (int i = 0; i < floor; i++) {
            empty = totalStar - (i + 1);
            star = i * 2 + 1;

            // 해당 층 왼쪽 빈공간 반복
            for (int j = 0; j < empty; j++) {
                System.out.print(" ");
            }

            // 해당 층 별 반복
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}