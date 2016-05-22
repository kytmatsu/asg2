/*
 * Kyle Matsumoto
 * kytmatsu
 * CMPS012B
 * 11/5/14
 * This is the edfile that you gave us filled out with the assigned program specs. i could not get the Echo command to work from aux so i included it in the main of edfile. it is the first for loop you find.
 * */

import java.util.Scanner;
import static java.lang.System.*;

class edfile{


	public static boolean empty(dllist lines){ 
		if (lines.isEmpty()){ 
			out.printf("No lines in file%n"); 
			lines = null; 
			return true; 
		} 
		lines = null; 
		return false; 
	} 


	public static void main (String[] args) {
		dllist lines = new dllist ();
		boolean echo = false;
		
		for(int x = 0; x < args.length; ++x) { 
			          if(args[x].equals("-e")){  
			             echo = true;  
			             continue; 
			         } 
			           
			         auxlib.readFile(args[x],lines);  
			       } 

		Scanner stdin = new Scanner (in);
		for (;;) {
			if (! stdin.hasNextLine()) 
				break;
			String inputline = stdin.nextLine();
			if (echo == true) 
				out.printf ("%s%n", inputline);
			if (inputline.matches ("^\\s*$"))
				continue;

			String q = inputline.substring(1);
			char command = inputline.charAt(0);
			switch (command) {
			case '#':
				break;
			case '$':
				if(empty(lines)) continue; 
				lines.setPosition(dllist.position.LAST); 
				auxlib.printCurr(lines.getPosition(),lines.getItem()); 
				break; 
			case '*':
				lines.printLines(); 
				lines.setPosition(dllist.position.LAST); 
				break;
			case '.':
				if(empty(lines)) continue; 
				auxlib.printCurr(lines.getPosition(),lines.getItem()); 
			break;
			case '0':
				if(empty(lines)) continue; 
				lines.setPosition(dllist.position.FIRST); 
				auxlib.printCurr(lines.getPosition(),lines.getItem()); 
				break; 

			case '<':
				if(empty(lines)) continue; 
				lines.setPosition(dllist.position.PREVIOUS); 
				auxlib.printCurr(lines.getPosition(),lines.getItem()); 
				break; 

			case '>':
				if(empty(lines)) continue; 
				lines.setPosition(dllist.position.FOLLOWING); 
				auxlib.printCurr(lines.getPosition(),lines.getItem()); 
				break; 

			case 'a':
				lines.insert(q, dllist.position.FOLLOWING); 
				auxlib.printCurr(lines.getPosition(),lines.getItem()); 
				break; 

			case 'd':
				auxlib.deleteLines(lines);
				break;
			case 'i': 
				lines.insert(q, dllist.position.PREVIOUS);  
				auxlib.printCurr(lines.getPosition(),lines.getItem()); 
				break; 

			case 'r':
				auxlib.readFile(q,lines);  
				out.printf("%d lines read from %s%n",  auxlib.numLines(), q); 
				break;

			case 'w':
				auxlib.writeFile (q,lines); 
				break;

			default :
				auxlib.warn ("invalid command: ", inputline);
				break;
			}
		}
		auxlib.exit("(eof)");
	}

}


