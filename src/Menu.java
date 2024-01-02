import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher caesarCipher = new CaesarCipher();
        BruteForce bruteForce = new BruteForce();
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        while (true) {
            System.out.println("""
                    Выберете действие введя его номер:\s
                    1. Зашифровать текст в файле с помощью ключа.\s
                    2. Расшифровать текст в файле с помощью ключа.\s
                    3. Подобрать ключ используя brute force.\s
                    4. Расшифровать текст методом синтаксического анализа. \s
                    5. Выйти из программы.""");
            String answer = scanner.nextLine();
            String string = scanner.nextLine();
            int key = scanner.nextInt();
            switch (answer) {
                case "1" -> caesarCipher.encrypt(string, key);
                case "2" -> caesarCipher.decrypt(string, key);
                case "3" -> bruteForce.bruteForce();
                case "4" -> statisticalAnalysis.statisticalAnalysis();
                case "5" -> {
                    return;

                }
            }
        }
    }
}