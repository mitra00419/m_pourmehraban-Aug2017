
//Mitra Pourmehraban
//My second project
//August 22, 2017

import java.util.Arrays;

public class Project2 {

		public static void main(String[] args) 
		{
			//String.split();
			//It's a method that acts on a string, <StringName>.split(<String sp>);
			//Where sp is the string where the string splits
			//And it returns an array
			System.out.println(Arrays.toString("I like apples!".split(" "))); 
			//		it will split at spaces and return an array of ["I","like","apples!"]
			// Example 2: "I really like really red apples"split("really")
			//		it will split at the word "really" and return an array of ["I "," like "," apples!"]
			
			//play around with String.split! what happens if you "I reallyreally like apples".split("really") ?
			
			
			//Your task:
			/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
			 * use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
			 * What if it's a fancy sandwich with multiple pieces of bread?
			*/
			System.out.println(splitStringAtSpaces("bread bread ham lettuce yogurt tomatoe mayo mayo mayo bread cheese egg cheese bread bread"));
			System.out.println(splitStringAtSpaces("bread bread"));
			System.out.println(splitStringAtSpaces("bread mayo mayo bread"));
			System.out.println(splitStringAtSpaces("bread ham bread mayo badsasd"));
			System.out.println(splitStringAtSpaces("ham ham bread bread"));
			System.out.println(splitStringAtSpaces("bread mayo mayo bread "));
			System.out.println(splitStringAtSpaces("mayo bread bread mayo mayo"));
			System.out.println(splitStringAtSpaces("bread bread ham ham ham"));
			System.out.println(splitBread("breadbreadhihibread"));
			System.out.println(splitBread("breadbread"));
			System.out.println(splitBread("hihibreadbread"));
			System.out.println(splitBread("breadhibreadhisuperbreadmianbreadaasd"));
			System.out.println(splitBread("breadhihibreadbread"));

			
			//Your task pt 2:
			/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
			 * use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
			 * Again, what if it's a fancy sandwich with multiple pieces of bread?
			*/

			

		}
	public static String splitStringAtSpaces(String sandwiche){
		//starts with a space so if bread is at the beginning it won't impact the code
		//AnswerToReturn is the final String answer
		String answerToReturn = "";
		String stringWithoutSpaces = "  ";
		String notASandwiche = "not a sandwiche";
		//Boolean used later to guarentee that there Nothing between sandwiche won't be printed if there is actually one
		boolean test = false;
		String [] revisedSandwiche = sandwiche.split(" ");
		//Adds all the parts of the String array to a new string
		for(int i = 0; i < revisedSandwiche.length; i++){
			stringWithoutSpaces += revisedSandwiche[i];
		}
		//Adds space to the end so ending with bread won't impact the code
		stringWithoutSpaces = " " + stringWithoutSpaces;
		stringWithoutSpaces += " ";
		String[] finalBreadArray = stringWithoutSpaces.split("bread");
		//Makes sure there is a sandwiche
		if(finalBreadArray.length <= 2){
			return notASandwiche;
		}else {
			//Runs through array with bread and spaces split out
			for(int i = 1; i < finalBreadArray.length-1; i++){
				//All conditions have to be met to print not a sandwiche, guarentees that no faulty return statements happen
				if(finalBreadArray[i].equals("") && i == finalBreadArray.length - 2 && test == false){
					return notASandwiche;
				}else{
					answerToReturn += finalBreadArray[i];
					test = true;
				}
			}
			}
		return answerToReturn;
		}
//		if(revisedSandwiche.length == 3){
//			sandwiche = revisedSandwiche[1];
//			System.out.println(sandwiche);
//		}


	public static String splitBread(String breadStatement){
		//Adds spaces to the statement in case we start or end with bread
		String finalString = "";
		String notASandwiche = "not a sandwiche";
		String preventError = " " + breadStatement + " ";
		// get rid of bread
		String[] breadArray = preventError.split("bread");
		// Makes sure it is a sandwiche
		if(breadArray.length <= 2){
			return notASandwiche;
		}else{
		for(int i = 1; i <breadArray.length-1; i++){
			String breadMiddleStatement = breadArray[i];
			//If two breads are next to each other, there will be a space taking up an index of an Array
			if(breadArray[i].equals("")){
				System.out.print("");
			}else{
			finalString += breadMiddleStatement;
		}
		}
		}
		return finalString;
	}
	}