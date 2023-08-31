package br.com.murilodio.trabalho1_5

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var bt_Calcular : Button
    lateinit var tv_Resultado : TextView
    lateinit var tv_Resultado2 : TextView
    lateinit var tv_Matrix : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_Calcular = findViewById(R.id.btCalcular)
        tv_Resultado = findViewById(R.id.tvResultado)
        tv_Resultado2 = findViewById(R.id.tvResultado2)
        tv_Matrix = findViewById(R.id.tvMatrix)

        var linha = 5
        var coluna = 5
        val sl = IntArray(5){0}
        val sc = IntArray(5){0}
        val m = Array(linha) { IntArray(coluna) { 0 } }
        val matrixA = StringBuilder()
        val vetorSL = StringBuilder()
        val vetorSC = StringBuilder()

        for (i in 0 until linha) {
            for (j in 0 until coluna) {
                m[i][j] = i + 3 * coluna + j * 2
                matrixA.append("${m[i][j]} \t")
            }
            matrixA.append("\n")
        }

        tv_Matrix.text = matrixA

        fun percorre(matrix: Array<IntArray>) {
            for (i in matrix.indices) {
                for (j in matrix.indices) {
                    sl[i] = m[i].sum()
                    sc[i] += m[j][i]
                    if(j == 0) {
                        vetorSL.append("${sl[i]} \t")
                    }
                }
                vetorSC.append("${sc[i]} \t")
            }
        }

        bt_Calcular.setOnClickListener{
            percorre(m)
            tv_Resultado.text = vetorSL
            tv_Resultado2.text = vetorSC
        }
    }
}