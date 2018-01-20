import javax.swing.*;


import java.awt.event.*;
import java.awt.*;



//////////////////









public class Otworz extends JFrame implements ActionListener
{ JFileChooser fc=new JFileChooser();
JButton b1,b2,b3;
Otworz() //konstruktor
{ super("Dialogi");
FlowLayout flow=new FlowLayout(FlowLayout.CENTER,10,10);
getContentPane().setLayout(flow); super.setSize(400,100);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
String[] etykieta={"Otwórz plik","Zapisz plik","Wybierz kolor"};
b1=new JButton("Otwórz plik"); b1.addActionListener(this);
b2=new JButton(etykieta[1]); b2.addActionListener(this);
b3=new JButton(etykieta[2]); b3.addActionListener(this);
getContentPane().add(b1);
getContentPane().add(b2);
getContentPane().add(b3); 
setVisible(true);
} //koniec konstruktora dialogi 12

public void actionPerformed(ActionEvent e)
{Object ob1=e.getSource();
if (ob1==b1)
{ int wybor=fc.showOpenDialog(this);
if (wybor==JFileChooser.APPROVE_OPTION)
pisz("Otwieram plik "+ fc.getSelectedFile());}
if (ob1==b2)
{ int wybor=fc.showSaveDialog(this);
if (wybor==JFileChooser.APPROVE_OPTION)
pisz("Zapisuje plik "+ fc.getSelectedFile()); }
if (ob1==b3)
{ Color kol=JColorChooser.showDialog(this,"Wybierz kolor",
getBackground());
if (kol==null) return;
pisz("Wybrany kolor: "+ kol); setBackground(kol);
} } //koniec metody actionPerformed

void pisz(String s)
{ JOptionPane.showMessageDialog(this,s,"Komunikat",
JOptionPane.INFORMATION_MESSAGE);
}
public static void main(String [] args)
{ Otworz d=new Otworz();
}
} //koniec klasy dialogi