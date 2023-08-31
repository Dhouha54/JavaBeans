package tp4;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class MonBean implements  Serializable{
	protected int valeur;
	PropertyChangeSupport changeSupport;
	public MonBean() {
		valeur = 0;
		changeSupport = new PropertyChangeSupport(this);
	}
	public synchronized void setValeur(int val) {
		int oldValeur = valeur;
		valeur = val ;
		changeSupport.firePropertyChange("valeur", oldValeur, valeur);
	}
	public synchronized int getValeur( ) { return valeur ; }
	public synchronized void addPropertyChangeListener(PropertyChangeListener Listener) {
		changeSupport.addPropertyChangeListener(Listener);
	}
	public synchronized void removePropertyChangeListener(PropertyChangeListener Listener) {
		changeSupport.removePropertyChangeListener(Listener);
	}
}
