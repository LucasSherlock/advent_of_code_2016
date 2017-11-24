package q3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		partOne();
		partTwo();
	}
	
	public static boolean isPossible(int dim1, int dim2, int dim3) {	
		if(dim1+dim2 <= dim3 || dim1+dim3 <= dim2 || dim3+dim2 <= dim1) {
			return false;
		}
		return true;
	}
	
	public static int toInt(String str) throws NumberFormatException {
		int num;
		for(int i = 0; i < 2; i++) {
			if(str.charAt(0) == ' ') {
				str = str.substring(1);
			}
		}
		num = Integer.parseInt(str);

		return num;
	}
	
	public static void partOne() {
		int numPossible = 0;
		int dim1 = 0;
		int dim2 = 0;
		int dim3 = 0;
		try {
			File inputFile = new File("Q3_input.txt");
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				dim1 = toInt(line.substring(2,5));
				dim2 = toInt(line.substring(7,10));
				dim3 = toInt(line.substring(12,15));
				if(isPossible(dim1,dim2,dim3)) {
					numPossible++;
				}
			
			}
			
			br.close();
		} catch(IOException ioe) {
			System.out.println("Issue reading file");
		}
		System.out.println("Part 1: " + numPossible);
	}
	
	public static void partTwo() {
		int numPossible = 0;
		int dimA1 = 0;
		int dimA2 = 0;
		int dimA3 = 0;
		
		int dimB1 = 0;
		int dimB2 = 0;
		int dimB3 = 0;
		
		int dimC1 = 0;
		int dimC2 = 0;
		int dimC3 = 0;
		
		try {
			File inputFile = new File("Q3_input.txt");
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			String line1 = null;
			String line2 = null;
			String line3 = null;
			while((line1 = br.readLine()) != null) {
				line2 = br.readLine();
				line3 = br.readLine();

				dimA1 = toInt(line1.substring(2,5));
				dimA2 = toInt(line2.substring(2,5));
				dimA3 = toInt(line3.substring(2,5));
				if(isPossible(dimA1,dimA2,dimA3)) {
					numPossible++;
				}
				
				dimB1 = toInt(line1.substring(7,10));
				dimB2 = toInt(line2.substring(7,10));
				dimB3 = toInt(line3.substring(7,10));
				if(isPossible(dimB1,dimB2,dimB3)) {
					numPossible++;
				}
				
				dimC1 = toInt(line1.substring(12,15));
				dimC2 = toInt(line2.substring(12,15));
				dimC3 = toInt(line3.substring(12,15));
				if(isPossible(dimC1,dimC2,dimC3)) {
					numPossible++;
				}
			}
			
			br.close();
		} catch(IOException ioe) {
			System.out.println("Issue reading file");
		}
		System.out.println("Part 2: " + numPossible);
	}

}
