package com.example.myapplication

class User {
    var first_name: String = ""
    var second_name: String = ""
    var user_email: String = ""
    var user_password: String = ""
    var id: String = ""

    constructor(first_name: String,second_name: String, email: String, password: String, id: String){
        this.first_name = first_name
        this.second_name = second_name
        this.user_email = email
        this.user_password = password
        this.id = id

    }

    constructor(){}
}