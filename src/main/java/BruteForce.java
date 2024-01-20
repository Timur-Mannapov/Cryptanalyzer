import java.io.*;

public class BruteForce {
    public void bruteForce() throws IOException {
        System.out.println("Введите адрес файла, к которому необходимо подобрать ключ");
        String src = Util.readString();
        try (BufferedReader reader = new BufferedReader(new FileReader(src))) {
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
                int result = symbolArray[countMax] - caesarCipher.ALPHABET.indexOf(symbolArray[countMax]);
                System.out.println("Ваш ключ" + result);
            }
        }
        }
    }



