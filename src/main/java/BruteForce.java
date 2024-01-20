import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce {

    private final CaesarCipher caesarCipher = new CaesarCipher();

    @SneakyThrows
    public void bruteForce() {
        Util.writeMessage("Введите адрес файла, к которому необходимо подобрать ключ");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "_bruteForce");
        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dest)) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                String string = reader.readLine();
                builder.append(string);
            }
            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(builder.toString(), i);
                if (isValidateText(decrypt)) {
                    writer.write(decrypt);
                    Util.writeMessage("Содержимое файла расшифровано, ключ расшифровки равен " + i);
                    break;
                }
            }
        }
    }
    private boolean isValidateText(String text) {
        return false;
    }
}



