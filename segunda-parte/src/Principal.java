import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

import com.google.common.collect.*;


public class Principal {

	public static void main(String[] args) {
		
		String [] NoTerminal = null; 
		String [] Terminal = null; 
		String inicial = ""; 
		ArrayList<String> Prod = new ArrayList<String>(); 
		ListMultimap<String,String> gramatica = ArrayListMultimap.create(); 
		
		
		
		try{
			File file = new File ("C:/Users/isha1_000/Documents/GitHub/SegundaParteMC/segunda-parte/src/Gram.txt");
			FileReader rd = new FileReader(file);
			LineNumberReader ln = new LineNumberReader(rd);
			
			String line=""; 
			
			//Read and save lines
			while(line !=null){
				switch(ln.getLineNumber()){
				case 0: 
						line=ln.readLine(); 
						NoTerminal=line.split(",");
						break; 
				case 1: 
						line = ln.readLine(); 
						Terminal = line.split(",");
						break;
				case 2: 
						line = ln.readLine(); 
						inicial = line; 
						break;
				default: 
						line = ln.readLine();
						Prod.add(line);
						break; 
				}
			};
			ln.close();
			
			//Check values in ArrayList 
			/*
			for(int i=0; i<Prod.size(); i++){
				if(Prod.get(i)!=null){
					System.out.println(Prod.get(i).toString());
				}
			}
			*/
			
			//Lógica arbol 
			class Arbol{
				private AuTree root; 
				public Arbol(){
						root=null;
					}
				public synchronized void insertNodo(String data){
						if(root==null){
							root = new AuTree(data);
						}else{
							root.insertar(data);
						}
					}
				public synchronized void inDer(String data){
						if(root.nododerecho==null){
							root.insertarDerecha(data);
						}
					}
				public synchronized void inIz(String data ){
					if(root.nodoizquierdo==null){
						root.insertarIzquierda(data);
					}
				}
				public String getNodo(){
					return root.data.toString();
				}
				public String getNodoDer(){
					return root.nododerecho.data.toString();
				}
				public String getNodoIz(){
					return root.nodoizquierdo.data.toString();
				}
				
			}
			
			//test tree
			/*
			Arbol tree= new Arbol();
			String data;
			
			data="A";
			String data2="a"; 
			String data3="b";
			
			tree.insertNodo(data);
			tree.inDer(data2);
			tree.inIz(data3);
			
			//Check values inside tree
			
			System.out.println("Nodo raiz " + tree.getNodo()); 
			System.out.println("Nodo derecho " + tree.getNodoDer());
			System.out.println("Nodo izquierdo " + tree.getNodoIz());
			*/
			
			//Multimap tested 
			String []aux;
			for(int i=0; i<Prod.size(); i++){
				if(Prod.get(i)!=null){
					aux=Prod.get(i).split("->");
					gramatica.put(aux[0].toString(), aux[1].toString());
					aux=null;
				}
			}
			
			//Checar 
			String palabra = "aaabb";
			System.out.println(palabra);
			StringBuilder pb = new StringBuilder(palabra);
			char [] word = palabra.toCharArray();
			String ay1="";
			pb.deleteCharAt(0);
			ArrayList <String> posibles= new ArrayList <String>();
			Multimap<String,String> invertedMultimap= Multimaps.invertFrom(gramatica, ArrayListMultimap.<String,String>create());
			System.out.println(invertedMultimap.values().toString());
			System.out.println(invertedMultimap.get("a").toString());
			
			ay1= invertedMultimap.get("a").toString()+pb;
			System.out.println(ay1);
			posibles.add(ay1);
			System.out.println(posibles.get(0).toString());
			
			
			
			
			
		}catch( IOException e){
			System.out.println("Error");
		}
			
	}



}
