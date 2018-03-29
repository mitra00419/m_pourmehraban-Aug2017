package textExcel;
import java.util.*;
import java.io.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextExcel
{
	// main method to run text excel
	public static void main(String[] args) {
		Spreadsheet spread = new Spreadsheet();
		System.out.println("Welcome to Spreadsheet! Begin............");
		Scanner input = new Scanner(System.in);
		String command = input.nextLine();
		System.out.println(spread.processCommand(command));
		// loop continues until command quit is entered then does the else in spreadsheet
		while (!command.equalsIgnoreCase("quit")) {
			command = input.nextLine();
			System.out.println(spread.processCommand(command));
		}
	}
}
