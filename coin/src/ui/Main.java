package ui;
import model.Coin;
import java.util.Objects;
import java.lang.Integer;

public class Main {
    public static void main(String[] args) {
        Coin coin = new Coin();
        double heads, tails;
        heads = tails = 0.0;
        for (double i = 0.0; i < 1000000000.0; i++) {
            String status = coin.checkStatus();
            //System.out.println(coin.checkStatus());
            coin.flip();
            if (Objects.equals(status, "Head")) {
                heads++;
            }
            else if (Objects.equals(status, "Tail")) {
                tails++;
            }

        }
        double total = heads + tails;
        System.out.printf("Total = %f, Heads: %f, Tails: %f \n",total, (heads / total), (tails / total) );
    }
}
