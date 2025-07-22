/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sieucasi.bookstore.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author SieuCaSi
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book implements Serializable {
    private String isbn;
    private String title;
    private String author;
    private int edition;
    private int publishedYear;
    
    
}
