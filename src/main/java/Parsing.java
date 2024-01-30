import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


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
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Character, Integer> secondMap = new HashMap<>();
            while (reader.ready()) {
                String string = reader.readLine();

                for (char c : string.toCharArray()) {
                    map.put(c, +1);
                }
            }
            while (readerSecond.ready()) {
                String string = readerSecond.readLine();
                for (char c : string.toCharArray()) {
                    secondMap.put(c, +1);
                }
            }

            ArrayList<Character> arrayList = new ArrayList<>(map.keySet());
            ArrayList<Character> secondArrayList = new ArrayList<>(map.keySet());
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            Collections.sort(secondArrayList);
            Collections.reverse(secondArrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                if (secondMap.containsValue(secondArrayList.get(i))) {
                    map.put(arrayList.get(i), secondMap.get(secondArrayList.get(i)));
                } else {
                    map.put(arrayList.get(i), 0);
                }
            }
            for (int key : map.keySet())
                writer.write(map.get(key));
        }
    }
}