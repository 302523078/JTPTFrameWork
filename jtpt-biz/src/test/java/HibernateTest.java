import com.hisense.jtpt.entity.SysUser;
import com.hisense.jtpt.service.SysUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByName;

import java.util.List;

/**
 * Created by bcm on 15-9-30.
 */
//@SpringApplicationContext({"spring.xml","spring-druid.xml","spring-hibernate.xml"})
public class HibernateTest {
//    @SpringBeanByName
    SysUserService sysUserService;

      @Test
      public  void TEST(){

          ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml","spring-druid.xml","spring-hibernate.xml");
          sysUserService  = (SysUserService) ac.getBean("sysUserServiceImpl");
        List<SysUser> list = (List<SysUser>) sysUserService.find("select t from SysUser t");

        System.out.print(list.size());

      }
}
