import java.security.NoSuchAlgorithmException;

public interface ENcryptionStrategy {

    void init() throws NoSuchAlgorithmException;
    String encrypt(String plaintext) throws Exception;
    String decrypt(String ciphertext) throws Exception;

}
