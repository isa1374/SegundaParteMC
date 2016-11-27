import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.LineNumberReader;
import java.util.*;
import javax.swing.JOptionPane;
public class Principal{
	public static void main (String [] args){
		String [] NoTerminal=null;
		String[]Terminal=null;
		String inicial="";
		String prod="";

		try{
			class Arbol{
				String palabra;
				Arbol anterior;
				String pUsada;
				public Arbol(String palabra, Arbol anterior, String usada){
					this.palabra=palabra;
					this.anterior=anterior;
					this.pUsada=usada;
				}
				public String getPalabra(){
					return palabra;
				}
				public Arbol getAnterior(){
					return anterior;
				}
				public String getUsada(){
					return pUsada;
				}
				public void setPalabra(String p){
					this.palabra=p;
				}
				public void setAnterior(Arbol anterior){
					this.anterior=anterior;
				}
				public void setUsada(String usada){
					this.pUsada=usada;
				}
			}
			class Regla{
				String simbolo;
				ArrayList<String> pd;
				public Regla(String s){
					this.simbolo=s;
					pd=new ArrayList<String>();
				}
				public String getSimbolo(){
					return simbolo;
				}
				public void setSimbolo(String s){
					this.simbolo=s;
				}
				public ArrayList<String> getPD(){
					return pd;
				}
				public void AgregarPD(String p){
					pd.add(p);
				}
			}
			class Gram{
				ArrayList<Regla> reglas;
				String inicial;
				ArrayList<String> alfa;
				public Gram(ArrayList<Regla> reglas, String inicial, ArrayList<String> alfa){
					this.reglas=reglas;
					this.inicial=inicial;
					this.alfa=alfa;
				}
				public ArrayList<Regla> getReglas(){
					return reglas;
				}
				public String getInicial(){
					return inicial;
				}
				public ArrayList<String> getAlfabeto(){
					return alfa;
				}
				public void setInicial(String s){
					this.inicial=s;
				}
			}
			class Compute{
				Gram gram;
				String pb;
				Queue <Arbol> cl = new LinkedList<Arbol>();
				public Compute(Gram gram, String pb){
					this.gram=gram;
					this.pb=pb;
				}
				public String aceptar(){
	
						boolean seguir=true;
	
						ArrayList<Regla> reglas =gram.getReglas();
						cl.add(new Arbol(gram.getInicial(), null, gram.getInicial()));
						String respuesta="Cadena no aceptada";
	
						while(seguir){
							Arbol en= cl.remove();
							String ops=en.getPalabra();
							if(ops.equals(pb)){
								respuesta="Cadena aceptada";
								seguir=false;
								break;
							}
							int len=ops.length();
							for(int i=0; i<len; i++){
								String bef="";
								String aft="";
	
								char sim= ops.charAt(i);
								if(!gram.getAlfabeto().contains(sim)){
									if(len>1){
										bef=ops.substring(0,i);
										aft=ops.substring(i+1,len);
									}
									Regla ayu= new Regla("");
									for(int x= 0; x<reglas.size(); x++){
										if(reglas.get(x).getSimbolo().equals(sim)){
											ayu=reglas.get(x);
											break;
										}
									}
									if(ayu.getPD()!=null){
										ArrayList<String> pccs=ayu.getPD();
										for(int y=0; y<pccs.size(); y++){
											String helper=bef+pccs.get(y)+aft;
											if(bef.length()>pb.length()){
												seguir=false;
											}else{
												if(bef.equals(pb.substring(0,bef.length()))){
													cl.add(new Arbol(helper,en ,pccs.get(y)));
												}
											}
										}
										break;
									}
								}
							}
							if(cl.isEmpty()){
								seguir=false;
							}
						}
	
						return respuesta;
					}
				public String AutomataPila(Arbol a){
					String res="";
					String pbaux=pb;
					if(pbaux.equals("")){
						pbaux="lmd";
					}
	
					Stack<String> pila = new Stack<String>();
					Stack<String> total= new Stack<String>();
	
					Arbol aux=a;
					while(aux!=null){
						pila.push(aux.getUsada());
						aux=aux.getAnterior();
					}
	
					pila.push("P");
					total.push(pila.pop());
					res=res+"<q0,"+pbaux+","+imprimirtotal(total)+">"+"\n";
					total.push(pila.pop());
					res=res+"<q1,"+pbaux+","+imprimirtotal(total)+">"+"\n";
	
					while(!total.peek().equals("P")){
						if(!gram.getAlfabeto().contains(total.peek())){
							total.pop();
							pbaux=pbaux.substring(1, pbaux.length());
							if(pbaux.equals("")){
								pbaux="P";
							}
							res=res+"<q1,"+pbaux+","+imprimirtotal(total)+">"+"\n";
						}else{
							total.pop();
							if(!pila.isEmpty()){
								ArrayList<String> rv= reverse(pila.pop().split(""));
								total.addAll(rv);
								res=res+"q1,"+pbaux+","+imprimirtotal(total)+">"+"\n";
							}
						}
					}
					res=res+"<q2,"+"P"+imprimirtotal(total)+">"+"\n";
					return res;
				}
				public ArrayList<String> reverse(String[]arr){
					ArrayList<String> r= new ArrayList<String>();
					for(int m=arr.length-1; m>-1; m--){
						r.add(arr[m]);
					}
					return r;
				}
				public String imprimirtotal(Stack<String> s){
					String op="";
					for(String st:s){
						op=st+op;
					}
					return op;
				}
		}
		//Declaración
		File file = new File("C:/Users/isha1_000/Documents/GitHub/SegundaParteMC/segunda-parte/src/Gram.txt");
		FileReader rd= new FileReader(file);
		LineNumberReader ln= new LineNumberReader(rd);

		String line="";

		ArrayList<Regla> reglas= new ArrayList<Regla>();
		ArrayList <String> alfabeto = new ArrayList<String>();

						//Read and save lines
								while(line !=null){
									switch(ln.getLineNumber()){
									case 0:
											line=ln.readLine();
											NoTerminal=line.split(",");
											for(int o=0; o<NoTerminal.length;o++){
												reglas.add(new Regla(NoTerminal[o].toString()));
											}
											break;
									case 1:
											line = ln.readLine();
											Terminal = line.split(",");
											for(int i=0; i<Terminal.length; i++){
												alfabeto.add(Terminal[i].toString());
											}
											break;
									case 2:
											line = ln.readLine();
											inicial = line;
											break;
									default:
											line = ln.readLine();
											if(line!=null){
												String[]aux=line.split("->");
												prod=aux[1].toString();
												if(prod.equals("lmd")){
													prod="";
												}
												for(int t=0; t<reglas.size(); t++){
													Regla si=reglas.get(t);
													if(si.getSimbolo().equals(aux[0])){
														si.AgregarPD(prod);
														break;
													}
												}
											}

											break;
									}
								}
						Gram g= new Gram(reglas, inicial, alfabeto);
						String cadena= JOptionPane.showInputDialog("Ingrese la cadena a probar");
						boolean acpt=true;

						for(int il=0; il<cadena.length(); il++){
							if(!alfabeto.contains(cadena.charAt(il)+"")){
								acpt=false;
								break;
							}
						}
						if(acpt){
							Compute cm=new Compute(g,cadena);
							System.out.println(cm.aceptar());
						}else{
							System.out.println("Cadena no aceptada. Los simbolos en la cadena no pertenecen al alfabeto");
						}
						ln.close();
		}catch(IOException e){
			System.out.println("Error");
		}
	}
}