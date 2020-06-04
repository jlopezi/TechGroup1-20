import java.util.ArrayList;

public class Channel {
    private ArrayList<Observer> observers;
    private ArrayList<String> videos;
    private String name;
    private boolean live;

    public Channel(String name) {
        this.observers = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.name = name;
        this.live = false;
    }

    public void setLive(boolean live) {
        this.live = live;
        if (live) {
            this.notify(this.name + " on live now!");
        }
    }

    public void uploadVideo(String video) {
        this.videos.add(video);
        this.notify(this.name + " uploaded a new video #" + video);
    }

    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    protected void notify(String message) {
        for (Observer observer : this.observers) {
            observer.notify(message);
        }
    }
}
