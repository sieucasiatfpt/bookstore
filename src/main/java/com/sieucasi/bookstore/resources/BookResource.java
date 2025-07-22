/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sieucasi.bookstore.resources;

import com.sieucasi.bookstore.model.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SieuCaSi
 */

@Path("/books")
public class BookResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    public String sayHello() {
//        return "Xin chào. Welcome to API World!"
//                + " A journey of a thousand miles begins with a single step.";
//    }
    public List<Book> getAll() {
        List<Book> list = new ArrayList();
        list.add(new Book("6911225907262", "Tuổi Trẻ Đáng Giá Bao Nhiêu", "Rosie Nguyễn", 2, 2018));
        list.add(new Book("7292086764911", "Những Cô Gái Tốt Đều Phải Sống Rực Rỡ", "Yến Lăng Dương", 1, 2020));
        
        return list;
    }
}
