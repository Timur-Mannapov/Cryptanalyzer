import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("""
                    Выберете действие введя его номер:\s
                    1. Зашифровать текст в файле с помощью ключа.\s
                    2. Расшифровать текст в файле с помощью ключа.\s
                    3. Подобрать ключ используя brute force.\s
                    4. Расшифровать текст методом синтаксического анализа. \s
                    5. Выйти из программы.""");
            String answer = Util.readString();
            switch (answer) {
                case "1" -> new EncryptedDecrypted().encryptedDecrypted(true);
                case "2" -> new EncryptedDecrypted().encryptedDecrypted(false);
                case "3" -> System.out.println();
                case "4" -> System.out.println();
                case "5" -> {
                    return;

                }
            }
        }
    }
}