import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Backbone {
	
	List<PeakG> listOfPeaks = new ArrayList<PeakG>();
	static final int width = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()-200;
	static final int height = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	int n; //liczba kolumn = 2*n; n-k�t
	int version;
	
	Backbone(int n, int v){
		this.n = n;
		this.version = v;
	}
	
	public void drawMe(Graphics g) {
		// TODO Auto-generated method stub
		int number = 0;
		int distanceX;
		int distanceY;
		int x;
		int y;
		switch(version){
			case 1:
				distanceX = width/(2*n+3);
				distanceY = height/4;
				x = 50;
				y = height/2-50;
				listOfPeaks.add(new PeakG(x,y,number));
				listOfPeaks.get(number++).drawMe(g);
				for (int i = 0; i < 2*n; i++){
					x += distanceX;
					y = 50;
					for(int j = 0; j < 4; j++){
						listOfPeaks.add(new PeakG(x,y,number));
						listOfPeaks.get(number++).drawMe(g);
						y += distanceY;
					}
				}
				x += distanceX;
				y = 50;
				for(int j = 0; j < 4; j++){
					listOfPeaks.add(new PeakG(x,y,number));
					listOfPeaks.get(number++).drawMe(g);
					y += distanceY;
				}
				x += distanceX;
				y = height/2-50;
				listOfPeaks.add(new PeakG(x,y,number));
				listOfPeaks.get(number++).drawMe(g);
				break;
			case 2:
				x = 300; y = 300;
				for (int i = 0; i < n; i++){
					listOfPeaks.add(new PeakG(x,y,number));
					listOfPeaks.get(number++).drawMe(g);
					Graphics2D g2d = (Graphics2D) g;
					g2d.rotate(2*Math.PI/n, width/2, height/2);
				}
				break;
			case 3:
				
				break;
			default:
				g.drawString("Zle dane, ziomek. No wez sie postaraj, gosciu", width/2, height/2);
		}
	}
	

}
