package tenthTask;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Programmer programmer = context.getBean(Junior.class);
        programmer.doCoding();

        programmer = context.getBean(Middle.class);
        programmer.doCoding();

        programmer = context.getBean(Senior.class);
        programmer.doCoding();
    }

}
