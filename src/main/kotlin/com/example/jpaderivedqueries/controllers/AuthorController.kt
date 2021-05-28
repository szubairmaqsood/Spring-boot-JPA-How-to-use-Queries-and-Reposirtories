package com.example.jpaderivedqueries.controllers

import com.example.jpaderivedqueries.models.Author
import com.example.jpaderivedqueries.services.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class AuthorController {

    var authorService:AuthorService;
    @Autowired
    constructor(_authorService:AuthorService){
        this.authorService = _authorService;
    }

    @GetMapping("api/v1/Author/FindByFirstName/{firstName}")
    fun findAuthorByFirstName(@PathVariable firstName: String): ResponseEntity<Optional<MutableList<Author>>> {
        var authors  :Optional<MutableList<Author>> = this.authorService.findByFirstName(firstName);
        if(authors.isPresent){
            return  ResponseEntity(authors, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("api/v1/Author/FindByFirstNameAndLastName/{firstName}/{lastName}")
    fun findAuthorByFirstNameAndLastName(@PathVariable firstName: String,@PathVariable lastName: String): ResponseEntity<Optional<MutableList<Author>>> {
        var authors:Optional<MutableList<Author>> = this.authorService.findByFirstNameAndLastName(firstName, lastName);
        if(authors.isPresent){
            return  ResponseEntity(authors, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("api/v1/Author/FindByFirstNameOrLastName/{firstName}/{lastName}")
    fun findAuthorByFirstNameOrLastName(@PathVariable firstName: String,@PathVariable lastName: String): ResponseEntity<Optional<MutableList<Author>>> {
        var authors:Optional<MutableList<Author>> = this.authorService.findByFirstNameOrLastName(firstName, lastName);
        if(authors.isPresent){
            return  ResponseEntity(authors, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }

    }


}