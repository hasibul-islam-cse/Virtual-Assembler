package Assembly.AllAccess;

/*
 * Author:~ Hasibul Islam
 * Department of Computer Science and Technology
 * Dhaka Polytechnic Institute
 * Contact: hasibul11225@yahoo.com
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
import Assembly.Instruction.MainHead;
import Assembly.Instruction.InstructionGenerator;

public class Main {
	private static Scanner sc;
	private static MainHead mainmenu;
	private static InstructionGenerator insgen;
	
	/* VARIABLE DECLARATION PART */
	static int MemoryAddress , PrimaryMemoryAddress, CodeGeneratorFlag;
	// Memory Address , Remember First Address, Flag for generate opcode and operand.
	static String Source[]; //Store Code in Memory for Debug or Edit if needed.
	static char SourceManipulate[]; //convert here program instruction to filter out from full code.
	public static String OpCode, Operand1, Operand2; //Store Opcode, Operand to Complete their task.
	public static int ax, bx, cx, dx;
	
	/* Method Declaration Part*/
	private static void CodeGenerator(){ 
		/*
		 * This Method Filter out Instruction
		 * to Complete Every Instruction task 
		 * from user's written program 
		 */
		for (int i=0; i<Source[MemoryAddress].length(); i++){
			if (CodeGeneratorFlag==0){
				if (SourceManipulate[i]==' '){
					CodeGeneratorFlag = 1;
					//Set Flag to 1 to fetch operand
				}
				else{
					if(OpCode.equals("null"))
						OpCode = Character.toString(SourceManipulate[i]);
					else
						OpCode = OpCode+SourceManipulate[i];
				}
			}
			else if (CodeGeneratorFlag == 1){
				if (SourceManipulate[i] == ' '){
					continue; 
					//Ignore Unexpected Space Character.
				}
				else if (SourceManipulate[i] == ','){
					CodeGeneratorFlag = 2; 
					//Flag is set to fetch second operand or data.
				}
				else{
					if (Operand1.equals("null"))
						Operand1 = Character.toString(SourceManipulate[i]);
					else
						Operand1= Operand1+SourceManipulate[i]; 
				}
			}
			else if (CodeGeneratorFlag == 2){
				if (SourceManipulate[i] == ' '){
					continue;
					//Ignore Unexpected Space Character.
				}
				else{
					if (Operand2.equals("null"))
						Operand2 = Character.toString(SourceManipulate[i]);
					else
						Operand2= Operand2+SourceManipulate[i];
				}
			}
		}
	}
	
	private static void ReadCode(){
		/*
		 * This method's task is to 
		 * Read Program code from user
		 * and Manipulate or store them.
		 */
		MemoryAddress = 1; //Default memory address
		PrimaryMemoryAddress = MemoryAddress; 
		//Starting Memory address stored to perform in different task
		Source = new String [MemoryAddress+5000]; 
		/*
		 * Instruction line Store ability Fixed
		 * For this, user can write 5k line of code
		 */
		SourceManipulate = new char [50];
		while(true){
			System.out.print(MemoryAddress+" ");//At first print out Memory Address
			
			Source[MemoryAddress] = sc.nextLine(); //Read code from Keyboard
			
			SourceManipulate = Source[MemoryAddress].toCharArray(); 
			//Copy String to Character Array to easily manipulate instruction
			CodeGeneratorFlag = 0; //Flag is set to 0 to fetch opcode
			
			OpCode = "null"; Operand1 = "null"; Operand2 = "null"; //Reset all Code Store
			CodeGenerator(); //Filter out Opcode and Operands from Instruction Line
			insgen.OpCodeGenerator();
			
			if (Source[MemoryAddress].equals("HLT")){
				/*
				 * if end of program written
				 * call HeaderMenu
				 * and Close reading Instruction of Program
				 */
				MainMenuTask(mainmenu.HeaderMain()); 
				break;
			}
			
			MemoryAddress += 1; //increment address
		}
	}
	
	private static int Run(){
		/*
		 * This Run Method Just Show the result
		 */
		System.out.println("AX: "+ax+"\tBX: "+bx+"\nCX: "+cx+"\tDX: "+dx);
		return 0;
	}
	
	private static int MainMenuTask(String HeaderInstruction){
		if (HeaderInstruction.equals("Assembly") || HeaderInstruction.equals("assembly") || HeaderInstruction.equals("ASSEMBLY")){
			/*
			 * If user want to write code
			 * or,
			 * Write instruction is Called
			 */
			ReadCode();
		}
		else if (HeaderInstruction.equals("Run") || HeaderInstruction.equals("run") || HeaderInstruction.equals("RUN")){
			Run();
			return MainMenuTask(mainmenu.HeaderMain());
		}
		else if (HeaderInstruction.equals("Exit") || HeaderInstruction.equals("exit") || HeaderInstruction.equals("EXIT")){
			/*
			 * IF User want to close 
			 * or, User want to opt out
			 * or, exit Instruction is Called
			 * Then Exit form this and 
			 * User can not write code
			 * or use it without open it again.
			 */
			JOptionPane.showMessageDialog(null, "Thank You.\non behalf of Computer Science.", "GoodBye", JOptionPane.PLAIN_MESSAGE);
			System.gc();
			return 0;
		}
		else{
			/*
			 * If menu instruction mismatched
			 * System will want menu again.
			 */
			JOptionPane.showMessageDialog(null, "Sorry,\nError Occured.", "Attention", JOptionPane.ERROR_MESSAGE);
			return MainMenuTask(mainmenu.HeaderMain());
		}
		return 0;
	}
	
	public static void main(String[] args){
		/*
		 * This is Main function
		 * Where the author of this 
		 * Interpreter can access Method.
		 */
		sc = new Scanner(System.in);
		mainmenu = new MainHead();
		insgen = new InstructionGenerator();
		
		MainMenuTask(mainmenu.HeaderMain()); //This is call and print Header Menu
	}
}
