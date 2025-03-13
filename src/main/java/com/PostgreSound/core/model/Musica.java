package com.PostgreSound.core.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NomeDaMusica")
    private String titulo;
    @ManyToOne
    private Artista artista;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public Musica(){}

    public Musica(long id, String titulo, Artista artista, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", artista=" + artista +
                ", genero=" + genero +
                '}';
    }
}
