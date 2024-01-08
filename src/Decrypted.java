import java.util.Scanner;

public class Decrypted {
    /* Запросить у пользователя адрес файла, который нужно дешифровать
    запросить ключ и запросить куда записать результат
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес файла, который нужно дешифровать");
        String decryptedFile = scanner.nextLine();
        System.out.println("Введите ключ для дешифрования");
        int key = scanner.nextInt();
        System.out.println("Введите адрес файла, для сохранения результата");
    }

}
