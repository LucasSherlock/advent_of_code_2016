package q1;

import java.io.*;
import java.math.*;


public class Main {
	
	private static int[][] grid = new int[1000][1000];
	
	
	
	public static void main(String[] args) throws NumberFormatException {
		String input = null;
		
		int[] coords = {500,500};
		char dir = 'N';
		int moveDist = 0;

		
		
		try {
			File inputFile = new File("Q1_input.txt");
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			input = br.readLine();
			br.close();

		} catch(IOException ioe) {
			System.out.println("Issue reading file");
		} catch(NumberFormatException nfe) {
			System.out.println("Issue: string is not int");
		}
		
		String[] directions = input.split(", ");
		for(int i = 0; i < directions.length; i++) {
			dir = turn(dir, directions[i].charAt(0));
			moveDist = Integer.parseInt(directions[i].substring(1));
			coords = move(dir, moveDist, coords);
		}
		
		System.out.println("Distance to end is: " + ((500-Math.abs(coords[0])) + (500-Math.abs(coords[1]))));

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
				case 'N': for(int i = 0; i < dist; i++) {
						grid[coords[0]][coords[1]+i]++;
						if(grid[coords[0]][coords[1]+i] > 1) {
							System.out.println( (500-Math.abs(coords[0])) + (500-(Math.abs(coords[1])+i)) );
						}
					}
					coords[1] += dist;
					break;
				case 'S': for(int i = 0; i < dist; i++) {
						grid[coords[0]][coords[1]-i]++;
						if(grid[coords[0]][coords[1]-i] > 1) {
							System.out.println( (500-Math.abs(coords[0])) + (500-(Math.abs(coords[1])-i)) );
						}
					}
					coords[1] -= dist;
					break;
				case 'E': for(int i = 0; i < dist; i++) {
						grid[coords[0]+i][coords[1]]++;
						if(grid[coords[0]+1][coords[1]] > 1) {
							System.out.println( (500-(Math.abs(coords[0])+i)) + (500-Math.abs(coords[1])) );
						}
					}
					coords[0] += dist;
					break;
				case 'W': for(int i = 0; i < dist; i++) {
						grid[coords[0]-i][coords[1]]++;
						if(grid[coords[0]-i][coords[1]] > 1) {
							System.out.println( (500-(Math.abs(coords[0])-i)) + (500-Math.abs(coords[1])) );
						}
					}
					coords[0] -= dist;
					break;
			}
		return coords;
	}
	
	
}
