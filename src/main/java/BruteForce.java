import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BruteForce {

    private static final int MAX_WORD_LENGTH = 28;
    private final CaesarCipher caesarCipher = new CaesarCipher();

    @SneakyThrows
    public void bruteForce() {
        Util.writeMessage("Введите адрес файла, к которому необходимо подобрать ключ");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "_bruteForce");
        String content = Files.readString(Path.of(src));
        for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
            String decrypt = caesarCipher.decrypt(content, i);
            if (isValidateText(decrypt)) {
                Files.writeString(dest,decrypt);
                Util.writeMessage("Содержимое файла расшифровано, ключ расшифровки равен " + i);
                break;
            }
        }
    }

    @SneakyThrows
    public void bruteForce1() {
        Util.writeMessage("Введите адрес файла, к которому необходимо подобрать ключ");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "_bruteForce");
        List<String> list = Files.readAllLines(Path.of(src));
        String string = String.join(System.lineSeparator(), list);

        for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
            String decrypt = caesarCipher.decrypt(string, i);
            if (isValidateText(decrypt)) {
                StringBuilder builder = new StringBuilder();
                for (String str : list) {
                    builder.append(caesarCipher.decrypt(str, i)).append(System.lineSeparator());
                }
                Files.write(dest, builder.toString().getBytes());
                Util.writeMessage("Содержимое файла расшифровано, ключ расшифровки равен " + i);
                break;
            }
        }
    }


    @SneakyThrows

    public void bruteForce2() {
        Util.writeMessage("Введите адрес файла, к которому необходимо подобрать ключ");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "_bruteForce");
        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dest)) {
            List<String> list = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                String string = reader.readLine();
                list.add(string);
                builder.append(string);
            }

            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(builder.toString(), i);
                if (isValidateText(decrypt)) {
                    for (String string : list) {
                        String str = caesarCipher.decrypt(string, i);
                        writer.write(str);
                        writer.newLine();
                    }
                    Util.writeMessage("Содержимое файла расшифровано, ключ расшифровки равен " + i);
                    break;
                }
            }
        }
    }

    private boolean isValidateText(String text) {
        boolean isValidate = false;
        for (String word : text.split(" ")) {
            if (word.length() > MAX_WORD_LENGTH) {
                return false;
            }
        }
        if (text.contains(". ") || text.contains(", ") || text.contains("! ") || text.contains("? ")) {
            isValidate = true;
        }
        while (isValidate) {
            Util.writeMessage("Проверьте, текст расшифрован? Да/Нет \n" + text.substring(0, 50));
            String answer = Util.readString();
            if (answer.equalsIgnoreCase("Да")) {
                return true;
            } else if (answer.equalsIgnoreCase("Нет")) {
                isValidate = false;
            } else {
                Util.writeMessage("Некорректный ответ");
            }
        }
        return false;
    }
}



