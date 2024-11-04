package DZ6.GradleDZ6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlayGame {
    private static final int TOTAL_GAMES = 1000;
    private static final int NUMBER_OF_DOORS = 3;
    private static int winsWithSwitch;
    private static int winsWithoutSwitch;

    private GameResult playGame(boolean switchChoice) {
        Random rand = new Random();

        int carPosition = rand.nextInt(NUMBER_OF_DOORS);
        int initialChoice = rand.nextInt(NUMBER_OF_DOORS);

        int doorToOpen;
        do {
            doorToOpen = rand.nextInt(NUMBER_OF_DOORS);
        } while (doorToOpen == carPosition || doorToOpen == initialChoice);

        int finalChoice = switchChoice ? NUMBER_OF_DOORS - initialChoice - doorToOpen : initialChoice;
        boolean win = finalChoice == carPosition;

        return new GameResult(win, switchChoice);
    }

    public void startGame() {

        winsWithSwitch = 0;
        winsWithoutSwitch = 0;

        int switchWins = 0;
        int noSwitchWins = 0;

        Map<Integer, String> results = new HashMap<>();

        for (int i = 0; i < TOTAL_GAMES; i++) {

            GameResult resultSwitch = playGame(true);
            GameResult resultNoSwitch = playGame(false);

            if (resultSwitch.isWin()) {
                winsWithSwitch++;
                results.put(i, "РЕЗУЛЬТАТ С ВЫБОРОМ = " + resultSwitch.isWin());
                switchWins++;
            }

            if (resultNoSwitch.isWin()) {
                winsWithoutSwitch++;
                results.put(i, "РЕЗУЛЬТАТ БЕЗ ВЫБОРА = " + resultNoSwitch.isWin());
                noSwitchWins++;
            }
        }

        double switchWinRate = (double) switchWins / TOTAL_GAMES;
        double noSwitchWinRate = (double) noSwitchWins / TOTAL_GAMES;

        System.out.println("Общее количество попыток: " + TOTAL_GAMES);
        System.out.println("Количество выигрышей с повторным выбором: " + winsWithSwitch + ", тоже самое в процентах: " + (winsWithSwitch * 100.0) / TOTAL_GAMES + "%");
        System.out.println("Количество выигрышей без повторного выбора: " + winsWithoutSwitch + ", тоже самое в процентах: " + (winsWithoutSwitch * 100.0) / TOTAL_GAMES + "%");

        System.out.println("Среднее значение выигрышей с повторным выбором: " + switchWinRate);
        System.out.println("Среднее значение выигрышей без повторного выбора: " + noSwitchWinRate);

        System.out.println("Результаты игры: ");
        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private class GameResult {
        private final boolean win;
        private final boolean switchChoice;

        public GameResult(boolean win, boolean switchChoice) {
            this.win = win;
            this.switchChoice = switchChoice;
        }

        public boolean isWin() {
            return win;
        }

        public boolean isSwitchChoice() {
            return switchChoice;
        }
    }
}
