import java.awt.Color;
import java.awt.Graphics;

public class PeakG
{

	int x;
	int y;
	int r = 10;
	int n;//numer wezla
	

	PeakG(int x, int y, int n)
	{
		this.x = x;
		this.y = y;
		this.n = n;
	}
	
	public void drawMe(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawOval(x,y,r,r);
	}
	
	public int getXfromN()
	{
		return x;
	}
	
	public int getYfromN()
	{
		return y;
	}
	
	
}