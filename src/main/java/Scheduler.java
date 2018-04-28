import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    ScheduledExecutorService ses;
    MailProcessor mp;
    static FileHandler fh;
    static WordHandler wh;

    public Scheduler(){
        try {
            fh = new FileHandler();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ses = Executors.newSingleThreadScheduledExecutor();
        mp = new MailProcessor();
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                wh.sendWordsToFile();
                mp.sendEmail();
            }
        },0, 30, TimeUnit.SECONDS);
    }
}
