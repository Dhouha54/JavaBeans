package tp4;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

public class Documentation {
	BeanInfo bi;
	public BeanInfo getBi() {
		return bi;
	}
	public void setBi(BeanInfo bi) {
		this.bi = bi;
	}
	public Documentation()  {
		try{
		Class<?> monBeanClasse = Class.forName("tp4.MonBeanVeto");
		 bi = Introspector.getBeanInfo(monBeanClasse, monBeanClasse.getSuperclass());

		BeanDescriptor unBeanDescriptor = bi.getBeanDescriptor();
		
		System.out.println("Nom de bean : "+ unBeanDescriptor.getName());
		System.out.println("Classe de bean : "+ unBeanDescriptor.getBeanClass());
		System.out.println("");
		}catch(Exception e) {System.out.println("problem");}

	}
public void getPropretDescriptor() {
	PropertyDescriptor[] propretyDescriptor = this.bi.getPropertyDescriptors();
	
	for(int i = 0; i< propretyDescriptor.length; i++) {
		System.out.println(" Nom proprieté : " + propretyDescriptor[i].getName() );
		System.out.println(" Type proprieté : " + propretyDescriptor[i].getPropertyType() );
		System.out.println(" Getter proprieté : " + propretyDescriptor[i].getReadMethod() );
		System.out.println(" Setter proprieté : " + propretyDescriptor[i].getWriteMethod() );

      	}
}
public void getMethodes() {
	MethodDescriptor[] methodDescriptor;
	methodDescriptor = bi.getMethodDescriptors();
	
	for(int i = 0; i< methodDescriptor.length; i++) {
		System.out.println(" methode : " + methodDescriptor[i].getName() );
		

	}
}
public void getEvents() {
	
	 EventSetDescriptor[] unEventSetDescriptor = bi.getEventSetDescriptors();
	
	for(int i = 0; i< unEventSetDescriptor.length; i++) {
		System.out.println(" event : " + unEventSetDescriptor[i].getName() );
		System.out.println(" method add event : " + unEventSetDescriptor[i].getAddListenerMethod() );  
		System.out.println(" method remove event : " + unEventSetDescriptor[i].getRemoveListenerMethod() );
		MethodDescriptor[] methodDescriptor;
		methodDescriptor = unEventSetDescriptor[i].getListenerMethodDescriptors();
		for(int j = 0; j< methodDescriptor.length; j++) {
			System.out.println(" event type : " + methodDescriptor[j].getName() );
		}

	}
}


}