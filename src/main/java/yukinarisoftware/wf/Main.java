package yukinarisoftware.wf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
