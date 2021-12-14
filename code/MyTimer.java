import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MyTimer implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Date now = new Date();
        System.out.println("at the tone,the time is "+now);
        Toolkit.getDefaultToolkit().beep();
    }
}
