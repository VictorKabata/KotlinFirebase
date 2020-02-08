package com.vickikbt.kotlinfirebase.model

class Users(val Username: String, val Email: String, val UID: String, val ProfileImageUrl: String){
    constructor(): this("", "", "" ,"")
}
