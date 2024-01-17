import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class EncryptedDecrypted {
    /* Запросить у пользователя адрес файла, который нужно зашифровать и дешифровать,
    запросить ключ и запросить куда записать результат
     */
    public void encryptedDecrypted(boolean flag) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес файла, который нужно зашифровать");
        String src = scanner.nextLine();
        System.out.println("Введите ключ для шифрования");
        int key = scanner.nextInt();
        System.out.println("Введите адрес файла, для сохранения результата");
        String dest = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            CaesarCipher caesarCipher = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                if (flag == true) {
                    String result = caesarCipher.encrypt(string, key);
                    writer.write(result);
                } else {
                    String result = caesarCipher.decrypt(string, key);
                    writer.write(result);
                }
            }

        }

    }
}