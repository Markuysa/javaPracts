package tenthTask;

import org.springframework.stereotype.Component;

@Component("Junior")
public class Junior implements Programmer{
    @Override
    public void doCoding() {
        System.out.println("junior's coding");
    }
}
