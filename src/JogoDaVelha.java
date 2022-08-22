import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {

        Campo[][] velha = new Campo[3][3];
        char simboloAtual = 'X';
        boolean game = true;
        String vitoria = "";
        Scanner scan = new Scanner(System.in);

        iniciarJogo(velha);

        while (game) {
            desenhaJogo(velha);
            if (velha[0][0].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X'
                    && velha[2][2].getSimbolo() == 'X' || velha[0][2].getSimbolo() == 'X'
                    && velha[1][1].getSimbolo() == 'X' && velha[2][0].getSimbolo() == 'X'
                    || velha[2][0].getSimbolo() == 'X' && velha[2][1].getSimbolo() == 'X'
                    && velha[2][2].getSimbolo() == 'X' || velha[1][0].getSimbolo() == 'X'
                    && velha[1][1].getSimbolo() == 'X' && velha[1][2].getSimbolo() == 'X'
                    || velha[0][0].getSimbolo() == 'X' && velha[0][1].getSimbolo() == 'X'
                    && velha[0][2].getSimbolo() == 'X' || velha[0][2].getSimbolo() == 'X'
                    && velha[1][1].getSimbolo() == 'X' && velha[2][0].getSimbolo() == 'X') {
                System.out.println("X - Você ganhou!");
                break;
            }else if (velha[0][0].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O'
                    && velha[2][2].getSimbolo() == 'O' || velha[0][2].getSimbolo() == 'O'
                    && velha[1][1].getSimbolo() == 'O' && velha[2][0].getSimbolo() == 'O'
                    || velha[2][0].getSimbolo() == 'O' && velha[2][1].getSimbolo() == 'O'
                    && velha[2][2].getSimbolo() == 'O' || velha[1][0].getSimbolo() == 'O'
                    && velha[1][1].getSimbolo() == 'O' && velha[1][2].getSimbolo() == 'O'
                    || velha[0][0].getSimbolo() == 'O' && velha[0][1].getSimbolo() == 'O'
                    && velha[0][2].getSimbolo() == 'O' || velha[0][2].getSimbolo() == 'O'
                    && velha[1][1].getSimbolo() == 'O' && velha[2][0].getSimbolo() == 'O') {
                System.out.println("O - Você ganhou!");
            }

            try {
                if (verificaJogada(velha, jogar(scan, simboloAtual), simboloAtual)) {
                    if (simboloAtual == 'X') {
                        simboloAtual = 'O';
                    } else {
                        simboloAtual = 'X';
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro");
            }
            System.out.println("Fim da jogada");
        }
    }

    public static void desenhaJogo(Campo[][] velha) {
        limparTela();
        System.out.println("   0       1        2");
        System.out.println("0   " + velha[0][0].getSimbolo() + "  |   " + velha[0][1].getSimbolo() + "   |   " +
                velha[0][2].getSimbolo() + "  \n");
        System.out.println("    -------------------");
        System.out.println("1   " + velha[1][0].getSimbolo() + "  |   " + velha[1][1].getSimbolo() + "   |   " +
                velha[1][2].getSimbolo() + "  \n");
        System.out.println("    -------------------");
        System.out.println("2   " + velha[2][0].getSimbolo() + "  |   " + velha[2][1].getSimbolo() + "   |   " +
                velha[2][2].getSimbolo() + "  \n");
    }

    public static void limparTela() { //OK
        for (int cont = 0; cont < 200; cont++) {
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner scan, char sa) { //OK
        int[] p = new int[2];
        System.out.printf("%s %c%n", "Quem joga: ", sa);
        System.out.print("Informe a linha");
        p[0] = scan.nextInt();
        System.out.print("Informe a coluna: ");
        p[1] = scan.nextInt();
        return p;
    }

    public static boolean verificaJogada(Campo[][] velha, int p[], char simboloAtual) { //OK
        if (velha[p[0]][p[1]].getSimbolo() == ' ') {
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        } else {
            return false;
        }
    }

    public static void iniciarJogo(Campo[][] velha) {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                velha[l][c] = new Campo();
            }
        }
    }
}
