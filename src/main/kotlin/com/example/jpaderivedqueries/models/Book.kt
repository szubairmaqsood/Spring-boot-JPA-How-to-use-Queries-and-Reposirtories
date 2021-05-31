package com.example.jpaderivedqueries.models

import javax.persistence.*

@Entity
@Table(name = "Book")
class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private var id:Long;
    private var version:Int;
    private var title:String;
    /*
    It is for many to many relationship
    join column is for this model
    and Inverse join column is for other model
     */
    @ManyToMany
    @JoinTable( name = "book_author",
                joinColumns = [ JoinColumn(name ="fk_books")],
                inverseJoinColumns= [ JoinColumn(name ="fk_author")]
    )



    private var authors:MutableList<Author>?;

    constructor(){
        this.id = 0;
        this.version = 1;
        this.title = "";
        this.authors = null;
    }

    constructor(_version:Int,_title:String,_authors:MutableList<Author>){
        this.id = 0;
        this.version = _version;
        this.title = _title;
        this.authors = _authors;
    }

    fun getID():Long{
        return this.id;
    }
    fun setID(_id:Long):Unit{
        this.id = _id;
    }

    fun getVersion():Int{
        return this.version;
    }
    fun setVersion():Unit{
        this.version = version;
    }

    fun getTitle():String{
        return this.title;
    }
    fun setTitle(_title: String):Unit{
        this.title = _title ;
    }

    fun getAuthors():MutableList<Author>?{
        return this.authors;
    }

    fun setAuthors( _authors:MutableList<Author>?):Unit{
        this.authors = _authors;
    }

    fun addAuthor(_author:Author):Unit{
        this.authors?.add(_author);
    }

    fun removeAuthor(_author:Author):Unit{
        this.authors?.remove(_author);
    }


}