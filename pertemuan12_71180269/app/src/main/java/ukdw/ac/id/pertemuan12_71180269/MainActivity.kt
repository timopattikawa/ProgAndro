package ukdw.ac.id.pertemuan12_71180269

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)

        val edtKota = findViewById<EditText>(R.id.edtKota)
        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            val url = "https://api.openweathermap.org/data/2.5/forecast?q=${edtKota.text.toString()}&appid=00f850d59f6c354e5b8d5b5bf37f46df"
            val req = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    print("hasil: ${response.toString()}")
                },
                Response.ErrorListener { error ->
                    print("request gagal")
                }
            )
            queue.add(req)
            val tvHariini = findViewById<TextView>(R.id.tvHariIni)
            val tvBesok = findViewById<TextView>(R.id.tvBesok)
            val tvLusa = findViewById<TextView>(R.id.tvLusa)

        }



    }

}