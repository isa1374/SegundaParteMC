import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class Principal{
  public static void Main(String [] args)
  {

    String [] NoTerminales=null;
    String [] Terminales=null;
    String [] Inicial= null;
    ArrayList <String> Prod = new ArrayList <String>();
    try {
      File file=new File("C:/Users/Rogger/Desktop/mates/Gramatica/gram.txt");
      FileReader read=new FileReader(file);
      BufferedReader buff= new BufferedReader(read);
      LineNumberReader num= new LineNumberReader(buff);

      String line="";

      while(line!=null)
      {
        line=num.readLine();
        NoTerminales=line.split(",");

        if(num.getLineNumber>3)
        {
          String Cadena=num.read
          Prod.add(Regla())
        }

      }
    }
  }
}
