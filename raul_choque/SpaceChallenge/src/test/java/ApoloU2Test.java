package test.java;

import main.java.ApoloU2;
import org.junit.Assert;

public class ApoloU2Test {

    ApoloU2 apoloU2 = new ApoloU2();

    @org.junit.Test
    public void land_ReturnFalse_ItWillExplosion() {
        apoloU2.setChanceOfLandingCrash(1.0);
        apoloU2.setWeight(29);
        Assert.assertFalse(apoloU2.land());
    }

    @org.junit.Test
    public void land_ReturnTrue_ItWillWell() {
        apoloU2.setChanceOfLandingCrash(0.0);
        Assert.assertTrue(apoloU2.land());
    }

    @org.junit.Test
    public void launch_ReturnFalse_ItWillExplosion() {
        apoloU2.setChanceOfLaunchExplosion(1.0);
        apoloU2.setWeight(29);
        Assert.assertFalse(apoloU2.launch());
    }

    @org.junit.Test
    public void launch_ReturnTrue_ItWillWell() {
        apoloU2.setChanceOfLaunchExplosion(0.0);
        Assert.assertTrue(apoloU2.launch());
    }
}