package rudolf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Klikac implements ActionListener {

    Okno okno;
    int farba;
    public Klikac(Okno okno) {
        this.farba = 1;
        this.okno = okno;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("stromy")){
            this.okno.buttonStlaceny[0] = true;
            this.okno.buttonStlaceny[1] = false;
            this.okno.buttonStlaceny[2] = false;
            this.okno.getLejbel().setText("kreslenie");

        }
        if (e.getActionCommand().equals("presuvanie")){
            this.okno.buttonStlaceny[0] = false;
            this.okno.buttonStlaceny[1] = true;
            this.okno.buttonStlaceny[2] = false;
            this.okno.getLejbel().setText("presun");

        }
        if (e.getActionCommand().equals("dalsia farba")){
            this.okno.getLejbel().setBackground(ziskajFarbu());

        }

    }
    public Color ziskajFarbu(){
        switch(farba) {
            case 0:
                farba = 1;
                okno.setTerjasiaFarba(Color.RED);
                return Color.RED;
            case 1:
                farba = 2;
                okno.setTerjasiaFarba(Color.green);
                return Color.GREEN;
            case 2:
                farba = 0;
                okno.setTerjasiaFarba(Color.blue);
                return Color.BLUE;
        }
        return Color.BLACK;
    }
}
