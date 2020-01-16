
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		 //ArrayList<String> lines = loadFile("words.txt");
		 
		 MyTrie mt = new MyTrie();
		 
		 String str = "thaitea";
		 mt.insert(str);
		 mt.insert("oolongtea");
		 mt.insert("greentea");
		 mt.printTrie();
		 System.out.println(mt.contains(str));
		 ArrayList<String> dict = mt.sort();
		 dict.forEach(System.out::println);
	}

	
	public static ArrayList<String> loadFile(String fileName)
	{
		
		ArrayList<String> lines = new ArrayList<String>();
        // This will reference one line at a time
        String line = null;
       
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
              
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {System.out.println("Error reading file '"  + fileName + "'");                  
            
        }
        
        return lines;
	}
}
