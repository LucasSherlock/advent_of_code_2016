package q1;

import java.io.*;
import java.math.*;


public class Main {
	
	public static void main(String[] args) {
		int[] coords = {0,0};
		char dir = 'N';
		try {
			File inputFile = new File("Q1_input.txt");
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			String input = br.readLine();
			br.close();
			
			
			String[] directions = input.split(", ");
			for(int i = 0; i < directions.length; i++) {
				dir = turn(dir, directions[i].charAt(0));
				coords = move(dir, Integer.parseInt(directions[i].substring(1)), coords);
			}
			
		} catch(IOException ioe) {
			System.out.println("Issue reading file");
		} catch(NumberFormatException nfe) {
			System.out.println("Issue: string is not int");
		}
		
		System.out.println(Math.abs(coords[0]) + Math.abs(coords[1]));
	}
	
	public static char turn(char dir, char turn) {
		if(turn == 'L') {
			switch(dir) {
				case 'N': return 'W';
				case 'S': return 'E';
				case 'E': return 'N';
				case 'W': return 'S';
			}
		} else {
			switch(dir) {
				case 'N': return 'E';
				case 'S': return 'W';
				case 'E': return 'S';
				case 'W': return 'N';
			}
		}
		return 'X';
	}
	
	public static int[] move(char dir, int dist, int[] coords) {
			switch(dir) {
				case 'N': coords[1] += dist;
				break;
				case 'S': coords[1] -= dist;
				break;
				case 'E': coords[0] += dist;
				break;
				case 'W': coords[0] -= dist;
				break;
			}
		return coords;
	}
	
	
	
}
