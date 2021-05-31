package com.example.jpaderivedqueries.services

import com.example.jpaderivedqueries.models.Author
import com.example.jpaderivedqueries.repositories.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorService {
    var authorRepository: AuthorRepository;
    @Autowired
    constructor(_authorRepository: AuthorRepository){
        this.authorRepository = _authorRepository;
    }
     /*
       Find Authors by First Name
     */
    fun findByFirstName(firstName:String): Optional<MutableList<Author>> {
      var authors  :Optional<MutableList<Author>> = this.authorRepository.findByFirstName(firstName);
       return authors;
    }
    /*
     Find by First and Last Name
     */
    fun findByFirstNameAndLastName(firstName:String, lastName:String):Optional<MutableList<Author>>{
        var authors  :Optional<MutableList<Author>> = this.authorRepository.findByFirstNameAndLastName(firstName,lastName);
        return authors;
    }

    /*
   Find by First Or Last Name
   */
    fun findByFirstNameOrLastName(firstName:String, lastName:String):Optional<MutableList<Author>>{
        var authors  :Optional<MutableList<Author>> = this.authorRepository.findByFirstNameOrLastName(firstName,lastName);
        return authors;
    }

    /*
    Find by book Title

     */
    fun findByBookTitle(title:String):Optional<MutableList<Author>>{
        var authors  :Optional<MutableList<Author>> = this.authorRepository.findByBooksTitle(title);
        return authors;
    }
    /*
    Find a author whose first name contains provided string
    Ignore case of data in data base as well case of provided string
     */
    fun findByFirstNameContainingIgnoreCase(firstName:String):Optional<MutableList<Author>>{
        var authors  :Optional<MutableList<Author>> = this.authorRepository.findByFirstNameContainingIgnoreCase(firstName);
        return authors;
    }




}