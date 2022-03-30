package lab1.practice;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectSomeRandomValue {
    int min() default 0;
    int max() default 0;
}
