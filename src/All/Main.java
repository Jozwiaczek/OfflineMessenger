package All;

import java.awt.*;
import java.util.HashMap;

public class Main {

    public static HashMap<String,Integer> rateList = new HashMap<>();

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StartPanel();
            }
        });

    }
}
