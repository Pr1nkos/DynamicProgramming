import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        String word1 = "gorbusha";
        String word2 = "solusha";
        SearchLCS(word1, word2);

    }

    static void SearchLCS (String word1, String word2) {
        int [][] cells = new int[word1.length() + 1][word2.length() + 1];

        //Вычисление длины наибольшей последовательности
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cells[i][j] = cells[i-1][j-1] + 1;
                } else {
                    cells[i][j] = Math.max(cells[i-1][j], cells[i][j-1]);
                }
            }
        }

        //Создание таблицы
        System.out.print(" ");
        for (int j = 0; j < word2.length(); j++) {
            System.out.print(" " + word2.charAt(j));
        }
        System.out.println();

        for (int i = 1; i <= word1.length(); i++) {
            if (i > 0) {
                System.out.print(word1.charAt(i - 1) + " ");
            } else {
                System.out.print("  ");
            }
            for (int j = 1; j <= word2.length(); j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
        //Результат
        System.out.println();
        System.out.println("Длина наибольшей общей подпоследовательности: " + cells[word1.length()][word2.length()]);
    }
}
