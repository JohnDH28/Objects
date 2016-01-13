package objects;

import java.awt.Color;

public class Book {
	private String title;
	private int numberOfPages;
	private Person author;
	private int height;
	private boolean wasLitOnFire;
	private int thickness;
	private Color color;
	private boolean checkedOut;
	private long checkOutDate;
	private long dueDate;
	static public String[] conditions={"This appears to be a brand new book!",
		"This book is very gently used.",
		"This book is in decent conditon",
		"This book is worn out.",
		"This book is very worn out and needs to be replaced."};	
	public static int DEFAULT_HEIGHT = 300;
	String description;
	int accumulatedUse;
	
	public Book(String title, int numOfPages, Person author){
		this.title = title;
		this.numberOfPages = numOfPages;
		this.author = author;
		height = DEFAULT_HEIGHT + (int)(Math.random()*100);
		color = Color.gray;
		wasLitOnFire = false;
		thickness = numberOfPages/10;
		checkedOut = false;
		checkOutDate = 0;
	    dueDate = 0;
	    description = description;
		accumulatedUse = 0;
	}
	
	public void updateCondition(long timeOfReturn){
		accumulatedUse += (timeOfReturn - checkOutDate);
		if (accumulatedUse > 30) description = conditions[0];
		if (accumulatedUse > 45) description = conditions[1];
		if (accumulatedUse > 60) description = conditions[2];
		if (accumulatedUse > 75) description = conditions[3];
		if (accumulatedUse > 90) description = conditions[4];
	}
	
	public String getDescription() {
		return description;
	}

	public int getAccumulatedUse() {
		return accumulatedUse;
	}
	
	public long getSecondsRemaining(){
		return (dueDate - System.currentTimeMillis())/1000;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color jacketColor) {
		this.color = jacketColor;
	}

	public String toString(){
		if(wasLitOnFire) return "\"" + title + "\", by " + "You cannot make out the author's name" + ". " + numberOfPages + " pages";
		return "\"" + title + "\", by " + author + ". " + numberOfPages + " pages";
	}
	
	//getter
	public String getTitle(){
		return title;
	}
	
	public Person getAuthor() {
		return author;
	}
	
	public int getNumberOfPages(){
		return numberOfPages;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int height) {
	    this.height = height;
	}
	
	public int getThickness() {
	    return thickness;
	}
	
	public void setOnFire(){
		wasLitOnFire = true;
		color = Color.black;
		title = "The title of this book is too charred to make out";
		
	}
	
	public boolean isCheckedOut(){
		return checkedOut;
	}
	
	public void setCheckedOut(boolean checkedOut) {
	    this.checkedOut = checkedOut;
	}

	public long getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(long checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public long getDueDate() {
		return dueDate;
	}

	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}
}