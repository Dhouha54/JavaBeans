package tp4;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class TestMonBeanVelo {

	public static void main(String[] args) {
		
		MonBeanVeto monBeanVeto = new MonBeanVeto();
		
		monBeanVeto.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO Auto-generated method stubr
				System.out.println("propretyChange1: valeur = "+ event.getNewValue());
			}
		});
		
		monBeanVeto.addVetoableChangeListener(new VetoableChangeListener() {
			public void vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
				System.out.println("vetoableChange : valeur = "+ event.getNewValue());
				if(((Integer) event.getNewValue()).intValue() > 100){
					throw new PropertyVetoException("Valeur superieur a 100", event);
				}
			}

		});
		monBeanVeto.addVetoableChangeListener(new VetoableChangeListener() {
			public void vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
				System.out.println("vetoableChange : valeur = "+ event.getNewValue());
				if(((Integer) event.getNewValue()).intValue() <50){
					throw new PropertyVetoException("Valeur inférieur a 50", event);
				}
			}

		});
		
		System.out.println("valeur = "+ monBeanVeto.getValeur());
		
		monBeanVeto.setValeur(60);
		
		System.out.println("valeur = "+ monBeanVeto.getValeur());
		
		monBeanVeto.setValeur(150);
		
		System.out.println("valeur = "+ monBeanVeto.getValeur());

		
	}

}