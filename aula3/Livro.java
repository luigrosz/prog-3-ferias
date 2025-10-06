package com.mycompany.mavenproject1;

class Livro {
    private String titulo;
    private String autor;

    public Livro() {
        this.titulo = "Título";
        this.autor = "Autor";
    }

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
    
    public static void main(String[] args) {
        Livro livro1 = new Livro();
        System.out.println("Livro 1: " + livro1.getTitulo() + " - " + livro1.getAutor());

        Livro livro2 = new Livro("1984", "George Orwell");
        System.out.println("Livro 2: " + livro2.getTitulo() + " - " + livro2.getAutor());
    }
}

