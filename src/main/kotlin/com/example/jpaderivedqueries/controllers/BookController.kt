package com.example.jpaderivedqueries.controllers

import com.example.jpaderivedqueries.models.Author
import com.example.jpaderivedqueries.models.Book
import com.example.jpaderivedqueries.services.AuthorService
import com.example.jpaderivedqueries.services.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BookController {
    var bookService: BookService;
    @Autowired
    constructor(_bookService: BookService){
        this.bookService = _bookService;
    }

    /*
     Find  A Book by given title
     */
    @GetMapping("api/v1/Book/findByTitle/{title}")
    fun findBookByTitle(@PathVariable title: String): ResponseEntity<Optional<MutableList<Book>>> {
        var books  : Optional<MutableList<Book>> = this.bookService.findByTitle(title);
        if(books.isPresent){
            return  ResponseEntity(books, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }
    /*
    Find by title in ascending order
     */

    @GetMapping("api/v1/Book/findByTitleOrderByTitleAsc/{title}")
    fun findByTitleOrderByTitleAsc(@PathVariable title: String): ResponseEntity<Optional<MutableList<Book>>> {
        var books  : Optional<MutableList<Book>> = this.bookService.findByTitleOrderbyTitleAsc(title);
        if(books.isPresent){
            return  ResponseEntity(books, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("api/v1/Book/findFirst2ByTitleContainsOrderByTitleAsc/{title}")
    fun findFirst2ByTitleContainsOrderByTitleAsc(@PathVariable title: String): ResponseEntity<Optional<MutableList<Book>>> {
        var books  : Optional<MutableList<Book>> = this.bookService.findFirst2ByTitleContainsOrderByTitleAsc(title);
        if(books.isPresent){
            return  ResponseEntity(books, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }
 /*
  Find data by pages
  */
    @GetMapping("api/v1/Book/findAll")
    fun findAll(): ResponseEntity<Page<Book>> {

        var books  :Page<Book> = this.bookService.findAll(PageRequest.of(0,2));
        if(!books.isEmpty){
            return  ResponseEntity(books, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

}