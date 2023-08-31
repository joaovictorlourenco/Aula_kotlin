package com.example.trabalho_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Random
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var botaoEnviar : Button
    lateinit var resultado : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        resultado  = findViewById(R.id.resultado)
        botaoEnviar = findViewById(R.id.buttonEnviar)

        val random = Random()

        botaoEnviar.setOnClickListener {


            val matrix = Array(5) { IntArray(5) { 0 } }

            for (i in 0 until 5) {
                for (j in 0 until 5) {
                    matrix[i][j] = random.nextInt(101)
                }
            }

            val matrixString = StringBuilder()

            for (row in matrix) {
                for (num in row) {
                    matrixString.append("$num\t")
                }
                matrixString.append("\n")
            }


            resultado.text = matrixString.toString()

            val sum2 = findViewById<TextView>(R.id.sum2)

            sum2.text = """
                
                Soma da linha 3 : ${matrix[2].sum()}
                Soma da coluna 2: ${matrix.sumOf { it[1] }}
                Soma da diagonal principal: ${matrix.indices.sumOf { matrix[it][it] }}
                Soma da diagonal secundária : ${matrix.indices.sumOf { matrix[it][4 - it] } }
                Soma do elementos da matriz : ${ somarMatriz(matrix)} 

                """.trimIndent()

        }

    }

    fun somarMatriz(matriz: Array<IntArray>): Int {
        var soma = 0
        for (linha in matriz) {
            for (valor in linha) {
                soma += valor
            }
        }
        return soma
    }
}

