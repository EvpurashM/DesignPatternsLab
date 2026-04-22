package structural;

interface Message { String getContent(); }

class TextMessage implements Message {
    public String getContent() { return "Привіт, як справи?"; }
}

class MessageDecorator implements Message {
    protected Message msg;
    public MessageDecorator(Message m) { this.msg = m; }
    public String getContent() { return msg.getContent(); }
}

class EncryptedMessage extends MessageDecorator {
    public EncryptedMessage(Message m) { super(m); }
    public String getContent() { 
        return super.getContent() + " [Зашифровано] (Декоратор)"; 
    }
}

public class DecoratorPattern {
    public static void run() {
        Message msg = new EncryptedMessage(new TextMessage());
        System.out.println(msg.getContent());
    }
}