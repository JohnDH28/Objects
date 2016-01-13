package objects;
public class Balance {
	
	double amount;
	long lastWorked;
	double negativeAmount;
	
	public Balance(){
		amount = 0;
		lastWorked = 0;
		negativeAmount = 0;
	}
	
	public double getAmount() {
		return Math.round((amount + negativeAmount) * 100.0) / 100.0; 
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public long getLastWorked() {
		return lastWorked;
	}
	
	public void setLastWorked(long lastWorked) {
		this.lastWorked = lastWorked;
	}
	
	public double getNegativeAmount(){
		return negativeAmount;
	}
		
	public void subtractLateFees(long timeOverdue){
		if (timeOverdue < 0) negativeAmount += Math.round(timeOverdue / 200);
	}
	
	public boolean canWork(long time){
		if(((time - lastWorked) / 1000) > 10){
			return true;
		} else return false;
	}
	
	public String earnMoney(long time){
		if(canWork(time)){
			amount += 5.0;
			lastWorked = time;
			return "did some work at the library and earned $5";
		}
		return "can not do a double shift! Wait until the first job is done";
	}
}