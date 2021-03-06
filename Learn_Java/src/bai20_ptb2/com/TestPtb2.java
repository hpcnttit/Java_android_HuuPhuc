package bai20_ptb2.com;

import java.util.Scanner;

public class TestPtb2 {
	/**
	 * Giải phương trình bậc 2: ax^2 +bx=c
	 * @param a - hệ số a
	 * @param b - hệ số b 
	 * @param c - hệ số c
	 */
	
	public static void giaiPTB2(double a, double b, double c) {
		if(a==0) {
			System.out.println("PT trở thanh ptb1: ");
			if(b==0 && c==0) {
				System.out.println("PT vo so nghiem");
			}else if(b==0 && c!=0){
				System.out.println("Pt vo nghiem");
			}else {
				//bx+ c= 0 => x= -c/b
				System.out.println("Nhiem cua pt "+ (-c/b) );
			}									
		}else {
			double delta= b*b -4*a*c;
			if(delta<0) {
				System.out.println("PT vo nhiem");
			}else if(delta==0) {
				 System.out.println("Pt co nghiem kep x1= x2= "+ (-b/(2*a)));
			}else {
				double x1= (-b- Math.sqrt(delta))/(2*a);
				double x2= (-b+ Math.sqrt(delta))/(2*a);
				System.out.println("Pt co 2 nghiem phan biet, x1= "+ x1 +", x2= "+ x2 );
			}
		}				
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("GIAI PT BAC 2");
		do {
			Scanner sc= new Scanner(System.in);
			System.out.println("Nhap he so a");
			double a=sc.nextDouble();
			System.out.println("Nhap he so b");
			double b=sc.nextDouble();
			System.out.println("Nhap he so c");
			double c=sc.nextDouble();
			giaiPTB2(a, b, c);
			
			System.out.println("Ban co muon tiep k? (c/k): ");
			String line= new Scanner(System.in).nextLine();
			if(line.equalsIgnoreCase("k"))
				break;					
		}while(true);
		System.out.println("Tks!");
		
	}

}
