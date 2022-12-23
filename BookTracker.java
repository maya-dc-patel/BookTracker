import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BookTracker {
    public static void main ( String[] args ) {
        BookShelf bookshelf = new BookShelf();
        Scanner scan = new Scanner(System.in);

        printMenu();
        while (scan.hasNext()) {
            String userChoice = scan.nextLine();

            if ( userChoice.equals( "A" ) || userChoice.equals( "a" ) ) {
                System.out.println( "\nLets add a book!\n" );
                System.out.print( "Enter book name: " );
                String bookName = scan.nextLine();
                System.out.print( "Enter number of pages in " + bookName + ": "  );
                int pages = scan.nextInt();
                scan.nextLine();
                Book toAdd = new Book( bookName, pages );
                System.out.printf(
                        "Confirm this is the book you would like to add: (Type 'Y' for yes and 'N' to start over)\n" + toAdd + "\n" );
                String confirm = scan.nextLine();
                if ( confirm.toLowerCase().equals( "y" ) ) {
                    bookshelf.addBook( toAdd );
                    System.out.println( toAdd + " has been added!" );
                }
            } else if (userChoice.toLowerCase().equals("v")) {
                System.out.println("\nYOUR BOOKSHELF:");
                int count = 1;
                for (Book b: bookshelf.books) {
                    System.out.println(count++ + " - " + b);
                }
                if (bookshelf.books.isEmpty()) {
                    System.out.println(" ** You have no books in the bookshelf **\n");
                }
                System.out.println();
            }else if (userChoice.equals("Q") || userChoice.equals("q")) {
                System.exit( 0 );
            } else {
                System.out.println("Please enter a valid menu key");
            }
            printMenu();
        }

    }

    static void printMenu() {
        System.out.println("----------------------------");
        System.out.println("Menu: ");
        System.out.println("'V' to View Library");
        System.out.println("'A' to Add a Book to library");
        System.out.println("'Q' to quit");
        System.out.println("----------------------------");
    }

    static class Book {
        public int pages;
        public String name;
        // read = 2, reading = 1, not read yet = 0
        public int status;
        public Book(String name, int pages) {
            this.name = name;
            this.pages = pages;
            this.status = 0;
        }

        public void setStatus(int status) {
            this.status = status;
        }
        public int getStatusInt() {
            return this.status;
        }
        public String getStatusString() {
            if (this.status == 0) {
                return "Not started";
            } else if (this.status == 1) {
                return "Currently Reading";
            } else {
                return "Finished Reading";
            }
        }
        public String getName () {
            return name;
        }

        public void setName ( final String name ) {
            this.name = name;
        }

        public int getPages () {
            return pages;
        }

        public void setPages ( final int pages ) {
            this.pages = pages;
        }

        public String toString() {
            return getName() + " (" + getPages() + " pages)";
        }
    }

    static class BookShelf {
        public List<Book> books;

        public BookShelf(List<Book> books) {

        }
        public BookShelf() {
            books = new ArrayList<Book>();
        }

        public List<Book> getBooks () {
            return books;
        }
        public boolean addBook(Book book) {
            return books.add(book);
        }

        public void setBooks ( final List<Book> books ) {
            this.books = books;
        }
    }



}
