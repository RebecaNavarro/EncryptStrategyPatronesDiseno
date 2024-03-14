import java.security.NoSuchAlgorithmException;

public class CaesarStrategy implements ENcryptionStrategy{
    private int shift;

    public CaesarStrategy(int shift) {
        this.shift = shift;
    }

    @Override
    public void init() throws NoSuchAlgorithmException {
        // No es necesario para César
    }

    @Override
    public String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char shiftedChar = (char) (((c - 'A' + shift) % 26) + 'A');
                encryptedText.append(shiftedChar);
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    @Override
    public String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char shiftedChar = (char) (((c - 'A' - shift + 26) % 26) + 'A');
                decryptedText.append(shiftedChar);
            } else {
                decryptedText.append(c);
            }
        }
        return decryptedText.toString();
    }
}
