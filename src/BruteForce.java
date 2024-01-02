import java.util.Scanner;

public class BruteForce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher caesarCipher = new CaesarCipher();
        System.out.println("Введите текст, который нужно расшифровать");
        String string = scanner.nextLine();
        int key = 1;
        String decryptText = caesarCipher.decrypt(string, key);
        System.out.println(decryptText);
        System.out.println("Текст расшифрован?");
        System.out.println("Да/Нет");
        String answer = scanner.nextLine();
        while (answer.equals("Нет")) {
            while (!(decryptText.equals(", ")) && !(decryptText.equals(". "))) {
                key += 1;
                System.out.println(decryptText);
                System.out.println("Текст расшифрован?");
                System.out.println("Да/Нет");
                answer = scanner.nextLine();
            }
        }
    }
}
