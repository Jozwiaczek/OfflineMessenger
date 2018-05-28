package All;

import java.util.ArrayList;

public class MyArrayList extends ArrayList<NoweOknoPanel> {

    private static MyArrayList ourInstance = new MyArrayList();

    public static MyArrayList getInstance() {
        return ourInstance;
    }

    private MyArrayList() {

    }

    public void addMess(String mess){
        for(NoweOknoPanel i : this)
            i.getTaMesseage().append(mess);
    }
}
