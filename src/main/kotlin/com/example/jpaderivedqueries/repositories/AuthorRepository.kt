package com.example.jpaderivedqueries.repositories

import com.example.jpaderivedqueries.models.Author
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

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



}