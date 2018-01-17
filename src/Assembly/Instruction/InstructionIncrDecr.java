package Assembly.Instruction;

import Assembly.AllAccessHere.Main;

public class InstructionIncrDecr {
	public void InstructionINCR() {
		if (Main.Operand1.equals("AX"))
			Main.ax += 1;
		else if (Main.Operand1.equals("BX"))
			Main.bx += 1;
		else if (Main.Operand1.equals("CX"))
			Main.cx += 1;
		else if (Main.Operand1.equals("DX"))
			Main.dx += 1;
	}
	
	public void InstructionDECR() {
		if (Main.Operand1.equals("AX"))
			Main.ax -= 1;
		else if (Main.Operand1.equals("BX"))
			Main.bx -= 1;
		else if (Main.Operand1.equals("CX"))
			Main.cx -= 1;
		else if (Main.Operand1.equals("DX"))
			Main.dx -= 1;
	}
}
