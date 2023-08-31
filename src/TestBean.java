package tp4;
import java.beans.PropertyChangeEvent;

import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JTextField; 
public class TestBean {
	
	

	public static void main(String[] args) {
		new TestBean();
		JFrame f = new JFrame();
		f.setTitle("welcome");
		JTextField tt = new JTextField();
		tt.setText("this");
		f.add(tt);
		f.show();
		f.setVisible(true);
	}
	public TestBean() {
		MonBean monBean = new MonBean();
	
		monBean.addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent event) {
				System.out.println("propertyChange1 : valeur = " + event.getNewValue());
			
		}});
		monBean.addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent event) {
				System.out.println("propertyChange2 : valeur = " + event.getNewValue());
			
		}});
	System.out.println("valeur = " + monBean.getValeur());
	monBean.setValeur(10);
	System.out.println("valeur = "+ monBean.getValeur());
	
	} }
