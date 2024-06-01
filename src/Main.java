public class Main {
    public static void main(String[] args) {
        String word1 = "fish";
        String word2 = "fosh";
        SearchLCS(word1, word2);
    }

    static void SearchLCS(String word1, String word2) {
        int[][] cells = new int[word1.length() + 1][word2.length() + 1];

        // Вычисление длины наибольшей последовательности
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cells[i][j] = cells[i - 1][j - 1] + 1;
                } else {
                    cells[i][j] = Math.max(cells[i - 1][j], cells[i][j - 1]);
                }
            }
        }

        // Создание таблицы
        System.out.print("  ");
        for (int j = 0; j < word2.length(); j++) {
            System.out.print(" " + word2.charAt(j));
        }
        System.out.println();

        for (int i = 0; i <= word1.length(); i++) {
            if (i > 0) {
                System.out.print(word1.charAt(i - 1) + " ");
            } else {
                System.out.print("  ");
            }
            for (int j = 0; j <= word2.length(); j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }

        // Результат
        System.out.println();
        System.out.println("Длина наибольшей общей подпоследовательности: " + cells[word1.length()][word2.length()]);

        // Восстановление наибольшей общей подпоследовательности
        StringBuilder lcs = new StringBuilder();
        int i = word1.length(), j = word2.length();
        while (i > 0 && j > 0) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                lcs.append(word1.charAt(i - 1));
                i--;
                j--;
            } else if (cells[i - 1][j] > cells[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Печать LCS
        System.out.println("Наибольшая общая подпоследовательность: " + lcs.reverse().toString());
    }
}
