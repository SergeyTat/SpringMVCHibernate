package SpringMVCHibernate.test;

import SpringMVCHibernate.config.AppConfig;
import SpringMVCHibernate.dao.UserDao;
import SpringMVCHibernate.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);
        userDao.saveUser("Сергей","Татаринов");




    }
}
