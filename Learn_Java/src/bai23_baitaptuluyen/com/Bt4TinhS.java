package bai23_baitaptuluyen.com;

import java.util.Scanner;

public class Bt4TinhS {
	public static double tinhTongS(int x, int n) {
		double s= x;
		double mau= 1;
						
		for(int i=1; i<=n; i++) {
			double tu= Math.pow(x,(2*i+1));	
			int j=1;
			while(j<=(2*i+1)) {
				mau *= j;
				j++;
			} 
			s= s+ tu/mau;
		}
		return s;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap x: ");
		int x=sc.nextInt();
		System.out.println("Nhap n: ");
		int n=sc.nextInt();
		double s=tinhTongS(x, n);
		
		System.out.println("S("+x+","+n+")= "+ s );
	}

}
