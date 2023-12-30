import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {
    private static final String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,””:-!? ";
    ArrayList<String> alphaBet = new ArrayList<>(List.of(alphabet));


    public ArrayList<String> encrypt(String message, int key) {
        ArrayList<String> enCrypt = new ArrayList<>();
        enCrypt.add(message);
        for (int i = 0; i < enCrypt.size(); i++) {
            int index = 0;
            if (alphabet.contains(enCrypt.get(i))) {
                index = alphabet.indexOf(enCrypt.get(i));
                enCrypt.set(i, alphaBet.get(index + key));
            }
        }
        return enCrypt;
    }

    public ArrayList<String> decrypt(String message, int key) {
        ArrayList<String> deCrypt = new ArrayList<>();
        deCrypt.add(message);
        for (int i = 0; i < deCrypt.size(); i++) {
            int index = 0;
            if (alphabet.contains(deCrypt.get(i))) {
                index = alphabet.indexOf(deCrypt.get(i));
                deCrypt.set(i, alphaBet.get(index - key));
            }
        }
        return deCrypt;
    }
    public String bruteForce(String message) {
        ArrayList<String> msg = new ArrayList<>();

        return "";
    }
    public String statisticalAnalysisMethod (String message, String authhorMessage) {
        return ""
    }
}


