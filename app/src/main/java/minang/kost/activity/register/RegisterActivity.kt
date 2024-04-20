package minang.kost.activity.register

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import minang.kost.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        goToLoginPage()
        viewAccountTypeDropDown()
    }

    private fun goToLoginPage() {
        val btnLogin = findViewById<Button>(R.id.btn_login_register)
        btnLogin.setOnClickListener {
            finish()
        }
    }

    private fun viewAccountTypeDropDown() {
        val accountTypes = listOf("Pemilik Kost", "Penyewa Kost")
        val acType = findViewById<AutoCompleteTextView>(R.id.ac_type_register)
        val adapter = ArrayAdapter(this, R.layout.list_item, accountTypes)
        acType.setAdapter(adapter)
        acType.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, _, position, _ ->
                val selected = adapterView.getItemAtPosition(position)
                Toast.makeText(this, "Item : $selected", Toast.LENGTH_SHORT).show()
            }
    }
}