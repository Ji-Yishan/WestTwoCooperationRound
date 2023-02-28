import org.cooperation.pojo.Project;
import org.cooperation.pojo.User;
import org.cooperation.service.AdministratorService;
import org.cooperation.service.ProjectService;
import org.cooperation.service.UserService;
import org.cooperation.utils.UUID;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ProjectService projectServiceImpl=(ProjectService) context.getBean("ProjectServiceImpl");
        String pname="asef";
        String reason="asrtbarae";
        int need=110;
        String inId="134613461";
        String pid= UUID.getUUID();
        Project project=new Project(pid,pname,reason,need,inId);
        projectServiceImpl.addProject(project);



    }
}
