package com.nutfreedom.service;

import com.nutfreedom.model.Books;

import java.util.ArrayList;
import java.util.List;

public class ServicePromotion {

    public static List<Books> discount(List<Books> booksList) {
        List<Books> newPriceList = new ArrayList<Books>();
        for (Books aBooksList : booksList) {
            if (aBooksList.getPrice() > 5) {
                aBooksList.setPrice(aBooksList.getPrice() - 5);
            }

            Books book = new Books(aBooksList.getId(), aBooksList.getTitle(), aBooksList.getPrice());
            newPriceList.add(book);
        }
        return newPriceList;
    }
}
