package graphics;

/**
 * @author :modige
 * @description :TODO
 * @date :2021/10/10 14:55
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 倒计时
 */
public class Counter {

    private JFrame frame;
    private JLabel jl0;

    private ScheduledThreadPoolExecutor scheduled;

    public static void main(String[] args) {
        new Counter().timer("2021-10-10 21:06:00");

    }

    /* String -> Date */
    private Date String2Date(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(dateStr);
            if (date.getTime() <= System.currentTimeMillis()) {
                jl0.setText("时间不能早于现在" + dateStr);
                throw new IllegalArgumentException("时间不能早于现在" + dateStr);
            }
            return date;
        } catch (ParseException e) {
            jl0.setText("时间格式传入错误,如yyyy-MM-dd HH:mm:ss，" + dateStr);
            throw new IllegalArgumentException("时间格式传入错误,如yyyy-MM-dd HH:mm:ss，" + dateStr);
        }
    }


    /* 倒计时的主要代码块 */
    public void timer(String dateStr) {
        long beginTime = System.currentTimeMillis()/1000;
        Date end = String2Date(dateStr);
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long time = (end.getTime() - 1 - System.currentTimeMillis()) / 1000;
                if (time <= 0) {
                    stopTimer();
                    jl0.setText("到达指定时间点" + dateStr);
                    return;
                }

                time = System.currentTimeMillis() / 1000;

                long hour = (time-beginTime) / 3600;
                long minute = ( (time-beginTime) - hour * 3600) / 60;
                long seconds =  (time-beginTime)- hour * 3600 - minute * 60;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<html><br>距离").append(dateStr).append("还有<br><br>")
                        .append(hour).append("时 ").append(minute).append("分 ").append(seconds).append("秒 ")
                        .append("</html>");


                stringBuilder.append("<html><br>距离").append(dateStr).append("还有<br><br>")
                        .append(hour).append("时 ").append(minute).append("分 ").append(seconds).append("秒 ")
                        .append("</html>");

                StringBuilder timer = new StringBuilder();
                timer.append("<html><br><h1>已经开始学习<br>").append(hour).append("时 ").append(minute).append("分 ").append(seconds).append("秒 ")
                        .append("</h1></br></html>");



//                jl0.setText(stringBuilder.toString());
//                StringBuilder sb2 = stringBuilder;



                jl0.setText(timer.toString());
            }
        }, 0, 1, TimeUnit.SECONDS);

    }

    /**
     * 停止定时器
     */
    private void stopTimer() {
        if (scheduled != null) {
            scheduled.shutdownNow();
            scheduled = null;
        }
    }

    /* 构造 实现界面的开发 GUI */
    public Counter() {
        scheduled = new ScheduledThreadPoolExecutor(2);
        init();
    }

    /* 组件的装配 */
    private void init() {
        frame = new JFrame("倒计时");
        jl0 = new JLabel();

        JPanel jp = new JPanel();
        jp.add(jl0);

        frame.add(jp);

        frame.setVisible(true);
        frame.setLocation(300, 400);
        frame.setSize(330, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
