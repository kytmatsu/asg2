/*
 * Kyle Matsumoto
 * kytmatsu
 * CMPS012B
 * 11/5/14
 * This is auxlib with everything but the echo command, which i could not implement here for a lack of understanding on what to pass it.
 * */

import static java.lang.System.*; 
import static java.lang.Integer.*; 
import java.io.*; 


class auxlib {
	public static final int EXIT_SUCCESS = 0;
	public static final int EXIT_FAILURE = 1;
	public static int exit_status = EXIT_SUCCESS;
	public static int linesRead = 0; 
	public static int linesWritten = 0; 

	public static void printCurr(int pos, String item){ 
		out.printf("%6d %s%n", pos, item); 
	}

	public static void readFile (String fileName, dllist lines) { 
		try{ 
			FileInputStream fstream = new FileInputStream( fileName ); 
			DataInputStream in = new DataInputStream(fstream); 
			BufferedReader buff = new BufferedReader(new InputStreamReader(in)); 
			String curr; 
			linesRead = 0; 
			while ((curr = buff.readLine()) != null) 
			{ 
				++linesRead; 
				lines.insert(curr, dllist.position.FOLLOWING);  
			} 
			in.close(); 
			lines = null; 
		}
		catch (Exception e)
		{ 
			linesRead = 0; 
			auxlib.warn(e.getMessage()); 
		} 
	} 

	public static void writeFile (String fileName, dllist lines) { 
		try { 
			FileWriter fstream = new FileWriter( fileName); 
			BufferedWriter buff = new BufferedWriter(fstream);  
			linesWritten = 0;      
			if(!lines.isEmpty())
			{ 
				lines.setPosition(dllist.position.LAST); 
				int last = lines.getPosition(); 
				lines.setPosition(dllist.position.FIRST); 
				for(int x = 0; x <= last; ++x) 
				{ 
					++linesWritten; 
					buff.write(lines.getItem()+'\n');  
					lines.setPosition(dllist.position.FOLLOWING);  
				} 
			}    
			out.printf("%d lines written to %s%n",linesWritten,fileName); 
			buff.close(); 
			lines = null; 
		}
		catch (Exception e)
		{ 
			linesWritten = 0; 
			auxlib.warn(e.getMessage()); 
		} 
	} 

	public static String programName() {
		String jarname = getProperty("java.class.path");
		return jarname.substring(jarname.lastIndexOf ("/") + 1);
	}


	public static void warn (Object... args) {
		exit_status = EXIT_FAILURE;
		out.flush();
		err.printf ("%s", programName());
		for (Object arg: args) err.printf (": %s", arg);
		err.printf ("%n");
		err.flush();
	}



	public static void die (Object... args) {
		warn(args);
		System.exit(exit_status);
	}

	public static void usage (Object... args) {
		exit_status = EXIT_FAILURE;
		out.flush();
		err.printf ("Usage: %s", programName());
		for (Object arg: args) err.printf (" %s", arg);
		err.printf ("%n");
		err.flush();
		System.exit (exit_status);
	}
	public static int numLines () { 
		return linesRead; 
	} 
	public static void deleteLines(dllist lines)
	{
		lines.delete();
	}	
	public static void exit (String a) { 
		if(a == "(eof)")
		{
			System.exit(exit_status);
		}
	} 



	public static void STUB (String... args) {
		out.printf ("%s:%n", Thread.currentThread().getStackTrace()[1]);
		for (Object arg: args) out.printf (": %s", arg);
		out.printf ("%n");
	}

}
