package objects;

import java.util.ArrayList;

public class Person {
	private String firstName; //prevents outside changes
	private String middleName;
	private String lastName;
	public static int MAX_ALLOWED_BOOKS = 3;
	private ArrayList<Book> checkedOutBooks;
	private boolean male;
	Balance balance; 
	
	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	
	public boolean isMale(){
		return male;
	}
	
	public ArrayList<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}
	
	public void checkOutBook(Book activeBook){
		activeBook.setCheckedOut(true);
		activeBook.setCheckOutDate(System.currentTimeMillis());
		activeBook.setDueDate(System.currentTimeMillis()+30000);
		checkedOutBooks.add(activeBook);
	}
	
	public void returnBook(Book b){
		b.updateCondition(System.currentTimeMillis());
		balance.subtractLateFees(b.getDueDate()-System.currentTimeMillis());
		b.setCheckedOut(false);
		b.setCheckOutDate(0);
		b.setDueDate(0);
		checkedOutBooks.remove(b);
	}
	
	public void renewBook(Book b){
		b.setDueDate(System.currentTimeMillis()+30000);
	}
	
	public String getGenderPosessivePronoun(){
		if(this.male==true)return "his";
		return "her";
	}
	
	public String getLibraryDescription(){
		return firstName+" "+lastName+" is viewing the library collection and his balance is " + balance.getAmount() ; 
	
	}
	
	public Person(String firstName, String lastName, boolean male){
		this.firstName=firstName;//assign parameter to a field so information is remembered
		this.middleName="";
		this.lastName=lastName;//specifies the one in the class not the local variable
		this.checkedOutBooks=new ArrayList<Book>();
		this.male=male;
	}
	
	public Person(String firstName, String middleName, String lastName, boolean male){
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.checkedOutBooks=new ArrayList<Book>();
		this.male=male;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String toString(){
		return firstName+" "+middleName+" "+lastName;
	}
}