package com.example.jpaderivedqueries.controllers

import com.example.jpaderivedqueries.models.Author
import com.example.jpaderivedqueries.services.AuthorService
import com.example.jpaderivedqueries.services.QueryAuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class QueryAuthorController {
    var queryAuthorService: QueryAuthorService;
    @Autowired
    constructor(_queryAuthorService:QueryAuthorService){
        this.queryAuthorService = _queryAuthorService;
    }

    @GetMapping("api/v1/QueryAuthor/FindByFirstName/{firstName}")
    fun findAuthorByFirstName(@PathVariable firstName: String): ResponseEntity<Optional<MutableList<Author>>> {
        var authors  : Optional<MutableList<Author>> = this.queryAuthorService.findByFirstName(firstName);
        if(authors.isPresent){
            return  ResponseEntity(authors, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("api/v1/QueryAuthor/FindByFirstNameAndLastName/{firstName}/{lastName}")
    fun findAuthorByFirstNameAndLastName(@PathVariable firstName: String,@PathVariable lastName: String): ResponseEntity<Optional<MutableList<Author>>> {
        var authors:Optional<MutableList<Author>> = this.queryAuthorService.findByFirstNameAndLastName(firstName, lastName);
        if(authors.isPresent){
            return  ResponseEntity(authors, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("api/v1/QueryAuthor/findByLastNameOrderByFirstName/{lastName}")
    fun findAuthorByFirstNameAndLastName(@PathVariable lastName: String): ResponseEntity<Optional<MutableList<Author>>> {
        var authors:Optional<MutableList<Author>> = this.queryAuthorService.findByLastNameOrderByFirstName(lastName);
        if(authors.isPresent){
            return  ResponseEntity(authors, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("api/v1/QueryAuthor/findById/{id}")
    fun findById(@PathVariable id:Long): ResponseEntity<Optional<Author>> {
        var authors:Optional<Author> = this.queryAuthorService.findById(id);
        if(authors.isPresent){
            return  ResponseEntity(authors, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("api/v1/QueryAuthor/findByFirstNameContainingIgnoreCase/{firstName}")
    fun findByFirstNameContainingIgnoreCase(@PathVariable  firstName:String):ResponseEntity<Optional<MutableList<Author>>>{
        var authors:Optional<MutableList<Author>> = this.queryAuthorService.findByFirstNameContainingIgnoreCase(firstName);
        if(authors.isPresent){
            return  ResponseEntity(authors, HttpStatus.OK);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }


}