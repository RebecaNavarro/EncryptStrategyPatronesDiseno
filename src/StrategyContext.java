public class StrategyContext {
    private ENcryptionStrategy encryptionStrategy;

    public StrategyContext() {
        // Por defecto, inicializamos con AES
        this.encryptionStrategy = new AEStrategy();
    }

    public void setStrategy(ENcryptionStrategy encryptionStrategy) {
        this.encryptionStrategy = encryptionStrategy;
    }

    public String encryptText(String text) throws Exception {
        return encryptionStrategy.encrypt(text);
    }

    public String decryptText(String text) throws Exception {
        return encryptionStrategy.decrypt(text);
    }

    public static void main(String[] args) throws Exception {
        StrategyContext context = new StrategyContext();

        // Ejemplo de uso con AES
        context.setStrategy(new AEStrategy());
        context.encryptionStrategy.init();
        String encryptedAES = context.encryptText("Mundo");
        System.out.println("AES encrypted: " + encryptedAES);
        String decryptedAES = context.decryptText(encryptedAES);
        System.out.println("AES decrypted: " + decryptedAES);

        // Ejemplo de uso con César
        context.setStrategy(new CaesarStrategy(3));
        String encryptedCaesar = context.encryptText("Hello World");
        System.out.println("Caesar encrypted: " + encryptedCaesar);
        String decryptedCaesar = context.decryptText(encryptedCaesar);
        System.out.println("Caesar decrypted: " + decryptedCaesar);
    }

}
