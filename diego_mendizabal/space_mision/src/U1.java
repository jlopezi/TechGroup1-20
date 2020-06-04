public class U1 extends Rocket {

    public U1() {
        this.cost = 100;
        this.weight = 10000;
        this.capacity = 18000;
    }
    public boolean launch() {
        // if the launch was successful true
        double chance = Math.random()*100;
        return (5*(double)this.weight/this.capacity) <= chance;
    }

    public boolean land() {
        double chance = Math.random()*100;
        return (1*(double)this.weight/this.capacity) <= chance;
    }
}
