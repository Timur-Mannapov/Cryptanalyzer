import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class Encrypted {
    /* Запросить у пользователя адрес файла, который нужно зашифровать
    запросить ключ и запросить куда записать результат
     */
    public void encrypted() throws IOException {
        System.out.println("Введите адрес файла, который нужно зашифровать");
        String src =  Util.readString();
        System.out.println("Введите ключ для шифрования");
        int key = Util.readInt();
        Path dest = Util.buildFileName(src,"out");
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest.toFile()))) {
            CaesarCipher caesarCipher = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                String result = caesarCipher.encrypt(string, key);
                writer.write(result);
            }
        }
    }
}
