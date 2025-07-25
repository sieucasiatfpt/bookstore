/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sieucasi.bookstore.resources;

import com.sieucasi.bookstore.model.Book;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
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
    
    @GET
    @Path("one")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getABook() {
        return new Book("6911225907262", "Tuổi Trẻ Đáng Giá Bao Nhiêu", "Rosie Nguyễn", 2, 2018);
    }
    
//    @GET
//    @Path("{isbn}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Book getBy(@PathParam("isbn") String isbn) {
//        System.out.println("Test path-param value: " + isbn);
//        return new Book(isbn, "Tuổi Trẻ Đáng Giá Bao Nhiêu", "Rosie Nguyễn", 2, 2018);
//    }
    
    //độ HTTP code 
    @GET
    @Path("{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBy(@PathParam("isbn") String isbn) {
        
        Book book = new Book(isbn, "Tuổi Trẻ Đáng Giá Bao Nhiêu", "Rosie Nguyễn", 2, 2018);
        Response msg = Response.status(999).entity(book).build();
        
        return msg; //chủ động đóng gói 1 HTTP Response Msg trả về
    }
    
    //khai báo biến ở đây cho gần, đúng chuẩn cần để lên đầu class
    @Context UriInfo ui; //object gọi đến 1 phần Tommcat để xin URl mà Tomcat đang quản lý
    
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Book book) throws URISyntaxException{
        //gọi DAO để insert cuốn sách 
        //tạm sout (toString cuốn sách
        //nếu in đúng thì nghĩa là đã đưa info lên server đc rồi
        //phần còn lại của Java Web đã học
        
        System.out.println("Create a new book: " + book);
        
        //tôi sẽ trả về đường dẫn trỏ đến cuốn sách vừa tạo mới!
        //mình đã gõ, chuyển info cuốn sách lên sever, gồm mã sách
        //nếu insert thành công thì ...api/books/mã-sách-vừa-chèn-thành-công
        //sẽ là url để get lại cuốn sách đó
        URI url = new URI(ui.getBaseUri() + "books/" + book.getIsbn());
        
        Response msg = Response.created(url).build();
        return msg;
    }
}
