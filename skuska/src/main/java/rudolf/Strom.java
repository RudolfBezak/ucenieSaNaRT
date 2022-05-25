package rudolf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Ellipse2D;

@Getter
@AllArgsConstructor
@Setter

public class Strom {
    private int xSur;
    private int ySur;
    private Color farba;
    private int vyska;
    private int sirka;

    public void kresli(Graphics g){
        g.setColor(this.farba);
        g.fillOval(this.xSur,this.ySur,this.sirka,(int)((this.vyska/3.0)*2.0));
        g.fillRect((int)(this.xSur+sirka/3.0),(int)(this.ySur+vyska/3.0),(int)(this.sirka/3.0),(int)((this.vyska/3)*2.0));
        //g.setColor(Color.BLACK);
    }

    public boolean clicked(int clickX, int clickY) {
        Rectangle rect = new Rectangle(this.xSur + (int) (this.sirka * (1.0/3.0)), this.ySur + (int) (vyska * 0.5), (int) (sirka * (1.0/3.0)), (int) (vyska * 0.5));
        Ellipse2D ellipse = new Ellipse2D.Double(this.xSur,this.ySur,this.sirka,(int)((this.vyska/3.0)*2.0));
        return rect.contains(clickX, clickY) || ellipse.contains(clickX, clickY);
    }

}
