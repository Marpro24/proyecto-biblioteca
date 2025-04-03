package com.biblioteca;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

import com.biblioteca.controller.BookController;
import com.biblioteca.model.Book;
import com.biblioteca.model.BookDAO;
import com.biblioteca.view.BookView;
public class App 
{
    public static void main( String[] args )
    {
        Dotenv dotenv = Dotenv.load();
        String dbHost = dotenv.get("DB_HOST");
        System.out.println("Database Host: " + dbHost);

        
        System.out.println( "Biblioteca Proyect" );
        BookDAO bookDAO = new BookDAO();
        BookController bookController = new BookController(bookDAO);
        BookView bookView = new BookView(bookController);

        bookView.showMenu();
        bookView.createBook();
        bookView.findBookByTitle();
        bookView.updateBook();
        bookView.deleteBook();
        bookView.findBookByAuthor();
        bookView.findBookByGenre();
        List<Book> books = bookController.getAllBooks();
        bookView.displayBooks(books);

       
        
    }
}
