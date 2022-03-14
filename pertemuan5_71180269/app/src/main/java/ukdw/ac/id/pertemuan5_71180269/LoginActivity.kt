package ukdw.ac.id.pertemuan5_71180269

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtUsername = findViewById<EditText>(R.id.edtUsername).text
        val edtPassword = findViewById<EditText>(R.id.edtPassword).text
        val btnLogin = findViewById<Button>(R.id.button)

        btnLogin.setOnClickListener {
            if (checkLogin(edtUsername.toString(), edtPassword.toString())) {
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("username", edtUsername)
                startActivity(i)
            } else {
                callToast("wrong username or password")
            }
        }

    }

    fun checkLogin(username: String, password: String): Boolean {
        if(username == "admin" && password == "admin123") {
            return true
        }
        return false
    }

    fun callToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }



}