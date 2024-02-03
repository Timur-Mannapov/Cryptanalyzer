import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.*;
import java.util.*;


public class Parsing {
    public void parse() throws IOException {
        Util.writeMessage("Введите адрес файла, который нужно дешифровать");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "_parse.txt");
        Util.writeMessage("Предоставь второй файл для статистики");
        String statisticSrc = Util.readString();

        CaesarCipher caesarCipher = new CaesarCipher();
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedReader readerSecond = new BufferedReader(new FileReader(statisticSrc));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest.toFile()))) {
            Map<Character, Integer> map = new HashMap<>();
            Map<Character, Integer> secondMap = new HashMap<>();
            while (reader.ready()) {
                String string = reader.readLine();

                for (char c : string.toCharArray()) {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }
                }
            }
            while (readerSecond.ready()) {
                String string = readerSecond.readLine();
                for (char c : string.toCharArray()) {
                    if (secondMap.containsKey(c)) {
                        secondMap.put(c, map.get(c) + 1);
                    } else {
                        secondMap.put(c, 1);
                    }
                }
                Comparator<Map.Entry<Character,Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                };

//               for(Map.Entry<Character,Integer> entry : map.entrySet()) {
//               }

                for (int key : map.keySet())
                    writer.write(map.get(key));
            }
        }
    }
}