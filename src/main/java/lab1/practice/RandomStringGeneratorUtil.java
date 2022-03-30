package lab1.practice;

import java.util.Random;

public class RandomStringGeneratorUtil {

    public static String generateRandomString(int size) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        char[] text = new char[size];
        for (int i = 0; i < size; i++) {
            text[i]= characters.charAt(random.nextInt(size));
        }
        for (char c : text) {
            randomString.append(c);
        }
        return randomString.toString();
    }

}
