package com.PostgreSound.core.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NomeDoArtista",unique = true)
    private String nome;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicaList = new ArrayList<>();

    public Artista(){}

    public Artista(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Musica> getMusicaList() {
        return musicaList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMusicaList(List<Musica> musicaList) {
        this.musicaList = musicaList;
    }

    @Override
    public String toString() {
        String titulos = musicaList.stream()
                .map(Musica::getTitulo)
                .reduce((a,b) -> a + "," + b)
                .orElse("nenhuma musica registada");
        return "Artista{" +
                "nome='" + nome + '\'' +
                ", nome das músicas: " + "[" + titulos +"]" +
                '}';
    }
}
