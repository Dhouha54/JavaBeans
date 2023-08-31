package tp4;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Fenetre extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre test = new Fenetre();
		test.setTitle("Mafenetre");
		test.setVisible(true);
	    test.setSize(400, 400);
        test.setLayout(new GridLayout(9, 2));
        MonBean calc1 = new MonBean();
        MonBeanVeto calc2 = new MonBeanVeto();
		calc1.setValeur(10);
		calc2.setValeur(2);
		JTextField f1 = new JTextField("x = " + calc1.getValeur());
		test.add(f1);
	

	
	}

}