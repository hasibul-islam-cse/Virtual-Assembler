package Assembly.Instruction;

import Assembly.AllAccess.Main;
import Assembly.Instruction.InstructionMov;

public class InstructionGenerator {	
	InstructionMov insmov = new InstructionMov();
	
	public String OpCodeGenerator(){
		/*
		 * This Method is Used to 
		 * Filter Out Instruction Code
		 */
		if (Main.OpCode.equals("MOV"))
			insmov.InstructionMOV();
		return null;
	}
}
