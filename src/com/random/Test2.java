package com.random;


import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class Test2 {
public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc > 0) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            if(a == 2 && b == 1) {
                System.out.println("1");
            } else if (a == b ) {
                System.out.println("0");
            } else if( a%2 ==0 && b%2 ==0) {
                System.out.println("1");
            } else if (a%2 == 1 && b%2 == 1) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
            tc--;
        }
    }
}
