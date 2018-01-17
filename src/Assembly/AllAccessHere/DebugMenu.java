package Assembly.AllAccessHere;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class DebugMenu {
	int address = 0, previous = 0;
	char[] converter = new char [50];
	String code = null;
	
	public int ManipulateCode() throws FileNotFoundException, UnsupportedEncodingException {
		for (int i=1; i<=Main.MemoryAddress; i++) {
			Main.CodeGeneratorFlag = 0;
			Main.OpCode = "null";
			Main.Operand1 = "null";
			Main.Operand2 = "null";
			
			Main.SourceManipulate = Main.Source[i].toCharArray();
			
			for (int j = 0; j<Main.Source[i].length(); j++) {
				if (Main.CodeGeneratorFlag==0){
					if (Main.SourceManipulate[j]==' '){
						Main.CodeGeneratorFlag = 1;
						//Set Flag to 1 to fetch operand
					}
					else{
						if(Main.OpCode.equals("null"))
							Main.OpCode = Character.toString(Main.SourceManipulate[j]);
						else
							Main.OpCode = Main.OpCode+Main.SourceManipulate[j];
					}
				}
				else if (Main.CodeGeneratorFlag == 1){
					if (Main.SourceManipulate[j] == ' '){
						continue; 
						//Ignore Unexpected Space Character.
					}
					else if (Main.SourceManipulate[j] == ','){
						Main.CodeGeneratorFlag = 2; 
						//Flag is set to fetch second operand or data.
					}
					else{
						if (Main.Operand1.equals("null"))
							Main.Operand1 = Character.toString(Main.SourceManipulate[j]);
						else
							Main.Operand1= Main.Operand1+Main.SourceManipulate[j]; 
					}
				}
				else if (Main.CodeGeneratorFlag == 2){
					if (Main.SourceManipulate[j] == ' '){
						continue;
						//Ignore Unexpected Space Character.
					}
					else{
						if (Main.Operand2.equals("null"))
							Main.Operand2 = Character.toString(Main.SourceManipulate[j]);
						else
							Main.Operand2= Main.Operand2+Main.SourceManipulate[j];
					}
				}
			}
			if (Main.OpCode.equals("HLT"))
				break;
			else
				Main.insgen.OpCodeGenerator();
		}
		return 0;
	}
	
	public int Debugger() throws FileNotFoundException, UnsupportedEncodingException {
		while (true) {
			address = 0;
			address = Main.sc.nextInt();
			code = Main.sc.nextLine();
		
			if (address == previous) {
				previous = 0;
				break;
			}
						
			converter = code.toCharArray();
			
			int length =0;
			length = code.length();
			
			code = "";
			
			if (converter[0] == ' ') {
				for (int m=0; m<length-1; m++) {
					converter[m] = converter[m+1];
				}
				for (int m=0; m<length-1; m++) {
					code = code + converter[m];
				}
			}
					
			Main.Source[address] = code;
			Main.ax = 0; Main.bx = 0; Main.cx = 0; Main.dx = 0;
			
			previous = address;
			
			if (code.compareTo("HLT") == 0) {
				code = null;
				previous = 0;
				break;
			}
		}
		
		if (address>Main.MemoryAddress) {
			Main.MemoryAddress = address;
		}
		
		ManipulateCode();
		return 0;
	}
}
