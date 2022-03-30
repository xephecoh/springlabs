package lab1.practice;


public class StringMessagePrinter implements Printer{
    @InjectSomeRandomValue(min = 3, max = 5)
    private String randomString;

    @Override
    public void print() {
        System.out.println(randomString);
    }


    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }
}
