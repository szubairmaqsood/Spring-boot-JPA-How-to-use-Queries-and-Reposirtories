package com.example.jpaderivedqueries.models

import javax.persistence.*

@Entity
@Table(name = "Author")
class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private var id:Long;
    private var version:Int;
    private var firstName:String;
    private var lastName:String;
    /*
    It is name of property in Books ,but how to solve conflict
     */
    @ManyToMany(mappedBy = "authors")
    private var books:MutableList<Book>?;


    constructor(){
        this.id = 0;
        this.version = 1;
        this.firstName = "";
        this.lastName = "";
        this.books = null;
    }

    constructor(_version:Int,_firstName:String,_lastName:String,_books:MutableList<Book>){
        this.id = 0;
        this.version = _version;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.books = _books;
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

    fun getFirstName():String{
        return this.firstName;
    }
    fun setFirstName(_firstName: String):Unit{
            this.firstName = firstName;
    }

    fun getLastName():String{
        return this.lastName;
    }
    fun setLastName(_lastName:String):Unit{
        this.lastName = _lastName;
    }


    fun getBooks():List<Book>?{
        return this.books;
    }


    fun setBooks( _books:MutableList<Book>?):Unit{
        this.books = _books;
    }

    fun addBook(b:Book):Unit{
        this.books?.add(b);
   }

    fun removeBook(b:Book):Unit{
        this.books?.remove(b);
    }




}