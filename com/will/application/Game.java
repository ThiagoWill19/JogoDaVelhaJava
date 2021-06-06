package JogoDaVelha.com.will.application;

import java.util.Scanner;

public class Game {
    
    private char map[][] = {{' ',' ',' '},
                            {' ',' ',' '},
                            {' ',' ',' '},};

    private int linha, coluna;
    private int loop = 1;
    private Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        game.Start();
        
    }

    public void Start(){

        while (loop <= 9) {
            
            limpaTela();
            display();
            jogada();
            loop ++;

        }
    }

    private void limpaTela(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }

    private void display(){
        System.out.println("  0 1 2");
        for(int i = 0; i < 3; i++){
            System.out.print(i);
            for(int j = 0; j < 3; j++){
                System.out.print("|" + map[i][j]);
            }
            System.out.println("|");
        }
    }

    private void jogada(){
        try {
            System.out.print("Digite a linha: ");
            linha = Integer.parseInt(entrada.nextLine());
            System.out.print("Digite a coluna: ");
            coluna = Integer.parseInt(entrada.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\nVocê deve digitar um número de 0 a 2, refaça a jogada!");
            jogada();
        }

        validarJogada();
        
    }

    private void validarJogada(){
        
        if(linha <= 2 && coluna <= 2 && linha >= 0 && coluna >= 0){
            if(map[linha][coluna] == ' '){
                finalizarJogada();
            }else{
                System.out.println("Jogada inválida, refaça a jogada!");
                jogada();
            }
        }else{
            System.out.println("Você deve digitar um número de 0 a 2, refaça a jogada!");
            jogada();
        }

    } 

    private void finalizarJogada(){
        if(loop % 2 == 0){
            map[linha][coluna] = 'X';
        }else map[linha][coluna] = 'O';
        verificarJogo();

    }

    private void verificarJogo(){

        //Verificar linhas
        for(int i = 0; i < 3; i++){
            
            if(map[i][0] == map[i][1] && map[i][1] == map[i][2] && map[i][0] != ' '){
                 vitoria();
            }    
        }

        //verificar colunas
        for(int i = 0; i < 3; i++){
            
            if(map[0][i] == map[1][i] && map[1][i] == map[2][i] && map[0][i] != ' '){
                vitoria();
            } 
        }

        //verificar vertical1
        if(map[0][0] == map[1][1] && map[0][0] == map[2][2] && map[0][0] != ' '){
            vitoria();
        }
        //verificar vertical2
        if(map[0][2] == map[1][1] && map[0][2] == map[2][0] && map[0][2] != ' '){
            vitoria();
        }

        if(loop == 9){
            limpaTela();
            display();
            System.out.println("Deu Velha!!");;
        }

    }

    private void vitoria(){
        limpaTela();
        display();
        if(loop % 2 == 0){
            System.out.println("Vitoria X");
        }else System.out.println("Vitoria O");
        loop = 10;         
    }
}

