package com.company;

import java.util.ArrayList;
import java.util.Arrays;
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
    public static List<Usuario> criarListaExemploUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Jeoronei", 10));
        lista.add(new Usuario("Pedro", 5));
        lista.add(new Usuario("Thiago", 7));

        return lista;
    }
}
