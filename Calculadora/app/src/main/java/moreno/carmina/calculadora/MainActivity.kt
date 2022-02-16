package moreno.carmina.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var operacion : Int = 0
    var numero : Double = 0.0
    lateinit var tvPrimero : TextView
    lateinit var tvSegundo : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPrimero = findViewById(R.id.tvPrimerNumero)
        tvSegundo = findViewById(R.id.tvSegundoNumero)

        val borrar: Button = findViewById(R.id.btnBorrar)
        val igual:Button = findViewById(R.id.btnIgual)

        igual.setOnClickListener {
            var numero2 : Double = tvSegundo.toString().toDouble()
            var resultado : Double = 0.0
            when(operacion){
                1 -> resultado = numero + numero2
                2 -> resultado = numero - numero2
                3 -> resultado = numero * numero2
                4 -> resultado = numero / numero2
            }
            tvSegundo.setText(resultado.toString())
            tvPrimero.setText("")
        }

        borrar.setOnClickListener {
            tvPrimero.setText("")
            tvSegundo.setText("")
            numero = 0.0
            operacion = 0
        }
    }

    fun presionarNumero(view:View){
        var segundoNumero : String = tvSegundo.text.toString()

        when(view.id){
            R.id.btn0 -> tvSegundo.setText(segundoNumero + "0")
            R.id.btn1 -> tvSegundo.setText(segundoNumero + "1")
            R.id.btn2 -> tvSegundo.setText(segundoNumero + "2")
            R.id.btn3 -> tvSegundo.setText(segundoNumero + "3")
            R.id.btn4 -> tvSegundo.setText(segundoNumero + "4")
            R.id.btn5 -> tvSegundo.setText(segundoNumero + "5")
            R.id.btn6 -> tvSegundo.setText(segundoNumero + "6")
            R.id.btn7 -> tvSegundo.setText(segundoNumero + "7")
            R.id.btn8 -> tvSegundo.setText(segundoNumero + "8")
            R.id.btn9 -> tvSegundo.setText(segundoNumero + "9")
        }

    }

    fun presionarOperacion(view : View){
        numero = tvSegundo.text.toString().toDouble();
        var numeroSegundo : String = tvSegundo.text.toString()
        tvSegundo.setText("")
        when(view.id){
            R.id.btnSuma ->{ //Suma -> 1
                tvPrimero.setText(numeroSegundo + "+")
                operacion = 1
            }
            R.id.btnMenos ->{ //Resta -> 2
                tvPrimero.setText(numeroSegundo + "-")
                operacion = 2
            }
            R.id.btnMultiplicacion ->{ //Multiplicacion -> 3
                tvPrimero.setText(numeroSegundo + "x")
                operacion = 3
            }
            R.id.btnDivision ->{ //Division -> 4
                tvPrimero.setText(numeroSegundo + "/")
                operacion = 4
            }
        }
    }
}