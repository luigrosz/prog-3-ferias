package org.example;

import java.util.ArrayList;
import java.util.Iterator;

class Carro {
    String marca;
    String modelo;
    int ano;

    void exibirInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println();
    }
}

class Contador {
    static int totalObjetos = 0;

    Contador() {
        totalObjetos++;
    }

    static void mostrarTotal() {
        System.out.println("Total de objetos criados: " + totalObjetos);
    }
}

public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        carro1.marca = "Toyota";
        carro1.modelo = "Corolla";
        carro1.ano = 2020;

        Carro carro2 = new Carro();
        carro2.marca = "Honda";
        carro2.modelo = "Civic";
        carro2.ano = 2022;

        carro1.exibirInfo();
        carro2.exibirInfo();

        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();

        Contador.mostrarTotal();

        ArrayList<String> alunos = new ArrayList<>();

        alunos.add("Ana");
        alunos.add("Bruno");
        alunos.add("Carlos");
        alunos.add("Diana");
        alunos.add("Eduardo");

        System.out.println("Lista de alunos:");
        Iterator<String> it = alunos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        alunos.remove("Carlos");

        System.out.println("\nLista atualizada:");
        it = alunos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}