import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		String [] NoTerminal = null; 
		String [] Terminal = null; 
		String inicial = ""; 
		ArrayList<String> Prod = new ArrayList<String>(); 
		
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
			for(int i=0; i<Prod.size(); i++){
				if(Prod.get(i)!=null){
					System.out.println(Prod.get(i).toString());
				}
			}
			
		}catch( IOException e){
			System.out.println("Error");
		}
			
	}

}
