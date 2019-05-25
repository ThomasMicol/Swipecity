package com.example.myapplication

class BaseMinisterController : IMinisterController{

    lateinit var startMinister: IMinister
    lateinit var currentMinister: IMinister

    constructor(){
        this.startMinister = BaseMinister()
    }

    override fun NextMinister() {
        this.currentMinister = this.startMinister
    }

    override fun PreviousMinister() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun GetCurrentMinister(): IMinister {
        return this.currentMinister
    }

}

