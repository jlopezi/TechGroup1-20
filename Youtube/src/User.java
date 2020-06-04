public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void notify(String message) {
        System.out.println(this.name + " notified with message: \n" + message);
    }
}
