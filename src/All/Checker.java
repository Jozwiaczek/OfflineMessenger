package All;

public class Checker extends Thread {

    private String mess;
    private static String nick="";

    public Checker(String nick,String mess){
        if(this.nick.equals(nick)){
            this.mess = mess;
        } else {
            this.nick = nick;
            this.mess =  "\n["+nick+"]"+"\n"+mess;
        }
    }

    @Override
    public void run() {
        MyArrayList.getInstance().addMess(mess);
    }
}
