import java.util.ArrayList;
import java.util.List;
public class AuTree {
	
	AuTree nodoizquierdo; 
	String data; 
	AuTree nododerecho; 
	
	public AuTree(String data){
		this.data= data;
		this.nododerecho=null; 
		this.nodoizquierdo=null;
	}
	
	public synchronized void insertarIzquierda(String data){
		if(nodoizquierdo==null){
			nodoizquierdo = new AuTree(data);
		}else{
			nodoizquierdo.insertarIzquierda(data);
		}
	}
	public synchronized void insertarDerecha(String data){
		if(nododerecho==null){
			nododerecho = new AuTree(data); 
		}else{
			nododerecho.insertarDerecha(data);
		}
	}
	public synchronized void insertar(String data){
		new AuTree(data);
	}
		
}
