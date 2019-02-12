package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Capitulo1();
        Capitulo2();
    }

    // Capitulo 2
    public static void Capitulo1(){
        System.out.println("¿ Capitulo 1 ? \n\n");
    }

    // Capitulo 2
    public static void Capitulo2(){
        System.out.println("Capitulo 2 \n");

        Usuario usuario1 = new Usuario("Jeoronei", 10);
        Usuario usuario2 = new Usuario("Pedro", 5);
        Usuario usuario3 = new Usuario("Thiago", 7);

        List<Usuario> lista = Arrays.asList(usuario1, usuario2, usuario3);

        // Antiga forma
        for (Usuario usuario : lista) {
            System.out.println("Exemplo 1: " + usuario.getNome());
        }

        System.out.println("");

        // Com Consumer
        lista.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println("Exemplo 2: " + usuario.getNome());
            }
        });

        System.out.println("");

        // Com Lambda
        lista.forEach( u -> System.out.println("Exemplo 3: " + u.getNome()));
    }
}
