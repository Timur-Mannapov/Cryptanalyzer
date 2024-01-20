import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Util {
    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private Util() {

    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String string;
        try {
            string = CONSOLE.readLine();
        } catch (IOException e) {
            writeMessage("Произошла ошибка при вводе текста");
            string = readString();
        }
        return string;
    }

    public static int readInt() {
        int number;
        try {
            number = Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            writeMessage("Произошла ошибка при вводе числа");
            number = readInt();
        }
        return number;
    }

    public static Path buildFileName(String path, String suffix) {
        Path parent = Path.of(path).getParent();
        Path fileName = Path.of(path).getFileName();
        String src = fileName.toString();
        if (src.contains(".")) {
            String result = src.substring(0,src.indexOf("."));
            String dest = result + suffix;
            return parent.resolve(dest);
        } else {
            String dest = src + suffix;
            return parent.resolve(dest);
        }
    }

}
