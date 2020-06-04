/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package antoniorojas.mission;

public class U1 extends Rocket{
    private final static int cost = 100;
    private final static double maxWeight = 18000;
    private final static double rockWeight = 10000;

    public U1() {
        super(rockWeight, maxWeight, cost);
    }

    @Override
    public boolean launch() {
        double random = Math.random();
        return random > (0.05 * (getWeight() / getMaxWeight()));
    }

    @Override
    public boolean land() {
        double random = Math.random();
        return random > (0.01 * (getWeight() / getMaxWeight()));
    }
}
