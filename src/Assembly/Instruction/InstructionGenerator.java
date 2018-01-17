package Assembly.Instruction;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import Assembly.AllAccessHere.Main;
import Assembly.Instruction.InstructionMov;

public class InstructionGenerator {	
	InstructionMov insmov = new InstructionMov();
	InstructionAdd insadd = new InstructionAdd();
	InstructionSub inssub = new InstructionSub();
	InstructionMul insmul = new InstructionMul();
	InstructionDiv insdiv = new InstructionDiv();
	InstructionIncrDecr insincdec = new InstructionIncrDecr();
	
	public String OpCodeGenerator() throws FileNotFoundException, UnsupportedEncodingException{
		/*
		 * This Method is Used to 
		 * Filter Out Instruction Code
		 */
		if (Main.OpCode.equals("MOV"))
			insmov.InstructionMOV();
		else if (Main.OpCode.equals("ADD"))
			insadd.InstructionADD();
		else if (Main.OpCode.equals("SUB"))
			inssub.InstructionSUB();
		else if (Main.OpCode.equals("MUL"))
			insmul.InstructionMUL();
		else if (Main.OpCode.equals("DIV"))
			insdiv.InstructionDIV();
		else if (Main.OpCode.equals("INCR"))
			insincdec.InstructionINCR();
		else if (Main.OpCode.equals("DECR"))
			insincdec.InstructionDECR();
		return null;
	}
}
