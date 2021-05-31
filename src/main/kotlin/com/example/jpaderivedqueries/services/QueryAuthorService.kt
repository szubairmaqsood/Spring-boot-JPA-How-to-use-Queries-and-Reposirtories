package com.example.jpaderivedqueries.services

import com.example.jpaderivedqueries.models.Author
import com.example.jpaderivedqueries.repositories.QueryAuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class QueryAuthorService {
    var queryAuthorRepository:QueryAuthorRepository;
    @Autowired
    constructor(_queryAuthorRepository:QueryAuthorRepository){
        this.queryAuthorRepository = _queryAuthorRepository;
    }

    fun findByFirstName(firstName:String): Optional<MutableList<Author>> {
        return this.queryAuthorRepository.findByFirstName(firstName);
    }

    fun findByFirstNameAndLastName(firstName:String,lastName:String):Optional<MutableList<Author>>{
        return this.queryAuthorRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    fun findByLastNameOrderByFirstName(lastName:String):Optional<MutableList<Author>>{
        return this.queryAuthorRepository.findByLastNameOrderByFirstName(lastName);
    }

    fun findById(id:Long):Optional<Author>{
        return this.queryAuthorRepository.findById(id);
    }

    fun findByFirstNameContainingIgnoreCase(firstName:String):Optional<MutableList<Author>>{
        return this.queryAuthorRepository.findByFirstNameContainingIgnoreCase(firstName);
    }
}