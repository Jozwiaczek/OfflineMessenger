package All;

import Frames.NoweOknoFrame;
import org.w3c.dom.css.RGBColor;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class NoweOknoPanel extends JPanel implements ActionListener {

    private NoweOknoFrame df = new NoweOknoFrame();
    private JButton btnSend;
    private JTextField tfWrite;
    private JTextArea taMesseage;
    private JScrollPane scrollMesseage;
    private String nick;
    private JLabel lbNick;
    private JPanel pom = new JPanel();
    private HashMap<String,Integer> rateList = Main.rateList;
    private int sizeNick;
    private int red, blue, green;
    private Random rand;

    public NoweOknoPanel(String nick){
        this.nick=nick;

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        df.add(this);

        String[] oceny = new String[10];
        for(int i=0; i<10;++i)
            oceny[i]=(i+1)+"";

        df.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String rate =(String) JOptionPane.showInputDialog(
                        null,
                        "Ocena konwersacji",
                        "Jak oceniasz konwersacje?",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        oceny,
                        1
                );

                rateList.put(nick,Integer.parseInt(rate));
            }
        });

        lbNick = new JLabel("Imię: "+nick,JLabel.CENTER);
        lbNick.setPreferredSize(new Dimension(lbNick.getMinimumSize().width,30));
        lbNick.setFont(new Font("Lato", Font.PLAIN, 18));

        taMesseage = new JTextArea("");
        taMesseage.setEditable(false);

        sizeNick = nick.length()-1;

        rand = new Random();

        red = rand.nextInt(254);
        blue = rand.nextInt(255);
        green = rand.nextInt(255);

        if(nick.charAt(sizeNick)=='a') {
            taMesseage.setBackground(new Color(red,green,blue,200));
        }
        else {
            taMesseage.setBackground(new Color(red,green,blue,50));
        }


        taMesseage.setForeground(Color.WHITE);

        DefaultCaret caret = (DefaultCaret)taMesseage.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        tfWrite = new JTextField();
        tfWrite.setPreferredSize(new Dimension(400,50));

        btnSend = new JButton("Wyślji");
        btnSend.setFont(new Font("Lato",Font.PLAIN,18));
        btnSend.setPreferredSize(new Dimension(100,50));

        tfWrite.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n')
                  sendMess();
            }
        });


        scrollMesseage = new JScrollPane(taMesseage);

        add(lbNick,BorderLayout.NORTH);
        add(scrollMesseage,BorderLayout.CENTER);
        pom.add(tfWrite);
        pom.add(btnSend);
        add(pom,BorderLayout.SOUTH);
    }

    public void sound(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("gadugadu.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }catch(Exception x) {
            x.printStackTrace();
        }
    }

    public void sendMess(){
        if(!tfWrite.getText().isEmpty()){
            if(!taMesseage.getText().isEmpty()) {
                new Checker( nick, tfWrite.getText() + "\n").start();
                tfWrite.setText("");
                sound();
            }
            else{
                new Checker( nick, tfWrite.getText() + "\n").start();
                tfWrite.setText("");
                sound();
            }
        }
    }

    public JTextArea getTaMesseage(){
        return taMesseage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sendMess();
    }
}
