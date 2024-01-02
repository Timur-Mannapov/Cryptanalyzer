import java.util.Scanner;

public class BruteForce {
    public static void main(String[] args) {
        System.out.println("Введите текст, который нужно расшифровать");
        Scanner scanner = new Scanner(System.in);
        CaesarCipher caesarCipher = new CaesarCipher();
        String string = scanner.nextLine();
        String answer = scanner.nextLine();

            for (int i = 1; i < 41; i++) {
                int key = i;
                caesarCipher.decrypt(string, key);
                System.out.println("Текст расшифрован?");
                System.out.println("Yes/No");
            }
        }


        }
    }
