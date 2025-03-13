package com.PostgreSound.core.principal;

import java.util.Scanner;

public class Aplicacao {
    public void Menu() {
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
                """);

        System.out.print("Digite o número da opção: ");
        int n = sc.nextInt();

        switch (n){
            case 1:
                System.out.println("cadastro artista");
                break;
            case 2:
                System.out.println("cadastro música");
                break;
            case 3:
                System.out.println("lista de músicas");
                break;
            case 4:
                System.out.println("Buscando música por artista");
                break;
            case 5:
                System.out.println("Buscando lista de música por gênero");
                break;
            case 6:
                System.out.println("Pesquisando sobre o artista");
                break;
        }
    }
}
