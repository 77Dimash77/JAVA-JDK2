package Final;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
        int totalGames = 1000;
        Map<Integer, String> results = new HashMap<>();

        for (int i = 1; i <= totalGames; i++) {
            boolean win = playMontyHall();
            results.put(i, win ? "Win" : "Lose");
        }

        printResults(results, totalGames);
    }

    private static boolean playMontyHall() {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

        // Имитация выбора игрока
        int playerChoice = randomDataGenerator.nextInt(1, 4);

        // Определение места автомобиля и открытие одной из дверей
        int carLocation = randomDataGenerator.nextInt(1, 4);
        int doorToOpen;
        do {
            doorToOpen = randomDataGenerator.nextInt(1, 4);
        } while (doorToOpen == playerChoice || doorToOpen == carLocation);

        // Предложение игроку сменить выбор
        int newChoice;
        do {
            newChoice = randomDataGenerator.nextInt(1, 4);
        } while (newChoice == playerChoice || newChoice == doorToOpen);

        // Проверка, выиграл ли игрок
        return newChoice == carLocation;
    }

    private static void printResults(Map<Integer, String> results, int totalGames) {
        int wins = (int) results.values().stream().filter(result -> result.equals("Win")).count();
        int loses = totalGames - wins;

        System.out.println("Wins: " + wins);
        System.out.println("Loses: " + loses);
    }
}
