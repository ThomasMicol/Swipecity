package com.example.myapplication

interface IMinisterController{
    fun NextMinister()
    fun PreviousMinister()
    fun GetCurrentMinister(): IMinister
}