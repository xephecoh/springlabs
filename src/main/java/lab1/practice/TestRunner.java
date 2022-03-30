package lab1.practice;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lab1/practice/context.xml");
        StringMessagePrinter stringPrinter = (StringMessagePrinter) context.getBean("stringPrinter");
        MessagePrinter messagePrinter = (MessagePrinter)context.getBean("messagePrinter");
        stringPrinter.print();
        messagePrinter.print();
    }
}
