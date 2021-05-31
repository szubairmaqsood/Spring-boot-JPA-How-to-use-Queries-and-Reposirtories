package com.example.jpaderivedqueries.repositories

import com.example.jpaderivedqueries.models.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface QueryAuthorRepository:JpaRepository<Author,Long>{
    /*
    In the Method we use our own queries instead of Derived query by function name
    @Query annotation will be used
    Here JPQL IS USED
    Here I am writing query as per model
     */
    @Query("Select a  from Author a where firstName = ?1")
    fun findByFirstName(firstName:String): Optional<MutableList<Author>>;

    @Query("SELECT a from Author a where a.firstName = ?1 AND a.lastName=?2")
    fun findByFirstNameAndLastName(firstName:String,lastName:String):Optional<MutableList<Author>>;

    /*
    Here Order by clause is used
     */
    @Query("SELECT a from Author a where  a.lastName=?1 ORDER BY firstName ASC")
    fun findByLastNameOrderByFirstName(lastName:String):Optional<MutableList<Author>>;

    /*
    Using Dynamic EntityName
     */
    @Query("SELECT a from #{#entityName} a where  a.id=?1")
    override fun findById(id:Long):Optional<Author>;

    /*
    Use of like operator
     */
    @Query("SELECT a from #{#entityName} a where Upper(firstName) LIKE CONCAT('%',:firstName,'%')")
   fun findByFirstNameContainingIgnoreCase(firstName:String):Optional<MutableList<Author>>




}