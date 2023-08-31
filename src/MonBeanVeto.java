package tp4;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

public class MonBeanVeto implements Serializable{
	protected int oldValeur;
	protected int valeur;

 	PropertyChangeSupport changeSupport;
 	VetoableChangeSupport vetoableSupport;
	public MonBeanVeto() {//lezem ykoun constructeure sans parametres
		valeur =0;
		oldValeur=0;
		changeSupport= new PropertyChangeSupport(this);
		vetoableSupport= new VetoableChangeSupport(this);}
	
	public synchronized void setValeur(int val) {
		 oldValeur = this.valeur;
		valeur = val;
		try {
			vetoableSupport.fireVetoableChange("valeur",oldValeur,valeur);
		}catch(PropertyVetoException e) {
			System.out.println("MonBean , un veto est emis:"+e.getMessage());
			valeur=oldValeur;
		}
		changeSupport.firePropertyChange("valeur",oldValeur ,valeur);
	}
	public synchronized int getValeur() {
		return valeur;
	}
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);}
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);}	
	public synchronized void addVetoableChangeListener(VetoableChangeListener listener) {
		vetoableSupport.addVetoableChangeListener(listener);}
	public synchronized void removeVetoableChangeListener(VetoableChangeListener listener) {
		vetoableSupport.removeVetoableChangeListener(listener);}	
}
	
