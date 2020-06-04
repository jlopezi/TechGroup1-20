import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        printEmptyLine();
        Channel cnn = new Channel("CNN");
        User roberto = new User("Roberto");
        User pedro = new User("Pedro");

        // Subscribe Users to CNN Channel
        cnn.subscribe(pedro);
        cnn.subscribe(roberto);

        // Simulate channel on live
        Timer onLiveTimer = new Timer();
        onLiveTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                cnn.setLive(true);
                // Unsubscribe to Pedro
                cnn.unsubscribe(pedro);
                printEmptyLine();
            }
        }, 5000);

        // Simulate new video
        Timer newVideoTimer = new Timer();
        newVideoTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                cnn.uploadVideo("Call of Duty free for PS Plus!");
            }
        }, 10000);
    }

    public static void printEmptyLine() {
        System.out.println('\n');
    }
}
