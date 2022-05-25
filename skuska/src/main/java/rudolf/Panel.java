package rudolf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Panel extends /*Canvas*/JPanel implements MouseListener, MouseMotionListener {

    private final ArrayList<Strom> les=new ArrayList<>();

    private Strom aktualnyStrom;

    private int xSur, ySur;

    private int dragX, dragY;

    private final Okno okno;

    private boolean mameStrom;

    public Panel(Okno okno) {
        super();
        this.okno = okno;
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    public void paintComponent(Graphics g){
        // toto sme doplnili
        super.paintComponent(g);
        for (Strom strom : les){
            if (strom != null){strom.kresli(g);}
        }
        if (aktualnyStrom != null){
            aktualnyStrom.kresli(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.xSur = e.getX();
        this.ySur = e.getY();

        if(okno.getButtonStlaceny()[0]){
            aktualnyStrom = new Strom(xSur,ySur,okno.getTerjasiaFarba(),0,0);
        }
        if(okno.getButtonStlaceny()[1]){
            for (Strom strom : les){
                if (strom != null && strom.clicked(xSur,ySur)){
                    aktualnyStrom=strom;
                    mameStrom=true;
                    dragX=e.getX()-aktualnyStrom.getXSur();
                    dragY=e.getY()-aktualnyStrom.getYSur();

                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        les.add(aktualnyStrom);
        repaint();
        aktualnyStrom = null;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        int dx=e.getX();
        int dy=e.getY();

        if(okno.getButtonStlaceny()[0]) {
            if (aktualnyStrom != null) {
                if (dx > xSur && dy > ySur) {
                    aktualnyStrom.setSirka(dx - xSur);
                    aktualnyStrom.setVyska(dy - ySur);
                }
                if (dx > xSur && dy < ySur) {
                    aktualnyStrom.setYSur(dy);
                    aktualnyStrom.setSirka(dx - xSur);
                    aktualnyStrom.setVyska(ySur - dy);
                }
                if (dx < xSur && dy > ySur) {
                    aktualnyStrom.setXSur(dx);
                    aktualnyStrom.setSirka(xSur - dx);
                    aktualnyStrom.setVyska(dy - ySur);
                }
                if (dx < xSur && dy < ySur) {
                    aktualnyStrom.setXSur(dx);
                    aktualnyStrom.setYSur(dy);
                    aktualnyStrom.setSirka(xSur - dx);
                    aktualnyStrom.setVyska(ySur - dy);
                }
            }
            //repaint();
        }

        if(aktualnyStrom!= null && okno.getButtonStlaceny()[1] && mameStrom){
            aktualnyStrom.setXSur(dx-dragX);
            aktualnyStrom.setYSur(dy-dragY);

        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
