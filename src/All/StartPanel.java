package All;

import Frames.RateFrame;
import Frames.StartFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartPanel extends JPanel implements ActionListener {

    private StartFrame df = new StartFrame();

    private JLabel lbTytul, lbOpis, lbOpis1, lbOpis2;
    private JButton btnNoweOkno, btnRate;

    public StartPanel(){
        setBackground(Color.WHITE);
        setLayout(null);



        lbTytul = new JLabel("Komunikator Offline");
        lbTytul.setBounds(120,20,400,100);
        lbTytul.setFont(new Font("Lato", Font.PLAIN, 40));

        lbOpis = new JLabel("Funkcjonalność programu:");
        lbOpis.setBounds(190,120,300,100);
        lbOpis.setFont(new Font("Lato", Font.PLAIN, 19));

        lbOpis1 = new JLabel("1.) Rozpocznij konwersację, klikając 'Nowe okno'.");
        lbOpis1.setBounds(80,170,400,100);
        lbOpis1.setFont(new Font("Lato", Font.PLAIN, 16));

        lbOpis2 = new JLabel("2.) Zobacz oceny konwersacji użytkowników, klikając 'Tabela ocen'.");
        lbOpis2.setBounds(80,220,500,100);
        lbOpis2.setFont(new Font("Lato", Font.PLAIN, 16));


        btnNoweOkno = new JButton("Nowe okno");
        btnNoweOkno.setBounds(190,360,240,50);
        btnNoweOkno.setFont(new Font("Lato", Font.PLAIN, 18));

        btnRate = new JButton("Tabela ocen");
        btnRate.setBounds(190,450,240,50);
        btnRate.setFont(new Font("Lato",Font.PLAIN,18));

        btnRate.addActionListener(a->{
            new RateFrame();
        });


        btnNoweOkno.addActionListener(this);

        add(lbTytul);
        add(lbOpis);
        add(lbOpis1);
        add(lbOpis2);
        add(btnNoweOkno);
        add(btnRate);
        df.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nick = JOptionPane.showInputDialog(null,"Wpisz swoje pełne Imię: ","Identyfikacja",JOptionPane.INFORMATION_MESSAGE);

        if(!nick.isEmpty()) {
            if (MyArrayList.getInstance().isEmpty()) {
                MyArrayList.getInstance().add(new NoweOknoPanel(nick));
            } else {
                NoweOknoPanel jp = new NoweOknoPanel(nick);
                MyArrayList.getInstance().add(jp);
                jp.getTaMesseage().setText(MyArrayList.getInstance().get(0).getTaMesseage().getText());
            }
        }
        else
            JOptionPane.showMessageDialog(null,"Musisz wpisać swoje Imię","Błąd",JOptionPane.ERROR_MESSAGE);
    }
}