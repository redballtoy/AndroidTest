package com.example.redballtoy.mvpsimplesample

import android.content.Context

//Start Domain - Presenter layer - Business Logic layer
//In this layer, we cannot interact with the platform layer
//The business logic layer should be platform independent
class Presenter(private val resolver: ResResolver) {
    fun onError() = resolver.getString(R.string.app_name)
}

//Presenter has link to View via Interface
interface ResResolver {
    fun getString(id: Int): String
}

interface View
//End Domain


//Start Platform - View Layer, has context
//The platform itself implements the interface
//This is called Dependency Inversion here.
//There is an interface at the level of business logic, but it is implemented
//in another layer at the platform level, where it has access to the context
class ResResolverImpl(private val context: Context) : ResResolver {
    override fun getString(id: Int) = context.getString(id)
    class Fragment : View
}
