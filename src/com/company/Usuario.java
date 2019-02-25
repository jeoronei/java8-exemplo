package com.company;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private int pontos;
    private boolean moderador;

    public Usuario(String nome, int pontos) {
        this.pontos = pontos;
        this.nome = nome;
        this.moderador = false;
    }
    public Usuario(String nome, int pontos, boolean moderador) {
        this.pontos = pontos;
        this.nome = nome;
        this.moderador = moderador;
    }
    public String getNome() {
        return nome;
    }
    public int getPontos() {
        return pontos;
    }
    public void tornaModerador() {
        this.moderador = true;
    }
    public boolean isModerador() {
        return moderador;
    }

    @Override
    public String toString() {
        return "Usuario: " + nome + ", Tomador: " + moderador;
    }

    public static List<Usuario> criarListaExemploUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Rodrigo", 3));
        lista.add(new Usuario("Jeoronei", 10));
        lista.add(new Usuario("Pedro", 5));
        lista.add(new Usuario("Thiago", 7));

        return lista;
    }

    public static List<Usuario> criarListaExemploUsuarios2(){
        ArrayList<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Rodrigo Turini", 120, true));
        lista.add(new Usuario("Guilherme Silveira", 90));
        lista.add(new Usuario("Sergio Lopes", 120));
        lista.add(new Usuario("Adriano Almeida", 100));
        lista.add(new Usuario("Paulo Silveira", 150, true));

        return lista;
    }
}
