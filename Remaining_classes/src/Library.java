public class Library {
    private String name;

    public Library(String name) {
        this.name = name;
        System.out.println("Library: " + name);
    }

    public class Book {
        private String title;

        public Book(String title) {
            this.title = title;
            System.out.println("Book added: " + title);
        }

        public void disLoc() {
            System.out.println(title + " at " + name);
        }
    }

    public Book addBook(String title) {
        return new Book(title);
    }

    public static void main(String[] args) {
        Library library = new Library("City Central Library");

        Library.Book book1 = library.new Book("Hindi Book");
        book1.disLoc();

        Library.Book book2 = library.addBook("Short Stories");
        book2.disLoc();
    }
}
