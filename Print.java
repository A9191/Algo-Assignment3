import java.io.FileNotFoundException;

public class Print {
	
    // method for printing tree in dot language in a file by .gv format
	public static String printBST_B(int v1,int v2,int w) throws FileNotFoundException {
		  StringBuilder str = new StringBuilder();
		  str.append(String.format("node"+v1+"-> node"+v2+" [label = "+w+"];"));
		  System.out.println(str.toString());
		  return str.toString();
	}
}
