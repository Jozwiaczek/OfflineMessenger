package Frames;

import All.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class RateFrame extends JFrame {

    private Object dane[][]=new Object[Main.rateList.size()][2];
    private String[] colName = {"Imię","Ocena Konwersacji"};
    private JTable table;
    private JScrollPane scrollPane = new JScrollPane();

    public RateFrame(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,600);
        setBackground(Color.WHITE);

        int i=0;
        for (Map.Entry<String,Integer> e:Main.rateList.entrySet()){
            dane[i][0]=e.getKey();
            dane[i][1]=e.getValue();
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(dane,colName);
        table = new JTable(model);
        table.setModel(model);

        scrollPane.setViewportView(table);
        add(scrollPane);

        setVisible(true);
    }
}
