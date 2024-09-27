package com.example.firstproject
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstproject.R.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val txtNom : EditText = findViewById(id.TxtName)
        val btnOk: Button = findViewById(id.BtnOk)
        val lblNom: TextView = findViewById(id.LblNom)
        btnOk.setOnLongClickListener() {
            var text = txtNom.getText().toString()
            val radMetro = findViewById<RadioButton>(R.id.RadMetro)
            val radPatinete = findViewById<RadioButton>(R.id.RadPatinete)
            val radMoto = findViewById<RadioButton>(R.id.RadMoto)
            val grpTransporte = findViewById<RadioGroup>(R.id.GrpTransporte)


            if (!text.equals(""))
            {
                lblNom.text = "Tu nombre es: " + text
            }
            else
            {
                Toast.makeText(this, "No introduciste tu nombre", Toast.LENGTH_LONG).show()
                txtNom.setBackgroundColor(Color.RED)
            }

            radMoto.setOnClickListener() {
                updateTransport(radMoto)
            }
            radPatinete.setOnClickListener() {
                updateTransport(radPatinete)
            }
            radMetro.setOnClickListener() {
                updateTransport(radMetro)
            }
            true
        }
    }

    fun updateTransport(button: RadioButton) {
        val lblRadioNombre = findViewById<TextView>(R.id.LblRadioNombre)
        val name = button.text.toString()
        lblRadioNombre.text = "Te desplazas en " + name
    }
}



