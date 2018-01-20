              
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class kwbd extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String fileName =null;
	public String fileN;
	public File fi;
ImageIcon o1=new ImageIcon ("a.gif");
ImageIcon o2=new ImageIcon ("b.gif");
ImageIcon o3=new ImageIcon ("c.gif");
ImageIcon o4=new ImageIcon ("d.gif");
Image ii;
JFileChooser fc=new JFileChooser();
JLabel etyk1 = new JLabel("    Wybierz  plik :  ");
JButton w1 = new JButton ("Plik 1", o1); 
JButton w2 = new JButton("Plik 2",o2); 
JButton w3 = new JButton("Plik 3",o3); 
JButton w4 = new JButton("Plik 4",o4); 
JButton b1;
JTextField wyopinia1=new JTextField(10); //obiekty do wyswietlania danych
JTextField wyopinia2=new JTextField(10); // na ekranie typu JTextField
JTextField wyopinia3=new JTextField(10);
JTextField wyopinia4=new JTextField(10);
JTextField wyopinia5=new JTextField(10);
Dane dana = new Dane();
Graphics goff;
Image image;
int w, as, h;

float Nblack = 0;// liczba czarnych pikseli

float Nwhite = 0;// liczba bialych pikseli

float Ncalk = 0;// calkowita liczbapikseli
int odc = 0, odcmin = 0, odcmax = 0;
float por;

	Color colorodc;
BufferedImage bufObraz;
static Graphics g;
Dimension d;
Color jaki=Color.white;

class Dane
{ String opinia1,opinia2,opinia3,opinia4,opinia5;
Dane()
{ opinia1=opinia2=opinia3=opinia4=opinia5=null;}
}

  kwbd(String s) {    super(s);
  setSize(700,700);
  setDefaultCloseOperation(
          JFrame.EXIT_ON_CLOSE);
  Rysunek rys=new Rysunek();
 setContentPane(rys);
 
  JPanel panel=new JPanel();
	JPanel panel2=new JPanel();
	panel.setLayout(new GridLayout(1, 6 ) );
	panel2.setLayout(new GridLayout(25, 25));
 

	w1.addActionListener(this);
	w2.addActionListener(this); 
	w3.addActionListener(this); 
	w4.addActionListener(this);
	b1=new JButton("Otwórz plik");
	b1.addActionListener(this);
	
	panel.add(etyk1);
	panel.add(w1); 
	panel.add(w2);
	panel.add(w3);
	panel.add(w4);
	panel.add(b1);
	
	JLabel eopinia1= new JLabel("Nazwa pliku :",SwingConstants.LEFT);
	panel2.add(eopinia1); //wstawianie etykiety i
	panel2.add(wyopinia1); //pola tekstowego do wyswietlania do kontenera
	JLabel eopinia2= new JLabel("Liczba wszystkich pikseli",SwingConstants.LEFT);
	panel2.add(eopinia2);
	panel2.add(wyopinia2);
	JLabel eopinia3= new JLabel("Liczba pikseli czarnych",SwingConstants.LEFT);
	panel2.add(eopinia3);
	panel2.add(wyopinia3);
	JLabel eopinia4= new JLabel("Liczba pikseli bia³ych",SwingConstants.LEFT);
	panel2.add(eopinia4);
	panel2.add(wyopinia4);
	JLabel eopinia5= new JLabel("Porowatoœæ",SwingConstants.LEFT);
	panel2.add(eopinia5);
	panel2.add(wyopinia5);
	setLayout( new BorderLayout() );
	add( panel, BorderLayout.NORTH );
	add(panel2,BorderLayout.EAST);


	}

  public void init() 
  {
	  setSize(600,580);
   }
  
  class Rysunek extends JPanel {
  /**
	 * 
	 */
	private static final long serialVersionUID = -5814213699984268108L;

public void paintComponent(Graphics g)
  {
	  rysuj(g);
  }
  }
  
  public void rysuj (Graphics g) {
	  
	  
	  
Graphics2D g2D=(Graphics2D)g;

if (fileName!=null){
	

	ImageIcon icon = new ImageIcon(getClass().getResource(fileName));

	image = icon.getImage();
	
	g2D.drawImage(image, 10, 50, null);
	
	w = icon.getIconWidth();
	h = icon.getIconHeight();
	setSize(w+300,2*h+200);
Nblack=0;
Nwhite=0;
	bufObraz = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	Graphics2D grafika = bufObraz.createGraphics();
	
	grafika.drawImage(image,0, 0, null);

	{
		
		{
			odcmin = -1;
			odcmax = -1;
			for (int q = 0; q < w; q++) {
				for (int l = 0; l < h; l++) {
					int d = bufObraz.getRGB(q, l);
					// Color trt=new Color(d);
					if (d < odcmin) {
						odcmin = d;

					}

					if (d > odcmax) {
						odcmax = d;
					}

				}
			}
			as = (odcmin + odcmax) / 2;

		
		
		}
		
		
		
		
		
	}
	for (int q = 1; q < w; q++) {
		for (int l = 1; l < h; l++) {
			int d = bufObraz.getRGB(q, l);

			if (d < as) {
			g2D.setColor(Color.black);
			Nblack++;
		} 
			if (d>=as){
				Nwhite++;
				g2D.setColor(Color.white);
			}

			g2D.drawLine(q+10, l + 270, q+10, l + 270);
		}}
Ncalk=Nblack+Nwhite;
	dana.opinia2=new String("N= "+Ncalk);
	wyopinia2.setText(dana.opinia2); // które zastosowano do wyswietlenia tekstu	
	
	dana.opinia3=new String("N= "+Nblack);
	wyopinia3.setText(dana.opinia3); // 
	
	dana.opinia4=new String("N= "+Nwhite);
	wyopinia4.setText(dana.opinia4); // 
	float por = Nblack/Ncalk;
	dana.opinia5=new String("N= "+por);
	wyopinia5.setText(dana.opinia5); // 
}


  }
 
	public void odcinaj()
	{}
	 
  public void actionPerformed (ActionEvent evt) 
{ Object zrodlo = evt.getSource();
if (zrodlo==w1) 
{dana.opinia1= new String("a.png");
fileName="a.png";

}
if (zrodlo==w2) 
{dana.opinia1= new String("b.png");
fileName="b.png";;}

if (zrodlo==w3) 
{dana.opinia1= new String("c.png");
fileName="c.png";}

if (zrodlo==w4) 
{dana.opinia1= new String("d.png");
fileName="d.png";}

if (zrodlo==b1){
{ int wybor=fc.showOpenDialog(this);
if (wybor==JFileChooser.APPROVE_OPTION){
	File fi = fc.getSelectedFile();
 //fileName=new String(""+fi);
	fileN=fi.getAbsolutePath();
fileN.replaceAll("\\","/");
	
		

	fileName=fi.getName();
	//File fil=new File("C:\\Documents and Settings\\matii\\My Documents\\a.PNG");
//dana.opinia1= new String(fc.getName());

System.out.println(fileN);
}
}}




wyopinia1.setText(dana.opinia1);
dana.opinia2=new String("N="+Nblack);
wyopinia2.setText(dana.opinia2); 

 repaint();
}
 

public static void main(String argv[]) {
    kwbd f = new kwbd( "Analiza obrazu ze skaningowego mikroskopu elektronowego." );
	f.init();	
    f.show();



  
}}




