package hpit.com.model;

public class Executive extends Employee {
	private double bonus;
	public void awardBonus(double bonus) {
		this.bonus=bonus;
		System.out.println("Nhan bonus= "+bonus );
	}
	
	public double pay() {
		return super.pay()+this.bonus; 
	}
}
