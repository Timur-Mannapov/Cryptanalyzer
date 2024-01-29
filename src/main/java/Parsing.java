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
            HashMap<Integer, Character> map = new HashMap<>();
            HashMap<Integer, Character> secondMap = new HashMap<>();
            int keyMap = 0;
            while (reader.ready()) {
                String string = reader.readLine();
                for (char c : string.toCharArray()) {
                    map.put(keyMap++, c);
                }
            }
            while (readerSecond.ready()) {
                String string = readerSecond.readLine();
                for (char c : string.toCharArray()) {
                    secondMap.put(keyMap++, c);
                }
            }
            ArrayList<Integer> arrayList = new ArrayList<>(map.keySet());
            ArrayList<Integer> secondArrayList = new ArrayList<>(map.keySet());
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            Collections.sort(secondArrayList);
            Collections.reverse(secondArrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                map.put(arrayList.get(i), secondMap.get(secondArrayList.get(i)));

            }
            for (int key : map.keySet())
                writer.write(map.get(key));
        }
    }
}