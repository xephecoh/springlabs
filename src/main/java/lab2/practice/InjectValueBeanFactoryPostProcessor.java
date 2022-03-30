package lab2.practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;

import java.util.Properties;


public class InjectValueBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        for (String beanDefinitionName : configurableListableBeanFactory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);

            Properties properties = new Properties();
            String beanClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> aClass = Class.forName(beanClassName);
                if (aClass.equals(MessagePrinter.class)) {
                    MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
                    PropertyValue propertyValue = propertyValues.getPropertyValue("message");
                    if (propertyValue == null) {
                        throw new RuntimeException("No message field name inside bean class");
                    }
                    TypedStringValue value = (TypedStringValue) propertyValue.getValue();
                    String newValue = PropertyRepository.get(value.getValue());
                    propertyValues.add("message", newValue);
                }
            } catch (ClassNotFoundException e) {
               throw new RuntimeException("No class with name " + beanClassName +" detected",e);
            }
        }
    }
}
