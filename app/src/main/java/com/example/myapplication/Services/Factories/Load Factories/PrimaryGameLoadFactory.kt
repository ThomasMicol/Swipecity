package com.example.myapplication

class PrimaryGameLoadFactory
{
    protected val PersistanceProvider: IPersistanceProvider

    constructor(persistance_provider: IPersistanceProvider)
    {
        this.PersistanceProvider = persistance_provider
    }

    fun GetMinisterController(): IMinisterController
    {
        return BaseMinisterController()
    }
}