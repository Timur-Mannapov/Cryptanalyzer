import java.io.*;
import java.nio.file.Path;

public class Encrypted {
    public void encrypted() throws IOException {
        Util.writeMessage("Введите адрес файла, который нужно зашифровать");
        String src =  Util.readString();
        Util.writeMessage("Введите ключ для шифрования");
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
