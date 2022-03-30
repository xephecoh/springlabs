package lab1.practice;

import lab1.example.InjectSomeValue;


public class MessagePrinter implements Printer {
    private String message;

    // создать аннотацию и аннотировать поле так, что бы при поднятии контекста
    // в поле инжектилось случайное число от 0 до числа заданого при помощи аннотации
    @InjectSomeRandomValue(min = 3, max = 5)
    private int count;

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
