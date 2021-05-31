package com.example.jpaderivedqueries.repositories

import com.example.jpaderivedqueries.models.Book
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/*
Here while extending
1.Model Name
2.Primary key type of Model Name
 */
interface BookRepository: JpaRepository<Book, Long> {
    /*
    Use of find by key word
     */
    fun findByTitle(title:String): Optional<MutableList<Book>>;
   /*
   Use of order by clause in ascending order containing title
    */
    fun findByTitleContainsOrderByTitleAsc(title:String):Optional<MutableList<Book>>;
    /*
    Find first  2 books containing given string in ascending order
    So limit is actually used underneath
     */
    fun findFirst2ByTitleContainsOrderByTitleAsc(title:String):Optional<MutableList<Book>>

    /*
    See data in forms of pages
     */
    override fun findAll(pageable: Pageable): Page<Book>;
}