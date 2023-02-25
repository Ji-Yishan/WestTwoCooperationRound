import org.cooperation.pojo.Project;
import org.cooperation.pojo.User;
import org.cooperation.service.ProjectService;
import org.cooperation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ProjectService projectServiceImpl=(ProjectService) context.getBean("ProjectServiceImpl");
        String pname="怨种大学生起不来床";
       List<Project> project=projectServiceImpl.selectProject(1,10);
       for (Project p:project){
           System.out.println(p);
       }


    }
}
