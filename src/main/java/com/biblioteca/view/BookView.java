package com.biblioteca.view;
import java.util.Scanner;

import com.biblioteca.controller.BookController;
import com.biblioteca.model.Book;

public class BookView {
  private BookController bookController;

  public BookView(BookController bookController){ 
    this.bookController = bookController;
  }

  public void createBook(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa un titulo ");
    String title = scanner.nextLine();
    System.out.println("Ingresa un autor");
    String author = scanner.nextLine();
    System.out.println("Ingresa el ISBN");
    int isbn = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Ingresa descripción del libro");
    String description = scanner.nextLine();
    System.out.println("Ingresa género del libro");
    String genre = scanner.nextLine();
   
    Book book = new Book(title, genre, author, description, isbn );
    bookController.createBook(book);
   
    scanner.close();
    
  }

  public void deleteBook(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa el id del libro a eliminar");
    int id = scanner.nextInt();
    if (id <= 0) {
      System.out.println("El id no puede ser menor o igual a 0.");
    }else{
      bookController.deleteBook(id);
    }
    scanner.close();
    
  }
}
