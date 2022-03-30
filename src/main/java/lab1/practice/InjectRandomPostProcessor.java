package lab1.practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * класс спрингового пост процессора, должен имплементировать интерфейс
 *
 * @see BeanPostProcessor
 * <p>
 * Класс отвечает за логику инжекта случайного числа в поле проаннотированное, специально обученной аннотацией
 */
public class InjectRandomPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            InjectSomeRandomValue annotation = field.getDeclaredAnnotation(InjectSomeRandomValue.class);
            if (annotation != null) {
                Class<?> o = JavaNumberTypeCast.castPrimitive(field.getType());
                if (o != null) {
                        int min = annotation.min();
                        int max = annotation.max();
                        Random random = new Random();
                        int randomValue = min + random.nextInt(max - min);
                    if (Number.class.isAssignableFrom(o)) {
                        field.setAccessible(true);
                        ReflectionUtils.setField(field, bean, randomValue);
                    } else {
                        field.setAccessible(true);
                        String randomString = RandomStringGeneratorUtil.generateRandomString(randomValue);
                        ReflectionUtils.setField(field, bean, randomString);
                    }
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
