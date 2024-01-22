package dao;

import java.util.List;

import Model.Books;

public interface bookDao {
       Books addBook(Books book);
       List<Books> getAllBooks();

}
