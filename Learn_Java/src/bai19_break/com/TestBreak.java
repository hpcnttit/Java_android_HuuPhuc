package bai19_break.com;

import java.util.Scanner;

public class TestBreak {

	public static void main(String[] args) {
		while(true) {
		
			System.out.println("Nhap vao 1 so: ");
			int n= new Scanner(System.in).nextInt();
			if(n%2== 0) {
				System.out.println(n+ " la so chan");
			}else {
				System.out.println(n+ " la so le");
			}
			
			
			System.out.println("Tiep hay k? (y/n):");
			String line= new Scanner(System.in).nextLine();
			
			if(line.equalsIgnoreCase("n"))
				break;			
		}
		System.out.println("Bye bye!");
	}

}
