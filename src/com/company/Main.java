package com.company;

import com.company.Capitulos.Capitulo8;
import com.company.Capitulos.Capitulo9;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Main {

    public static void main(String[] args) {
        Capitulo1();
        Capitulo2();
        Capitulo3();
        Capitulo4();
        Capitulo5();
        Capitulo6();
        Capitulo7();
        new Capitulo8();
        new Capitulo9();
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

    // Capitulo 5
    private static void Capitulo5(){
        System.out.println(" \n\nCapitulo 5 \n");

        List<Usuario> usuarios = Usuario.criarListaExemploUsuarios();
        List<Usuario> usuarios1 = Usuario.criarListaExemploUsuarios();
        List<Usuario> usuarios2 = Usuario.criarListaExemploUsuarios();
        List<Usuario> usuarios3 = Usuario.criarListaExemploUsuarios();

        System.out.println("Lista: ");
        usuarios.forEach(q -> System.out.println(q.getNome()));

        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare(Usuario user1, Usuario user2) {
                return user1.getNome().compareTo(user2.getNome());
            }
        };

        // Ordena a lista
        System.out.println("\nExemplo 1: ");
        Collections.sort(usuarios, comparator);
        usuarios.forEach(q -> System.out.println(q.getNome()));

        System.out.println("\nExemplo 2: ");
        usuarios1.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));
        usuarios1.forEach(q -> System.out.println(q.getNome()));

        System.out.println("\nExemplo 3: ");
        usuarios2.sort(comparing(u1 -> u1.getNome()));
        usuarios2.forEach(q -> System.out.println(q.getNome()));

        System.out.println("\nSort por pontos: ");
        usuarios3.sort(comparingInt(u1 -> u1.getPontos()));
        usuarios3.forEach(q -> System.out.println(q.getNome()));
    }

    // Capitulo 6
    public static void Capitulo6() {
        System.out.println(" \n\nCapitulo 6 \n");

        List<Usuario> u1 = Usuario.criarListaExemploUsuarios();
        List<Usuario> u2 = Usuario.criarListaExemploUsuarios();
        System.out.println("Lista Usuario: ");
        u1.forEach(System.out::println);

        //Torna moderador
        u1.forEach(Usuario::tornaModerador);
        System.out.println("\nLista com tomadores: ");
        u1.forEach(System.out::println);

        u2.sort(comparingInt(Usuario::getPontos).reversed());
        System.out.println("\nOrdenado por pontos: ");
        u2.forEach(System.out::println);

        BiFunction<Integer, Integer, Integer> max = Math::max;
        ToIntBiFunction<Integer, Integer> max2 = Math::max;
        IntBinaryOperator max3 = Math::max;

        System.out.println("\nMaior 1: " + max.apply(5, 6));
        System.out.println("Maior 2: " + max2.applyAsInt(10, 4));
        System.out.println("Maior 3: " + max3.applyAsInt(52, 61));
    }

    // Capitulo 7
    public static void Capitulo7(){
        System.out.println(" \n\nCapitulo 7 \n");
        List<Usuario> u1 = Usuario.criarListaExemploUsuarios();
        List<Usuario> u1Filtrado = new ArrayList<>();

        System.out.println("Lista Original:");
        u1.forEach(System.out::println);

        //Tornar moderador
        System.out.println("\nLista alterada:");
        u1.stream().filter(q -> q.getPontos() > 6).forEach(u -> u.tornaModerador());
        u1.forEach(System.out::println);

        //Filtrar lista
        System.out.println("\nLista filtrada:");
        u1.stream().filter(q -> q.getPontos() > 6).forEach(u1Filtrado::add);
        u1Filtrado.forEach(System.out::println);

        //Filtrar lista com collect
        System.out.println("\nLista filtrada com collect:");
        List<Usuario> u1Filtrado2 = u1.stream().filter(q -> q.getPontos() > 7).collect(Collectors.toList());
        u1Filtrado2.forEach(System.out::println);

        //Filtrar de pontos
        System.out.println("\nLista de pontos:");
        List<Integer> listaPontos = u1.stream().map(Usuario::getPontos).collect(Collectors.toList());
        listaPontos.forEach(System.out::println);

        System.out.println("\nUsuario com mais pontos:");
        Optional<String> maxNome = u1.stream().max(Comparator.comparingInt(Usuario::getPontos)).map(u -> u.getNome());
        System.out.println(maxNome);

    }


}
