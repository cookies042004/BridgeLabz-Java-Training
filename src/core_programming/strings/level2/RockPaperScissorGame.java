package core_programming.strings.level2;

import java.util.Scanner;

public class RockPaperScissorGame {
    // Method to generate computer choice
    static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissor"};
        int index = (int) (Math.random() * 3);
        return choices[index];
    }

    // Method to find winner of a game
    static String findWinner(String user, String computer) {

        if (user.equals(computer)) {
            return "Draw";
        }

        if ((user.equals("rock") && computer.equals("scissor")) ||
                (user.equals("paper") && computer.equals("rock")) ||
                (user.equals("scissor") && computer.equals("paper"))) {
            return "User";
        }

        return "Computer";
    }

    // Method to calculate stats and return 2D array
    static String[][] calculateStats(int userWins, int computerWins, int totalGames) {

        String[][] stats = new String[2][3];

        double userPercent = (userWins * 100.0) / totalGames;
        double computerPercent = (computerWins * 100.0) / totalGames;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", computerPercent);

        return stats;
    }

    // Method to display results
    static void displayResults(String[][] gameResults, String[][] stats) {

        System.out.println("\nGame Results");
        System.out.println("Game\tUser\tComputer\tWinner");
        System.out.println("-------------------------------------");

        for (int i = 0; i < gameResults.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                            gameResults[i][0] + "\t" +
                            gameResults[i][1] + "\t\t" +
                            gameResults[i][2]
            );
        }

        System.out.println("\nFinal Statistics");
        System.out.println("Player\tWins\tWin Percentage");
        System.out.println("--------------------------------");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(
                    stats[i][0] + "\t" +
                            stats[i][1] + "\t" +
                            stats[i][2] + "%"
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = sc.nextInt();

        String[][] gameResults = new String[n][3];
        int userWins = 0, computerWins = 0;

        for (int i = 0; i < n; i++) {

            System.out.print("Pick one (rock/paper/scissor): ");
            String userChoice = sc.next().toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
        }

        String[][] stats = calculateStats(userWins, computerWins, n);
        displayResults(gameResults, stats);
    }
}
