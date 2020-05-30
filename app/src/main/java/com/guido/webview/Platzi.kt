package com.guido.webview

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Cursos(val nombre: String, val url: String)

class Platzi : AppCompatActivity() {

    private val react = Cursos("React", "react")
    private val kot = Cursos("Kotlin", "kotlin")
    private var cursoActual = react.copy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.btn_enviar)
        boton.setOnClickListener {
            //view -> verEnPantalla("Oh señoda, me ha dado click")
            switchCurso(cursoActual)
        }
    }

    private fun switchCurso(curso: Cursos) {
        cursoActual = curso.copy()
        when (curso.url) {
            "react" -> cursoActual = kot.copy()
            "kotlin" -> cursoActual = react.copy()
            else -> print("This never will happen")
        }

        verEnPantalla("Curso de ${cursoActual.nombre} en tumami.com/${cursoActual.url}")
    }

    private fun verEnPantalla(s: String) {
        findViewById<TextView>(R.id.textView).apply {
            text = s
        }
    }
}
