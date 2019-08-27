import com.sp.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test(){
        ApplicationContext appcon = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = appcon.getBean("userService", UserService.class);
        //System.out.println(userService.show(1));

    }
}
