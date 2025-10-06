package com.mycompany.mavenproject1;

class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }

    public double somar(double a, double b) {
        return a + b;
    }

    public int somar(int a, int b, int c) {
        return a + b + c;
    }
    
     public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        int resultado1 = calc.somar(5, 3);
        double resultado2 = calc.somar(2.5, 4.3);
        int resultado3 = calc.somar(1, 2, 3);

        System.out.println("Soma de dois inteiros: " + resultado1);
        System.out.println("Soma de dois doubles: " + resultado2);
        System.out.println("Soma de três inteiros: " + resultado3);
    }
}
