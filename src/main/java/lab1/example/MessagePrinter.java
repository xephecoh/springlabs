package lab1.example;


public class MessagePrinter implements Printer {
    private String message;

    @InjectSomeValue( min = 5, max = 11)
    private int count;

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
