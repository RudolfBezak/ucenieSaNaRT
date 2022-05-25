package rudolf;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class Okno {
     private JFrame frame;
     private JPanel nastavenia;

     private JButton[] butony;

     private JLabel lejbel;

     private Panel kresPlocha;

     boolean[] buttonStlaceny;

     private Color terjasiaFarba;

    public Okno() {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(720,720);

        this.nastavenia = new JPanel();
        this.nastavenia.setLayout(new GridLayout(1,4));

        this.frame.add(this.nastavenia,"North");

        butony = new JButton[3];
        buttonStlaceny = new boolean[3];
        buttonStlaceny[0] = true;

        butony[0] = new JButton("stromy");
        butony[1] = new JButton("presuvanie");
        butony[2] = new JButton("dalsia farba");

        for (JButton jButton : butony) {
            jButton.addActionListener(new Klikac(this));
            this.nastavenia.add(jButton);
        }

        this.lejbel = new JLabel("kreslenie");
        this.lejbel.setOpaque(true);
        this.lejbel.setBackground(Color.RED);

        this.lejbel.setHorizontalAlignment(SwingConstants.CENTER);
        this.lejbel.setVerticalAlignment(SwingConstants.CENTER);

        this.nastavenia.add(this.lejbel);

        this.terjasiaFarba = Color.RED;
        this.kresPlocha = new Panel(this);

        this.frame.add(this.kresPlocha, "Center");














        this.frame.setVisible(true);
    }
}
