package q3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		partOne();
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
		System.out.println(numPossible);
	}

}
