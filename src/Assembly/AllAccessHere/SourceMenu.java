package Assembly.AllAccessHere;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SourceMenu {
	public int PrintOutSource() throws FileNotFoundException, UnsupportedEncodingException {
		int i = 1;
		PrintWriter writer = new PrintWriter("code.asm", "UTF-8");

		if (Main.MemoryAddress == 0)
			System.out.println("You haven't Write Code Yet.");
		for (i=1; i<=Main.MemoryAddress; i++) {
			System.out.println(i+ " " +Main.Source[i]);
			writer.println(i+ " " +Main.Source[i]);
		}
		writer.close();
		return 0;
	}
}
