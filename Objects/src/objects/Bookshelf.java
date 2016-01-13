package objects;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;

public class Bookshelf {

	public static void main(String[] args) {
		Person author1 = new Person("Nancy","Shfkaf",true);//default constructor for all objects
		Person author2 = new Person("George","RR","Martin",true);
		
		Book book1 = new Book("Msbwv",1000,author1);
		Book book2 = new Book("A Game of Thrones",852,author1);
		Book book3 = new Book("Do Androids Dream of Electric Sheep?",555,author2);
		Book book4 = new Book("To Kill a Mockingbird",532,author2);
		
		book1.setColor(Color.ORANGE);
		book2.setColor(new Color(10,0,230));
		book3.setColor(new Color(230,40,50));
		book4.setColor(new Color(20,220,20));

		Person person1 = new Person("Bryant","Liriano", true);
		Person person2 = new Person("Carmen","Tang", false);
		Person person3 = new Person("John","D","Hocknell",true);
		Person person4 = new Person("Celina","Dennnnng", false);

		Person[] peopleArray = new Person[4];
		ArrayList<Person> libraryCardHolders = new ArrayList<Person>();
		libraryCardHolders.add(person1);
		libraryCardHolders.add(person2);
		libraryCardHolders.add(person3);
		libraryCardHolders.add(person4);

		Book[] bookArray = new Book[4];//length is definite
		ArrayList<Book> books = new ArrayList<Book>();
		/**
		 * Adding objects to ArrayList:
		 * for arrays:
		 * bookArray[0]=book1;
		 */
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);

		//sortByPageNumber(true, books);
		sortByAuthor(true, books);
		printAll(books);

		Library lib = new Library(books, libraryCardHolders);//use "books" or "shelf" whatever your ArrayList is 

		lib.setSize(new Dimension(500,500));

		lib.setVisible(true);

		lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	

	public static void sortByPageNumber(final boolean ascending, ArrayList<Book> list){
		Collections.sort(list, new Comparator<Book>(){
			public int compare(Book a, Book b){
				if(ascending)return a.getNumberOfPages()-b.getNumberOfPages();
				return b.getNumberOfPages()-a.getNumberOfPages();
			}
		});
	}

	public static void sortByAuthor(final boolean ascending, ArrayList<Book> list){
		Collections.sort(list, new Comparator<Book>(){
			public int compare(Book a, Book b){
				if(ascending)return a.getAuthor().getLastName().compareTo(b.getAuthor().getLastName());
				return b.getAuthor().getLastName().compareTo(a.getAuthor().getLastName());
			}
		});
	}

	public static void sortByTitle(final boolean ascending, ArrayList<Book> list){
		Collections.sort(list, new Comparator<Book>(){
			public int compare(Book a, Book b){
				if(ascending)return a.getTitle().compareTo(b.getTitle());
				return b.getTitle().compareTo(b.getTitle());
			}
		});
	}

	public static void sortByHeight(final boolean ascending, ArrayList<Book> list){
		Collections.sort(list, new Comparator<Book>(){
			public int compare(Book a, Book b){
				if(ascending)return a.getNumberOfPages()-b.getNumberOfPages();
				return b.getNumberOfPages()-a.getNumberOfPages();
			}
		});
	}

	private static void printAll(ArrayList list){
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println(i+")"+list.get(i));
		}
	}
}
