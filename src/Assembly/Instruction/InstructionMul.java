package Assembly.Instruction;

import Assembly.AllAccessHere.Main;

public class InstructionMul {
	public int MemoryAx() {
		if (Main.Operand2.equals("AX"))
			Main.ax *= Main.ax;
		else if (Main.Operand2.equals("BX"))
			Main.ax *= Main.bx;
		else if (Main.Operand2.equals("CX"))
			Main.ax *= Main.cx;
		else if (Main.Operand2.equals("DX"))
			Main.ax *= Main.dx;
		else {
			if (Character.isDigit(Main.Operand2.charAt(0)))
				Main.ax *= Integer.parseInt(Main.Operand2);
		}
		
		return 0;
	}
	
	public int MemoryBx() {
		if (Main.Operand2.equals("AX"))
			Main.bx *= Main.ax;
		else if (Main.Operand2.equals("BX"))
			Main.bx *= Main.bx;
		else if (Main.Operand2.equals("CX"))
			Main.bx *= Main.cx;
		else if (Main.Operand2.equals("DX"))
			Main.bx *= Main.dx;
		else {
			if (Character.isDigit(Main.Operand2.charAt(0)))
				Main.bx *= Integer.parseInt(Main.Operand2);
		}
		return 0;
	}
	
	public int MemoryCx() {
		if (Main.Operand2.equals("AX"))
			Main.cx *= Main.ax;
		else if (Main.Operand2.equals("BX"))
			Main.cx *= Main.bx;
		else if (Main.Operand2.equals("CX"))
			Main.cx *= Main.cx;
		else if (Main.Operand2.equals("Dx"))
			Main.cx *= Main.dx;
		else {
			if (Character.isDigit(Main.Operand2.charAt(0)))
				Main.cx *= Integer.parseInt(Main.Operand2);
		}
		
		return 0;
	}
	
	public int MemoryDx() {
		if (Main.Operand2.equals("AX"))
			Main.dx *= Main.ax;
		else if (Main.Operand2.equals("BX"))
			Main.dx *= Main.bx;
		else if (Main.Operand2.equals("CX"))
			Main.dx *= Main.cx;
		else if (Main.Operand2.equals("DX"))
			Main.dx *= Main.dx;
		else {
			if (Character.isDigit(Main.Operand2.charAt(0)))
				Main.dx *= Integer.parseInt(Main.Operand2);
		}
		
		return 0;
	}
	
	public void InstructionMUL() {
		if (Main.Operand1.equals("AX"))
			MemoryAx();
		else if (Main.Operand1.equals("BX"))
			MemoryBx();
		else if (Main.Operand1.equals("CX"))
			MemoryCx();
		else if (Main.Operand1.equals("DX"))
			MemoryDx();
	}
}
