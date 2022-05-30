package model;
import java.util.Random;


public class Coin {
    private String status;
    private boolean isInitialized = false;
    //MODIFIES: this
    //EFFECTS: flip the coin
    public void flip() {
        isInitialized = true;
        Random rand = new Random();
        if (rand.nextInt() % 2 == 0) { //that will be head
            status = "Head";
        }
        else { // that will be tail
            status = "Tail";
        }
    }

    //EFFECTS: returns "Head" or "Tail" accordingly to the coin status
    public String checkStatus() {
        if (!isInitialized) {
            flip();
        }
        return status;
        }
    }

