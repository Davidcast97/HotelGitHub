package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Diseno {
	public String TipoLetra,logo;
	public int tamanoTitulos, tamanoMedio, tamanoPequeno;
	public Image image;
	private JFrame frame;
	public Diseno(JFrame f){
		TipoLetra = "Arial";
		tamanoTitulos=23;
		tamanoMedio = 18;
		tamanoPequeno = 14;
		logo = new File("").getAbsoluteFile()+"\\src\\imagenes\\logop.jpg";
		frame = f;
        Image image = new ImageIcon(logo).getImage();
        cargarLogos();

	}
	
	public void cargarLogos()
	{
		
        Image image = new ImageIcon(logo).getImage();
        JLabel lblogo = new JLabel("");
		lblogo.setIcon(new ImageIcon(logo));
		lblogo.setBounds(425, 11, 50, 50);
		frame.getContentPane().add(lblogo);
        frame.setIconImage(image);
	}
}
