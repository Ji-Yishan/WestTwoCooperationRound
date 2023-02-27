import org.cooperation.pojo.Project;
import org.cooperation.pojo.User;
import org.cooperation.service.AdministratorService;
import org.cooperation.service.ProjectService;
import org.cooperation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        AdministratorService administratorImpl=(AdministratorService) context.getBean("AdministratorServiceImpl");
        String username="a";
        String pname="yes";
        int audit=0;
        administratorImpl.auditProject(pname,username,audit);




    }
}
