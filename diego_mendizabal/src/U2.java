public class U2 extends Rocket {

    public U2() {
        this.cost = 120;
        this.weight = 18000;
        this.capacity = 29000;
    }
    public boolean launch() {
        // if the launch was successful true
        double chance = Math.random()*100;
        return (4*(double)this.weight/this.capacity) <= chance;
    }

    public boolean land() {
        //if the land was successful true
        double chance = Math.random()*100;
        return (8*(double)this.weight/this.capacity) <= chance;
    }
}
