package com.company.Capitulos;

import com.company.Usuario;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Capitulo8 {

    private List<Usuario> _usuarios;

    public Capitulo8() {
        _usuarios = Usuario.criarListaExemploUsuarios();
        System.out.println(" \n\nCapitulo 8");
        Sessao1();
        Sessao5();
        Sessao8();
    }

    private void Sessao1(){
        System.out.println("\n8.1 - Ordenando um Stream\n");
        List<Usuario> listaUsuarios = _usuarios.stream()
                .filter(q -> q.getPontos() > 5)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());
        listaUsuarios.forEach(System.out::println);
    }

    private void Sessao5(){
        System.out.println("\n8.5 Operações de redução\n");
        double media = _usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();
        System.out.println("Média: " + media);

        Usuario maximaPontuacao = _usuarios.stream()
                .max(Comparator.comparing(Usuario::getPontos)).get();

        System.out.println("\nUsuario com maior pontuação: "+ maximaPontuacao);

        int total = _usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .sum();

        System.out.println("\nSoma pontuação: " + total);

        int multiplicacao = _usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(1, (a,b) -> a * b);

        System.out.println("\nMultiplicação pontuação: " + multiplicacao);
    }

    private void Sessao8() {
        try{
            System.out.println("\n8.8 Praticando o que aprendemos com java.nio.file.Files\n");
            Files.list(Paths.get("./src/com/company")).forEach(System.out::println);

        }catch (Exception ex){

        }
    }
}
