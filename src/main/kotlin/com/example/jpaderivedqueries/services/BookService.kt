package com.example.jpaderivedqueries.services

import com.example.jpaderivedqueries.models.Author
import com.example.jpaderivedqueries.models.Book
import com.example.jpaderivedqueries.repositories.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService {
    var bookRepository:BookRepository;
    @Autowired
    constructor(_bookRepository:BookRepository){
        this.bookRepository = _bookRepository;
    }

    fun findByTitle(title:String): Optional<MutableList<Book>> {
        var books  :Optional<MutableList<Book>> = this.bookRepository.findByTitle(title);
        return books;
    }

    fun findByTitleOrderbyTitleAsc(title:String): Optional<MutableList<Book>> {
        var books  :Optional<MutableList<Book>> = this.bookRepository.findByTitleContainsOrderByTitleAsc(title);
        return books;
    }

    fun findFirst2ByTitleContainsOrderByTitleAsc(title:String): Optional<MutableList<Book>> {
        var books  :Optional<MutableList<Book>> = this.bookRepository.findFirst2ByTitleContainsOrderByTitleAsc(title);
        return books;
    }

    fun findAll(pageable: Pageable): Page<Book> {
        var books  :Page<Book> = this.bookRepository.findAll(pageable);
        return books;
    }
}