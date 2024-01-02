
public class CaesarCipher {
    private static final String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,””:-!? ";


    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (char aChar : message.toCharArray()) {
            int index = alphabet.indexOf(aChar);
            if (index >= 0) {
                int newIndex = (index + key) % alphabet.length();
                char charAt = (newIndex < 0) ? alphabet.charAt(newIndex + alphabet.length()) : alphabet.charAt(newIndex);
                builder.append(charAt);
            }
        }
        return builder.toString();
    }

    public String decrypt(String message, int key) {

        return encrypt(message, key * (-1));
    }
}


