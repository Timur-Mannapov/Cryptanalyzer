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
        if (text.contains("\\S{28}")) {
            return false;
        } else if (text.contains(". ") || text.contains(", ")) {
            return true;
        } else {
            boolean textQuestions = false;
            Util.writeMessage("Проверьте, текст расшифрован? Да/Нет \n" + text.substring(0, 50));
            while (textQuestions) {
                if (Util.readString().equalsIgnoreCase("Да")) {
                    return true;
                } else if (Util.readString().equalsIgnoreCase("Нет")) {
                    return true;
                } else {
                    Util.writeMessage("Некорректный ответ");
                }
            }

        }
        return false;
    }
}



