package com.android.appmovilmisiontic.bd

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper(context: Context):SQLiteOpenHelper(context, "usuarios.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion="CREATE TABLE usuarios"+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT,email TEXT,password TEXT)"
        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado="DROP TABLE IF EXISTS usuarios"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

    fun anyadirdato(nombre:String, email:String, password: String){
        val datos= ContentValues()  //mainipulacion de datos Clave Valor
        datos.put("nombre",nombre)
        datos.put("email",email)
        datos.put("password", password)

        //guardar los datos
        val db=this.writableDatabase  // la base de datos se pone en modo de escritura
        db.insert("usuarios",null,datos)
        db.close()
    }


}