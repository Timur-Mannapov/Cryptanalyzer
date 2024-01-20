import java.io.*;
import java.nio.file.Path;

public class Decrypted {
    public void decrypted() throws IOException {
        Util.writeMessage("Введите адрес файла, который нужно дешифровать");
        String src = Util.readString();
        Util.writeMessage("Введите ключ для дешифрования");
        int key = Util.readInt();
        System.out.println("Введите адрес файла, для сохранения результата");
        Path dest = Util.buildFileName(src,"out");
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
        BufferedWriter writer = new BufferedWriter(new FileWriter(dest.toFile()))) {
            CaesarCipher caesarCipher = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                String result = caesarCipher.decrypt(string,key);
                writer.write(result);
            }
        }
    }

}
