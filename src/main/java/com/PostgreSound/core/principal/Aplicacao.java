package com.PostgreSound.core.principal;

import com.PostgreSound.core.model.Artista;
import com.PostgreSound.core.model.Genero;
import com.PostgreSound.core.model.Musica;
import com.PostgreSound.core.repositorio.Repositorio;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Aplicacao {
    private final Repositorio repositorio;
    
    Scanner sc = new Scanner(System.in);
    public Aplicacao(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void Menu() {
        int n = 0;
        System.out.println("""
                Bem vindo ao PostgreSound !!!
                
                Escolha a opção que deseja:
                1- Cadastrar artista
                2- Cadastrar música
                3- Listar músicas
                4- Buscar música por artista
                5- Buscar lista de música por gênero
                6- Pesquisar sobre um artista
                7- sair
                """);
        while(n != 7) {
            System.out.println();
            System.out.print("Digite o número da opção: ");
            n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    buscarListaDeMusicaPorGenero();
                    break;
                case 6:
                    pesquisarSobreArtista();
                    break;
            }
        }
    }

    private void cadastrarArtista() {
        var novoCadastro = "S";
        while(novoCadastro.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome do artista:");
            var nome = sc.nextLine();
            Artista artista = new Artista(nome);
            repositorio.save(artista);
            System.out.println("Cadastrar um novo?(S/N)");
            novoCadastro = sc.nextLine();
        }
    }

    private void cadastrarMusica() {
        System.out.println("Cadastrar música de que artista? ");
        var nome = sc.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if(artista.isPresent()){
            System.out.println("Informe o título da música: ");
            var titulo = sc.nextLine();
            System.out.println("Qual desses gêneros ela se encaixa: POP/Rock/Funk");
            var genero = sc.nextLine();
            Genero generoMusica = Genero.valueOf(genero.toUpperCase());
            Musica musica = new Musica(titulo,generoMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicaList().add(musica);
            repositorio.save(artista.get());
        } else{
            System.out.println("Artista não encontrado");
        }
    }

    private void listarMusicas() {
        List<Artista> artistaList = repositorio.findAll();
        artistaList.forEach(System.out::println);
    }

    private void buscarMusicaPorArtista() {
    }

    private void buscarListaDeMusicaPorGenero() {
    }

    private void pesquisarSobreArtista() {
    }








}
