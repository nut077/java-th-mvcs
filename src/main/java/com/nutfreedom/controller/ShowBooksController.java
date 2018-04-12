package com.nutfreedom.controller;

import com.nutfreedom.dao.BooksDao;
import com.nutfreedom.dao.BooksDaoImpl;
import com.nutfreedom.db.Database;
import com.nutfreedom.model.Books;
import com.nutfreedom.service.ServicePromotion;
import com.nutfreedom.view.ShowBooks;
import com.nutfreedom.view.ShowBooks2;

import java.util.List;

public class ShowBooksController {
    private ShowBooks2 showBooks;
    private Database database;
    BooksDao booksDao;

    public ShowBooksController(ShowBooks2 showBooks) {
        this.showBooks = showBooks;
        this.showBooks.setVisible(true);

        database = new Database();
        booksDao = new BooksDaoImpl(database);
        showBooks();
        database.close();
    }

    public void showBooks() {
        List<Books> booksList = booksDao.getAllBooks();
        showBooks.showBooks(ServicePromotion.discount(booksList));
    }

}
