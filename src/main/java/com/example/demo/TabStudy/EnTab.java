package com.example.demo.TabStudy;

import com.example.demo.util.Debug;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;


/**
 * EnTab: replace blanks by tabs and blanks. Transmuted from K&R Software Tools
 * book into C. Transmuted again, years later, into Java. Totally rewritten to
 * be line-at-a-time instead of char-at-a-time.
 * 
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @version $Id: EnTab.java,v 1.11 2004/02/22 21:21:44 ian Exp $
 */
public class EnTab {
	/** The Tabs (tab logic handler) */
	protected Tabs tabs;

	/**
	 * Delegate tab spacing information to tabs.
	 * 
	 * @return
	 */
	public int getTabSpacing() {
		return tabs.getTabSpacing();
	}

	/**
	 * Main program: just create an EnTab object, and pass the standard input
	 * or the named file(s) through it.
	 */
	public static void main(String[] argv) throws IOException {
		EnTab et = new EnTab(8);
		if (argv.length == 0){
			// do standard input
			et.entab(
					new BufferedReader(new InputStreamReader(System.in)),
					System.out);
		}

		else{
			for (int i = 0; i < argv.length; i++) { // do each file
				et.entab(
						new BufferedReader(new FileReader(argv[i])),
						System.out);
			}
		}

	}

	/**
	 * Constructor: just save the tab values.
	 * 
	 * @param n
	 *            The number of spaces each tab is to replace.
	 */
	public EnTab(int n) {
		tabs = new Tabs(n);
	}

	public EnTab() {
		tabs = new Tabs();
	}

	/**
	 * entab: process one file, replacing blanks with tabs.
	 * 
	 * @param is A BufferedReader opened to the file to be read.
	 * @param out a PrintWriter to send the output to.
	 */
	public void entab(BufferedReader is, PrintWriter out) throws IOException {
		String line;
		int c, col = 0, newcol;

		// main loop: process entire file one line at a time.
		while ((line = is.readLine()) != null) {
			out.println(entabLine(line));
		}
	}
	/**
	 * entab: process one file, replacing blanks with tabs.
	 * 
	 * @param is A BufferedReader opened to the file to be read.
	 * @param out A PrintStream to write the output to.
	 */
	public void entab(BufferedReader is, PrintStream out) throws IOException {
		entab(is, new PrintWriter(out));
	}

	/**
	 * entabLine: process one line, replacing blanks with tabs.
	 * 
	 * @param line -
	 *            the string to be processed
	 */
	public String entabLine(String line) {
		int N = line.length(), outCol = 0;
		StringBuffer sb = new StringBuffer();
		char ch;
		int consumedSpaces = 0;
		
		for (int inCol = 0; inCol < N; inCol++) {
			ch = line.charAt(inCol);
			// If we get a space, consume it, don't output it.
			// If this takes us to a tab stop, output a tab character.
			if (ch == ' ') {
				Debug.println("space", "Got space at " + inCol);
				if (!tabs.isTabStop(inCol)) {
					consumedSpaces++;
				} else {
					Debug.println("tab", "Got a Tab Stop " + inCol);
					sb.append('\t');
					outCol += consumedSpaces;
					consumedSpaces = 0;
				}
				continue;
			}

			// We're at a non-space; if we're just past a tab stop, we need
			// to put the "leftover" spaces back out, since we consumed
			// them above.
			while (inCol-1 > outCol) {
				Debug.println("pad", "Padding space at " + inCol);
				sb.append(' ');
				outCol++;
			}

			// Now we have a plain character to output.
			sb.append(ch);
			outCol++;

		}
		// If line ended with trailing (or only!) spaces, preserve them.
		for (int i = 0; i < consumedSpaces; i++) {
			Debug.println("trail", "Padding space at end # " + i);
			sb.append(' ');
		}
		return sb.toString();
	}
}
