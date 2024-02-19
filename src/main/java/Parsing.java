import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;
import java.util.*;


public class Parsing {
    public void parse() throws IOException {
        Util.writeMessage("Введите адрес файла, который нужно дешифровать");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "_parse.txt");
        Util.writeMessage("Предоставь второй файл для статистики");
        String statistic = Util.readString();
        List<Map.Entry<Character,Integer>> encryptedSrc = convertToList(src);
        List<Map.Entry<Character,Integer>> statisticSrc = convertToList(statistic);

        if (encryptedSrc.size() <= statisticSrc.size()) {
            Map<Character,Character> decrypted = new HashMap<>();
            for (int i = 0; i < encryptedSrc.size(); i++) {
                decrypted.put(encryptedSrc.get(i).getKey(), statisticSrc.get(i).getKey());
            }
            try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
            BufferedWriter writer = Files.newBufferedWriter(dest)){
                while (reader.ready()) {
                    String read = reader.readLine();
                    StringBuilder builder = new StringBuilder();
                    for (char aChar : read.toCharArray()) {
                        Character decrypt = decrypted.get(aChar);
                        builder.append(decrypt);
                    }
                    writer.write(builder.toString());
                    writer.newLine();
                }
            }
            Util.writeMessage("Содержимое успешно расшифровано");
        } else {
            Util.writeMessage("Размер файл статистики должен быть больше");
        }
    }

    @SneakyThrows
    private List<Map.Entry<Character, Integer>> convertToList(String path) {
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : Files.readString(Path.of(path)).toCharArray()) {
            map.merge(aChar,1,Integer::sum);
        }
//        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
//            while (reader.ready()) {
//                String string = reader.readLine();
//                for (char aChar : string.toCharArray()) {
                    //map.merge(aChar,1,Integer::sum) ;
//                    map.merge(aChar,1,(oldValue, newValue) -> Integer.sum(oldValue,newValue)) ;
                   /* if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    } */
//                }
//            }
//        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        return list;
    }
}
