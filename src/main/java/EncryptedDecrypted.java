import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class EncryptedDecrypted {
    /* Запросить у пользователя адрес файла, который нужно зашифровать и дешифровать,
    запросить ключ и запросить куда записать результат
     */
    public void encryptedDecrypted(boolean flag) throws IOException {

        System.out.println("Введите адрес файла, который нужно зашифровать");
        String src = Util.readString();
        System.out.println("Введите ключ для шифрования/дешифрования");
        int key = Util.readInt();
        Path dest = Util.buildFileName(src,"result");
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest.toFile()))) {
            CaesarCipher caesarCipher = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                String result;
                if (flag) {
                    result = caesarCipher.encrypt(string, key);
                    writer.write(result);
                } else if (!flag){
                    result = caesarCipher.decrypt(string, key);
                    writer.write(result);
                }
            }

        }

    }
}
