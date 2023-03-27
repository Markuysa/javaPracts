package tenthTask;

import org.springframework.stereotype.Component;

@Component("Senior")
public class Senior implements Programmer{
    @Override
    public void doCoding() {
        System.out.println("senior's coding");
    }
}
