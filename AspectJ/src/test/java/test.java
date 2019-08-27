import com.sp.service.service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void test() {
        ApplicationContext addcon = new ClassPathXmlApplicationContext("applicationContext.xml");
        service service = addcon.getBean("service", service.class);
        service.demo();
    }

}
