import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;



public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String [] NoTerminal = null; 
		String [] Terminal = null; 
		String inicial = ""; 
		ArrayList<String> Prod = new ArrayList<String>(); 
		
		File file = new File ("C:/Users/isha1_000/Documents/GitHub/SegundaParteMC/segunda-parte/src/Gram.txt");
		FileReader rd = new FileReader(file);
		BufferedReader bf = new BufferedReader(rd); 
		LineNumberReader ln = new LineNumberReader(rd);
		
		String line=""; 
		
		//Read and save lines
		while(line!=null){
			switch(ln.getLineNumber()){
			case 0: 
					line=ln.readLine(); 
					NoTerminal=line.split(",");
					
					break; 
			default: 
					break; 
			};
		};
		
		//Check of saved values 
		for(int i=0; i<NoTerminal.length; i++){
			System.out.println(NoTerminal[i].toString());
		}
		ln.close();
	}

}
