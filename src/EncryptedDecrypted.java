import java.util.Scanner;

public class EncryptedDecrypted {
    /* Запросить у пользователя адрес файла, который нужно зашифровать и дешифровать,
    запросить ключ и запросить куда записать результат
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес файла, который нужно зашифровать или дешифровать");
        String file = scanner.nextLine();
        System.out.println("Введите ключ");
        int key = scanner.nextInt();
        System.out.println("Введите адрес файла, который нужно зашифровать или дешифровать");
        String resultFile = scanner.nextLine();
        System.out.println("Выберите режим: шифрование/дешифрование");
        String mode = scanner.nextLine();

        if (mode.equalsIgnoreCase("шифрование")) {
            System.out.println("");
        } else if (mode.equalsIgnoreCase("дешифрование")) {
            System.out.println("");
        } else {
            System.out.println("Неправильно выбран режим");
        }

    }
}
