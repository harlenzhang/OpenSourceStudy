package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by harlenzhang on 16/8/10.
 */
public class SpringClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:application-context.xml");
        Person person = (Person)context.getBean("person");
        person.selfIntro();
    }
}
