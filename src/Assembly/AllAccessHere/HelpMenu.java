package Assembly.AllAccessHere;

public class HelpMenu {
	public int Help(){
		System.out.println("To Start run "+"\"Java -jar Virtual-Assembler.jar\"\n");
		
		System.out.println("1. ASSEMBLY -To write code.\n   [Write code in Assembly Language]\n");
		System.out.println("2. SOURCE   -To see written code.\n   [Check Error Easily]\n");
		System.out.println("3. DEBUG    -To fix Error.\n   [If any bug Found, to fix error write line number and then code]\n");
		System.out.println("4. RUN      -To execute code.\n   [Execute code and See Results]\n");
		System.out.println("5. HELP     -To help.\n   [If you faced Problem, you can get solution here.\n");
		System.out.println("6. EXIT     -To switch off.\n   [Close this Window]\n");
		
		System.out.println("7. Best Practicing:\n   > Always use capital letter for better performance.");
		System.out.println("   > Always Write code Using Capital Letter. Assembler Support only Capital Letter written code.\n");
		
		System.out.println("8. Sample Code:");
		System.out.println("   1. MOV BX, 12");
		System.out.println("   2. MOV CX, 15");
		System.out.println("   3. ADD BX, CX");
		System.out.println("   4. MOV AX, BX");
		System.out.println("   5. DIV AX, 3");
		System.out.println("   6. HLT\n");
		System.out.println("[Note: To do any task, at first choose menu by writing menu name.]");
		return 0;
	}
}
