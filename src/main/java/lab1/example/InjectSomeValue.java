package lab1.example;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectSomeValue {
    int min() default 0;
    int max() default 0;
}
