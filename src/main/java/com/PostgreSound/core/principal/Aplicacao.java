package com.PostgreSound.core.principal;

import java.util.Scanner;

public class Aplicacao {
    public void Menu() {
        int n = 0;
        Scanner sc = new Scanner(System.in);
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
}
