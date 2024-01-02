import java.util.Scanner;


public class StatisticalAnalysis {
    public void statisticalAnalysis() {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher caesarCipher = new CaesarCipher();
        System.out.println("Введите текст, который нужно расшифровать");
        String string = scanner.nextLine();
        int key = 1;
        String decryptText = caesarCipher.decrypt(string, key);
        String anotherText = scanner.nextLine();
        int i = 0;
        int i2 = 5;
        String fiveLetters = String.valueOf(decryptText.indexOf(i,i2));
        while (!anotherText.contains(fiveLetters)) {
            i += 5;
            i2 += 5;
            while (!(anotherText.contains(fiveLetters))) {
                key += 1;
                System.out.println(decryptText);
            }
        }
    }
}
