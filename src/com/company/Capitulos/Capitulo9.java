package com.company.Capitulos;

import com.company.Usuario;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Capitulo9 {
    List<Usuario> _usuarios, _usuarios2;
    public Capitulo9() {
        _usuarios = Usuario.criarListaExemploUsuarios();
        _usuarios2 = Usuario.criarListaExemploUsuarios2();
        System.out.println(" \n\nCapitulo 9");
        Sessao1();
        Sessao2();
        Sessao3();
    }

    private void Sessao1(){
        System.out.println("\n9.1 Coletores gerando mapas\n");
        Map<String, Usuario> nameToUser = _usuarios
                .stream()
                .collect(Collectors.toMap(
                        Usuario::getNome,
                        Function.identity()));

        nameToUser.forEach((q, c) -> System.out.println("String: " + q + ", Valor: " + c));
    }

    private void Sessao2(){
        System.out.println("\n9.2 groupingBy e partitioningBy\n");

        System.out.print("Agrupamento por pontos: \n");
        Map<Integer, List<Usuario>> pontuacao = _usuarios2
                .stream()
                .collect(Collectors.groupingBy(Usuario::getPontos));
        System.out.print(pontuacao);

        System.out.print("\nLista de moderadores e não moderadores: \n");
        Map<Boolean, List<Usuario>> moderadores = _usuarios2
                .stream()
                .collect(Collectors.partitioningBy(Usuario::isModerador));
        System.out.println(moderadores);

        System.out.print("\nSoma de pontos por tipo: \n");
        Map<Boolean, Integer> pontuacaoPorTipo = _usuarios2
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                Usuario::isModerador,
                                Collectors.summingInt(Usuario::getPontos)));
        System.out.println(pontuacaoPorTipo);

        System.out.print("\nJoinando Pontos :p \n");
        String nomes = _usuarios2
                .stream()
                .map(Usuario::getNome)
                .collect(Collectors.joining(", "));
        System.out.println(nomes);
    }

    private void Sessao3(){
        System.out.println("\n9.3 Executando o pipeline em paralelo\n");
        List<Usuario> filtradosOrdenados = _usuarios.parallelStream()
                .filter(u -> u.getPontos() > 6)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());

        filtradosOrdenados.forEach(System.out::println);
    }

}
