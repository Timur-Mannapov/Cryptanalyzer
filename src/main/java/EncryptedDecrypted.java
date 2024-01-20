import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class EncryptedDecrypted {

    private final CaesarCipher caesarCipher = new CaesarCipher();

    public void encryptedDecrypted(boolean flag) throws IOException {

        Util.writeMessage("Введите адрес файла, который нужно " + (flag ? "зашифровать" : "дешифровать"));
        String src = Util.readString();
        Util.writeMessage("Введите ключ");
        int key = Util.readInt();
        Path dest = Util.buildFileName(src, flag ? "_encrypted" : "_decrypted");
        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dest)) {
            while (reader.ready()) {
                String string = reader.readLine();
                String result = flag ? caesarCipher.encrypt(string, key) : caesarCipher.decrypt(string, key);
                writer.write(result);
                writer.newLine();
            }
        }
    }
}
