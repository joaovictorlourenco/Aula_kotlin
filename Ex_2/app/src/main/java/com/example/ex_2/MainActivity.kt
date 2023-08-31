package com.example.ex_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularMatrizes(view: View) {

        val matrixAInput = findViewById<EditText>(R.id.matrixA)
        val matrixBInput = findViewById<EditText>(R.id.matrixB)
        val matrixSResult = findViewById<TextView>(R.id.matrixSResult)
        val matrixDResult = findViewById<TextView>(R.id.matrixDResult)


        val matrixA = lerMatriz(matrixAInput.text.toString())
        val matrixB = lerMatriz(matrixBInput.text.toString())

        val matrixS = somarMatrizes(matrixA, matrixB)
        val matrixD = subtrairMatrizes(matrixA, matrixB)

        matrixSResult.text = "Matriz S:\n${formatMatrix(matrixS)}"
        matrixDResult.text = "Matriz D:\n${formatMatrix(matrixD)}"
    }

    // Função para ler uma matriz a partir da entrada de texto
    fun lerMatriz(input: String): List<List<Double>> {
        val lines = input.trim().split("\n")
        return lines.map { line ->
            line.trim().split(" ").map { it.toDouble() }
        }
    }

    // Função para somar duas matrizes
    fun somarMatrizes(matriz1: List<List<Double>>, matriz2: List<List<Double>>): List<List<Double>> {
        return matriz1.mapIndexed { i, row ->
            row.mapIndexed { j, value -> value + matriz2[i][j] }
        }
    }

    // Função para subtrair duas matrizes
    fun subtrairMatrizes(matriz1: List<List<Double>>, matriz2: List<List<Double>>): List<List<Double>> {
        return matriz1.mapIndexed { i, row ->
            row.mapIndexed { j, value -> value - matriz2[i][j] }
        }
    }

    // Função para formatar a matriz como uma string
    fun formatMatrix(matrix: List<List<Double>>): String {
        return matrix.joinToString("\n") { row ->
            row.joinToString(" ") { it.toString() }
        }
    }

}