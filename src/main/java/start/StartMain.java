package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.ylz.websocket")
public class StartMain {

    public static void main(String[] args) {
        SpringApplication.run(StartMain.class,args);
    }
}
