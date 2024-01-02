import java.util.Scanner;


public class StatisticalAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher caesarCipher = new CaesarCipher();
        System.out.println("Введите текст, который нужно расшифровать");
        String string = scanner.nextLine();
        int key = 1;
        String decryptText = caesarCipher.decrypt(string, key);
        String anotherText = scanner.nextLine();
    }
}
