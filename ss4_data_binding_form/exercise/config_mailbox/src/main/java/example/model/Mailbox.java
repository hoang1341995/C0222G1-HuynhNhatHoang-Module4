package example.model;

public class Mailbox {
    private String language;
    private int size;
    private boolean spamsFillter;
    private String signature;

    public Mailbox() {
    }

    public Mailbox(String language, int size, boolean spamsFillter, String signature) {
        this.language = language;
        this.size = size;
        this.spamsFillter = spamsFillter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(boolean spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
