package bai23_baitaptuluyen.com;

import java.util.Scanner;

public class Bt2SoHoanThien {
//	public static int soHoanThien(int n) {
//		int tong=0;
//		for(int i=1; i<n; i++){
//			if() 
//		}
//	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap vao so n: ");
		int n= sc.nextInt();
		
		while(n<0) {
			System.out.println("Nhap lai so n: ");
			n= sc.nextInt();
		}
		
		int tong=0;
		for(int i=1; i<n; i++){
			if(n%i==0) {
				tong +=i;
			}
		}
		
		if(tong==n) {
			System.out.println("hoan thien");
		}
		else {
			System.out.println("k hoan thien");
		}
	}

}
