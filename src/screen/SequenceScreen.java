package screen;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class SequenceScreen extends JPanel{

	private Window w;
	
	
	/**	public enum CTRL{
		NEXT,
		PREVIOUS
	}
	private CTRL option;    
	private Dimension SIZE_PANEL            =       new Dimension(1000,1000);
	private List<BufferedImage> imagenList  =       new ArrayList<BufferedImage>();    
	private int index                       =       0;//imagen actual
	private Timer timer;
	private int speed                       =       10;//en milisegundos
	private int x                           =       0;
	private int y                           =       0;
	private int size_cut                    = -10;
	private boolean inTransition            =       false;
	private Window w;

	/** Constructor de clase */


	public SequenceScreen(Window w){
		super(); 
		this.w = w;

		/**setSize(SIZE_PANEL);
		setVisible(true); 

		//se carga imagenes en memoria
		try {
			imagenList.add(0, ImageIO.read(this.getClass().getResource("C:\\Users\\1DAM\\Documents\\RepositorioDiogenes\\proyecto_Diogenes\\img\\fondo1.png")));
			imagenList.add(1, ImageIO.read(this.getClass().getResource("C:\\Users\\1DAM\\Documents\\RepositorioDiogenes\\proyecto_Diogenes\\img\\fondo1.png")));           
		} catch (IOException ex) {
			System.err.println( ex.getMessage() );
		}
	}

	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 =(Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);                    
		drawTransition(g2);
	}

	/**
		 * pinta el efecto de transicion
		 */

	}
	
}

	/*public void drawTransition(Graphics2D g2)
	{
		//imagen actual
		g2.drawImage(imagenList.get(index), x, y, getWidth(), getHeight(), null);        
		size_cut +=10;//incrementa
		if( size_cut>0 )
		{        
			//obtiene coordenadas de recorte
			int px = getWidth()/2-size_cut/2;
			int py = getHeight()/2-size_cut/2;
			if( px >= 0 )
			{                
				int sindex=0;
				if(option == CTRL.NEXT)                                    
					sindex = ((index+1) < imagenList.size())?index+1:0;                    
				else if(option == CTRL.PREVIOUS)
					sindex = ((index-1) >= 0)?index-1:imagenList.size()-1;                                    
				//extrae recorte de imagen siguiente/anterior y dibuja
				BufferedImage recorte = imagenList.get(sindex).getSubimage(px,py,size_cut,size_cut);                        
				g2.drawImage(recorte, px, py, recorte.getWidth(), recorte.getHeight(), null);                       
				g2.dispose();
			}else{
				timer.stop();
				inTransition=false;
				g2.dispose();
				if(option == CTRL.NEXT)
				{
					index+=1;
					if(index>=imagenList.size()) index=0;                    
				}                
				if(option == CTRL.PREVIOUS)
				{
					index-=1;
					if(index<0) index=imagenList.size()-1;
				}
				repaint();
				size_cut=-10;//reinicia 
			}
		}
	}


	/**
	 * @param CTRL option
	 */

	/**
	public void play(CTRL option)
	{   
		this.option = option;    
		inTransition = !inTransition;
		ActionListener animation = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				repaint();//refresca panel
			}
		};        

		if(inTransition)
		{
			if(timer!=null)timer.stop();
			timer = new Timer(speed,animation);
			timer.start();       
		}
		//else timer.stop();

	}

}//JPanelPPT:end
	 */ 

