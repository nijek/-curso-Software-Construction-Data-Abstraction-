package test;

import model.Coin;

import org.junit.Before;
import org.junit.Test;
import java.lang.Math;

import static org.junit.Assert.assertTrue;



public class CoinTests {
    int RANGE = 100000;
    double E = 0.05;
    Coin coin;
    @Before
    public void setUp() {coin = new Coin();}

    @Test
    public void testCheckUnflippedCoin() {
        assertTrue(coin.checkStatus().matches("(Head|Tail)"));
    }
    @Test
    public void testCheckFlippedCoin() {
        coin.flip();
        assertTrue(coin.checkStatus().matches("(Head|Tail)"));

    }
    @Test
    public void testRandomness() {
        double h, t;
        h = t = 0;
        for (int i = 0; i < RANGE; i++) {
            coin.flip();
            if (coin.checkStatus().equals("Head")) {
                h = h + 1;
            } else if (coin.checkStatus().equals("Tail")) {
                t = t + 1;
            }
        }
        assertTrue(Math.abs((1.0 - h / t)) < E);
        }
    }



