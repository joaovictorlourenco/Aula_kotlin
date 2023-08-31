package br.com.murilodio.trabalho1_3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var bt_Buscar : Button
    lateinit var ed_Number : EditText
    lateinit var tv_Resultado : TextView
    lateinit var tv_Matrix : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_Buscar = findViewById(R.id.btBuscar)
        ed_Number = findViewById<EditText>(R.id.edTextNumber)
        tv_Resultado = findViewById(R.id.tvResultado)
        tv_Matrix = findViewById(R.id.tvMatrix)

        var linha = 5
        var coluna = 5
        val m = Array(linha) { IntArray(coluna) { 0 } }
        val matrix = StringBuilder()

        for (i in 0 until linha) {
            for (j in 0 until coluna) {
                m[i][j] = i * coluna + j
                matrix.append("${m[i][j]} \t")
            }
            matrix.append("\n")
        }

        tv_Matrix.text = matrix

        fun containsMatriz(matrix: Array<IntArray>, number: Int): Boolean {
            for (i in matrix) {
                if (number in i) {
                    return true
                }
            }
            return false
        }

        bt_Buscar.setOnClickListener{
            val value = ed_Number.text.toString()

            val existe = containsMatriz(m, value.toInt())

            if (existe){
                tv_Resultado.text = "O valor existe dentro da matrix"
            }else{
                tv_Resultado.text = "O não existe dentro da matrix"
            }
        }
    }
}