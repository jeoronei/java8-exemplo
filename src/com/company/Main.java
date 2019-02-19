package com.company;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Capitulo1();
        Capitulo2();
        Capitulo3();
        Capitulo4();
    }

    // Capitulo 2
    private static void Capitulo1(){
        System.out.println("¿ Capitulo 1 ?");
    }

    // Capitulo 2
    private static void Capitulo2(){
        System.out.println("\n\nCapitulo 2 \n");

        List<Usuario> lista = Usuario.criarListaExemploUsuarios();

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

    // Capitulo 3
    private static void Capitulo3(){
        System.out.println(" \n\nCapitulo 3 \n");
        Validador<String> validarCEP = new Validador<String>() {
            @Override
            public boolean validar(String s) {
                return s.matches("[0-9]{5}-[0-9]{3}");
            }
        };

        System.out.println("resultado 1: " + validarCEP.validar("04101-300"));

        Validador<String> validarLambdaCep = cep -> cep.matches("[0-9]{5}-[0-9]{3}");

        System.out.println("resultado 2: " + validarLambdaCep.validar("04101-300B"));
    }

    // Capitulo 4
    private static void Capitulo4(){
        System.out.println(" \n\nCapitulo 4 \n");

        List<Usuario> lista = Usuario.criarListaExemploUsuarios();
        List<Usuario> listaLambda = Usuario.criarListaExemploUsuarios();
        Predicate<Usuario> predicate = new Predicate<Usuario>() {
            @Override
            public boolean test(Usuario usuario) {
                return usuario.getPontos() > 7;
            }
        };
        Predicate<Usuario> predicateLambda = p -> p.getPontos() > 6;

        lista.forEach(u -> System.out.println("Lista Completa: " + u.getNome()));
        lista.removeIf(predicate);
        lista.forEach(t -> System.out.println("Sem Lambda: " + t.getNome()));

        System.out.println("");

        listaLambda.forEach(v -> System.out.println("Lista Completa: " + v.getNome()));
        listaLambda.removeIf(predicateLambda);
        listaLambda.forEach(x -> System.out.println("Lambda: " + x.getNome()));

    }

}
