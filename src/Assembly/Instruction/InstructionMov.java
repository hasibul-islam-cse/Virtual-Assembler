package Assembly.Instruction;

import Assembly.AllAccess.Main;

public class InstructionMov {
	public int MemoryAx(){
		/*
		 * Operation for Memory AX;
		 * only for memory ax.
		 */
		if (Main.Operand2.equals("BX"))
			Main.ax = Main.bx; //If Second Operand is Bx.
		else if (Main.Operand2.equals("CX"))
			Main.ax = Main.cx; //If Second Operand is Cx.
		else if (Main.Operand2.equals("DX"))
			Main.ax = Main.dx; //If Second Operand id Dx.
		else{
			if (Character.isDigit(Main.Operand2.charAt(0)))
				Main.ax = Integer.parseInt(Main.Operand2);
			/* If The number is Numeric Data then Store to First Operand */
		}
		return 0;
	}
	public int MemoryBx(){
		if (Main.Operand2.equals("AX"))
			Main.bx = Main.ax;
		else if (Main.Operand2.equals("CX"))
			Main.bx = Main.cx;
		else if (Main.Operand2.equals("DX"))
			Main.bx = Main.dx;
		else {
			if (Character.isDigit(Main.Operand2.charAt(0)))
				Main.bx = Integer.parseInt(Main.Operand2);
		}
		return 0;
	}
	public int MemoryCx(){
		if (Main.Operand2.equals("AX"))
			Main.cx = Main.ax;
		else if (Main.Operand2.equals("BX"))
			Main.cx = Main.bx;
		else if (Main.Operand2.equals("DX"))
			Main.cx = Main.dx;
		else {
			if (Character.isDigit(Main.Operand2.charAt(0)))
				Main.cx = Integer.parseInt(Main.Operand2);
		}
		return 0;
	}
	public int MemoryDx(){
		if (Main.Operand2.equals("AX"))
			Main.dx = Main.ax;
		else if (Main.Operand2.equals("BX"))
			Main.dx = Main.bx;
		else if (Main.Operand2.equals("CX"))
			Main.dx = Main.cx;
		else {
			if (Character.isDigit(Main.Operand2.charAt(0)))
				Main.dx = Integer.parseInt(Main.Operand2);
		}
		return 0;
	}
	
	public void InstructionMOV(){
		/*
		 * this method is created for
		 * Filter out Memory for opertion
		 */
		if(Main.Operand1.equals("AX"))
			MemoryAx();
		else if (Main.Operand1.equals("BX"))
			MemoryBx();
		else if (Main.Operand1.equals("CX"))
			MemoryCx();
		else if (Main.Operand1.equals("DX"))
			MemoryDx();
	}
}
