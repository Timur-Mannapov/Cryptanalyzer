import java.util.Scanner;

public class Encrypted {
    /* Запросить у пользователя адрес файла, который нужно зашифровать
    запросить ключ и запросить куда записать результат
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес файла, который нужно зашифровать");
        String encyptFile = scanner.nextLine();
        System.out.println("Введите ключ для шифрования");
        int key = scanner.nextInt();
        System.out.println("Введите адрес файла, для сохранения результата");
        String result = scanner.nextLine();
    }
}
