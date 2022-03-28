package ukdw.ac.id.pertemuan7_71180269

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val notelp = intent.getStringExtra("notelp")

        var tvName = findViewById<TextView>(R.id.tvNameDetail)
        var tvTelp = findViewById<TextView>(R.id.tvNoTelpDetail)
        var tvEmail = findViewById<TextView>(R.id.tvEmailDetail)

        tvName.setText(name)
        tvTelp.setText(notelp)
        tvEmail.setText(email)
    }
}