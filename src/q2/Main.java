package q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		
		char currentNum = '5';
		
		
		try {
			File inputFile = new File("Q2_input.txt");
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				for(int i = 0; i < line.length(); i++) {
					currentNum = moveB(currentNum, line.charAt(i));
				}
				System.out.println(currentNum);
			}
			br.close();

		} catch(IOException ioe) {
			System.out.println("Issue reading file");
		}

	}
	
	public static char moveA(char currentNum, char dir) {
		if(dir == 'U') {
			switch(currentNum) {
				case '1'|'2'|'3': break;
				case '4': return '1';
				case '5': return '2';
				case '6': return '3';
				case '7': return '4';
				case '8': return '5';
				case '9': return '6';
			}
		} else if(dir == 'D') {
			switch(currentNum) {
				case '1': return '4';
				case '2': return '5';
				case '3': return '6';
				case '4': return '7';
				case '5': return '8';
				case'6': return '9';
				case '7'|'8'|'9': break;
			}
			
		} else if(dir == 'L') {
			switch(currentNum) {
				case '1'|'4'|'7': break;
				case '2': return '1';
				case '3': return '2';
				case '5': return '4';
				case '6': return '5';
				case '8': return '7';
				case '9': return '8';
			}
		} else {
			switch(currentNum) {
				case '3'|'6'|'9': break;
				case '1': return '2';
				case '2': return '3';
				case '4': return '5';
				case '5': return '6';
				case '7': return '8';
				case '8': return '9';
			}
		}

		return currentNum; //no change
	}
	
	public static char moveB(char currentNum, char dir) {
		if(dir == 'U') {
			switch(currentNum) {
				case '5'|'2'|'1'|'4'|'9': break;
				case '3': return '1';
				case '6': return '2';
				case '7': return '3';
				case '8': return '4';
				case 'A': return '6';
				case 'B': return '7';
				case 'C': return '8';
				case 'D': return 'B';
			}
		} else if(dir == 'D') {
			switch(currentNum) {
				case '1': return '3';
				case '2': return '6';
				case '3': return '7';
				case '4': return '8';
				case '6': return 'A';
				case '7': return 'B';
				case '8': return 'C';
				case 'B': return 'D';
				case '5'|'A'|'D'|'C'|'9': break;
			}
			
		} else if(dir == 'L') {
			switch(currentNum) {
				case '1'|'2'|'5'|'A'|'D': break;
				case '3': return '2';
				case '4': return '3';
				case '6': return '5';
				case '7': return '6';
				case '8': return '7';
				case '9': return '8';
				case 'B': return 'A';
				case 'C': return 'B';
			}
		} else {
			switch(currentNum) {
				case '1'|'4'|'9'|'C'|'D': break;
				case '2': return '3';
				case '3': return '4';
				case '5': return '6';
				case '6': return '7';
				case '7': return '8';
				case '8': return '9';
				case 'A': return 'B';
				case 'B': return 'C';
			}
		}

		return currentNum; //no change
	}


}
