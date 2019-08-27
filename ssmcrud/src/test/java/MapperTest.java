import com.ssm.mapper.DepartmentMapper;
import com.ssm.mapper.EmployeeMapper;
import com.ssm.pojo.Department;
import com.ssm.pojo.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.annotation.Resource;
import java.util.UUID;


public class MapperTest {


    @Test
    public void test(){
        ApplicationContext appcon = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapper departmentMapper =  appcon.getBean("departmentMapper" ,DepartmentMapper.class);
        EmployeeMapper employeeMapper = appcon.getBean(EmployeeMapper.class);
        SqlSession session = appcon.getBean(SqlSession.class);
        System.out.println(departmentMapper);
        System.out.println(employeeMapper);

        //1.插入部门
        //departmentMapper.insertSelective(new Department(null,"开发部"));
        //departmentMapper.insertSelective(new Department(null,"测试部"));
        System.out.println(departmentMapper.selectByPrimaryKey(1).toString());


        //2.插入员工
        //employeeMapper.insertSelective(new Employee(null, "artisanZhao", "M", "artisan323@163.com", 1));
        System.out.println(employeeMapper.selectByPrimaryKey(1).toString());

        //3.插入批量员工
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 100; i++){
            String uid = UUID.randomUUID().toString().substring(0, 5);
            mapper.insertSelective(new Employee(null, uid, "M", uid+"@163.xom", 1));
        }



    }
}
