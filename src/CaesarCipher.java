import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CaesarCipher {
    private static final String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,””:-!? ";
    ArrayList<String> alphaBet = new ArrayList<>(Arrays.asList(alphabet));


    public ArrayList<String> encrypt(String message, int key) {
        ArrayList<String> enCrypt = new ArrayList<>();
        enCrypt.add(message);
        for (int i = 0; i < enCrypt.size(); i++) {
            int index = 0;
            if (alphabet.contains(enCrypt.get(i))) {
                index = alphabet.indexOf(enCrypt.get(i));
                enCrypt.set(i, alphaBet.get(index + key));
            } else {
                return enCrypt;
            }
        }
        return null;
    }
        public String decrypt (String message,int key){
            return "";
        }
    }


