import java.util.Scanner;

public class Movie {
    String name;
    int releaseDate;
    boolean included;
    private double somaAvaliacoes;
    private int totalScore;
    int timeInMinutes;
    int option = 0;
    double score = 0;
    Scanner scan = new Scanner(System.in);

    void showTecnicTable () {
        System.out.println("Nome  do filme: " + name);
        System.out.println("Ano de lançamento: " + releaseDate);
    }

    void avaliacao () {
        System.out.println("Deseja avaliar esse filme ?");
        System.out.println("""
                0- Não
                1- Sim""");
        option = scan.nextInt();

        while(option != 0) {
            avalia();
            System.out.println("A nota que você dá pra esse filme é " + score);

            System.out.println("Deseja avaliar novamente esse filme ?");
            System.out.println("""
                0- Nâo
                1- Sim""");
            option = scan.nextInt();
        }
    }

    void avalia () {
        System.out.println("Digite tua nota para esse filme: ");
        score = scan.nextDouble();
        somaAvaliacoes += score;
        totalScore++;
    }

    double getScore () {
        return somaAvaliacoes / totalScore;
    }

    int getTotalScore() {
        return totalScore;
    }
}
