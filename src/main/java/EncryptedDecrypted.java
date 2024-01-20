import java.io.*;
import java.nio.file.Path;

public class EncryptedDecrypted {

    public void encryptedDecrypted(boolean flag) throws IOException {

        System.out.println("Введите адрес файла, который нужно зашифровать/дешифровать");
        String src = Util.readString();
        System.out.println("Введите ключ для шифрования/дешифрования");
        int key = Util.readInt();
        Path dest = Util.buildFileName(src, "result.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest.toFile()))) {
            CaesarCipher caesarCipher = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                String result;
                if (flag) {
                    result = caesarCipher.encrypt(string, key);
                    writer.write(result);
                } else {
                    result = caesarCipher.decrypt(string, key);
                    writer.write(result);
                }
            }
        }
    }
}
