package org.example;
import java.util.Scanner;

public class Main {
    public static void votacao(){
        Scanner scanner = new Scanner(System.in);
        int idade = scanner.nextInt();
        if (idade < 16) {
            System.out.println("Nao pode votar\n");
            return;
        }
        if (idade < 18 ||  idade > 65) {
            System.out.println("Vote, se quiser\n");
            return;
        }
        System.out.println("Vote.\n");
    }

    public static void fibonnaci(){
        int a = 1;
        int b = 1;

        System.out.print(a + " ");
        for (int i = 0; i < 29; i++){
            System.out.print(b + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }


    public static void main(String[] args) {
        votacao();
        fibonnaci();
    }
}