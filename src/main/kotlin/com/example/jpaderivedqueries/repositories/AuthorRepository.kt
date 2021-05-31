package com.example.jpaderivedqueries.repositories

import com.example.jpaderivedqueries.models.Author
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
/*
Here while extending
1.Model Name
2.Primary key type of Model Name
 */
interface AuthorRepository:JpaRepository<Author,Long> {
    /*
     1.It is a derived query concept
     findBy key word is used after this entity property name is used
     */
    fun findByFirstName(firstName:String): Optional<MutableList<Author>>;

    /*
    2.use of "and" Key word is used here
     */
    fun findByFirstNameAndLastName(firstName:String, lastName:String):Optional<MutableList<Author>>;


    /*
     3.use of "or" keyword is used here
     */
    fun findByFirstNameOrLastName(firstName:String, lastName:String):Optional<MutableList<Author>>;

    /*
    Search based on value present in assosiated entity
    1.Use keywork findBy
    2.Associated entity name which is books (plural)
    3.Title is the property of book
    4.But it is retuning authors
    */

    fun findByBooksTitle(title:String):Optional<MutableList<Author>>;

    /*
    1.using containing
    2.ignore the case of column as well as parameter
     */
    fun findByFirstNameContainingIgnoreCase(firstName:String):Optional<MutableList<Author>>;


}