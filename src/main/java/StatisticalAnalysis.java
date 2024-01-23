import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.*;


public class StatisticalAnalysis {
    public void statisticalAnalysis() throws IOException {
        System.out.println("Введите адрес файла, который нужно дешифровать");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "result.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest.toFile()))) {
            CaesarCipher caesarCipher = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                int countMax = 0;
                char[] symbolArray = new char[src.length()];

                for (char c : string.toCharArray()) {
                    symbolArray[c]++;
                }
                for (int i = 0; i < symbolArray.length; i++) {
                    if(countMax < symbolArray[i]) {
                        countMax = symbolArray[i];
                    }
                }
            }
        }
    }
}
