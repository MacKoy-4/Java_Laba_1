package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Додати книгу");
            System.out.println("2. Показати всі книги");
            System.out.println("3. Знайти книгу за назвою");
            System.out.println("4. Видалити книгу за ISBN");
            System.out.println("5. Вийти");
            System.out.print("Оберіть дію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть назву книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введіть автора: ");
                    String author = scanner.nextLine();
                    System.out.print("Введіть ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Введіть рік видання: ");
                    int publicationYear = scanner.nextInt();
                    scanner.nextLine();
                    Book book = new Book(title, author, isbn, publicationYear);
                    library.addBook(book);
                    System.out.println("Книга додана до бібліотеки.");
                    break;
                case 2:
                    library.showAllBooks();
                    break;
                case 3:
                    System.out.print("Введіть назву книги для пошуку: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Знайдена книга:\n" + foundBook);
                    } else {
                        System.out.println("Книгу не знайдено.");
                    }
                    break;
                case 4:
                    System.out.print("Введіть ISBN книги для видалення: ");
                    String removeISBN = scanner.nextLine();
                    library.removeBookByISBN(removeISBN);
                    System.out.println("Книгу видалено з бібліотеки.");
                    break;
                case 5:
                    System.out.println("Дякуємо за використання програми!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }
}