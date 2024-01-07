import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Выберете действие введя его номер:\s
                    1. Зашифровать текст в файле с помощью ключа.\s
                    2. Расшифровать текст в файле с помощью ключа.\s
                    3. Подобрать ключ используя brute force.\s
                    4. Расшифровать текст методом синтаксического анализа. \s
                    5. Выйти из программы.""");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1" -> System.out.println();
                case "2" -> System.out.println();
                case "3" -> System.out.println();
                case "4" -> System.out.println();
                case "5" -> {
                    return;

                }
            }
        }
    }
}