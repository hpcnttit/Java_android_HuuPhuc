package bai22_renluyenfor.com;

public class TestFor_Img1 {
	
//	public static void hinh1(int h) {
//		for(int i=0; i<h; i++) {
//			for(int j=i; j<h; j++) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
//	}
	
	public static void hinh1(int h) {
		for(int i=h; i>=1; i--) {
			
			for(int j=1; j<=i; j++) {
				System.out.print("*");				
			}
			System.out.println("");
		}
	}
	
	public static void hinh2(int h) {
		for(int i=1; i<=h; i++) {
			
			for(int j=1; j<=i; j++) {
				System.out.print("*");				
			}
			System.out.println("");
		}
	}
	
	public static void hinh3(int h) {
		for(int i=1; i<=h; i++) {
			
			for(int j=1; j<=h-i; j++) {
				System.out.print(" ");				
			}
			for(int k=1; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public static void hinh4(int h) {
		for(int i=h; i>=1; i--) {
			
			for(int j=1; j<=h-i; j++) {
				System.out.print(" ");				
			}
			for(int k=1; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	
	public static void main(String[] args) {
		hinh2(5);
	}

}
