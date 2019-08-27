import com.sp.service.Impl.MenuServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test(){
        ApplicationContext appcon = new ClassPathXmlApplicationContext("applicationContext.xml");
//        String[] names =  appcon.getBeanDefinitionNames();
//        for (String e: names){
//            System.out.println(e);
//        }
        MenuServiceImpl menuService = (MenuServiceImpl) appcon.getBean("menuServiceImpl");
        System.out.println(menuService.show());

    }
}
