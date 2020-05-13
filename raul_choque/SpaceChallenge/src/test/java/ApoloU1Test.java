package test.java;


import main.java.ApoloU1;
import org.junit.Assert;

public class ApoloU1Test {

    ApoloU1 apoloU1 = new ApoloU1();

    @org.junit.Test
    public void land_ReturnFalse_ItWillExplosion() {
        apoloU1.setChanceOfLandingCrash(1.0);
        apoloU1.setWeight(29);
        Assert.assertFalse(apoloU1.land());
    }

    @org.junit.Test
    public void land_ReturnTrue_ItWillWell() {
        apoloU1.setChanceOfLandingCrash(0.0);
        Assert.assertTrue(apoloU1.land());
    }

    @org.junit.Test
    public void launch_ReturnFalse_ItWillExplosion() {
        apoloU1.setChanceOfLaunchExplosion(1.0);
        apoloU1.setWeight(29);
        Assert.assertFalse(apoloU1.launch());
    }

    @org.junit.Test
    public void launch_ReturnTrue_ItWillWell() {
        apoloU1.setChanceOfLaunchExplosion(0.0);
        Assert.assertTrue(apoloU1.launch());
    }
}