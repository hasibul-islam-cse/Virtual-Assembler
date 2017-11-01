package Assembly.Instruction;

import java.util.Scanner;

public class MainHead {
	private static Scanner sc;
	
	public String HeaderMain(){
		sc = new Scanner(System.in);
		String HeaderInstruction;
		System.out.println("\nAssembly    Source    Debug    Run    Help    Exit"); // Menu
		HeaderInstruction = sc.next(); // Input Menu as Instruction for Machine
		return HeaderInstruction; // return menu to complete menu task
	}
}
