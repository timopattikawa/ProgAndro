package ukdw.ac.id.pertemuan7_71180269

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listContact = arrayListOf<Contact>()
        listContact.add(Contact(1,"Abraham", "082222222222", "abraham@gmail.com"))
        listContact.add(Contact(2, "Timotius Pattikawa", "081111111111", "timo@gmail.com"))
        listContact.add(Contact(3, "Budi", "083333333333", "budi@gmail.com"))
        listContact.add(Contact(4, "Antonius", "084444444444", "antonius@gmail.com"))

        val rcyContact = findViewById<RecyclerView>(R.id.rcyContact)
        rcyContact.layoutManager = LinearLayoutManager(this)
        val adapter = ContactAdapter(listContact, this)
        rcyContact.adapter = adapter
    }
}