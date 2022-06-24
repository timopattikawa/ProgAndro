package ukdw.ac.id.tugasakhir_71180269

import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class AddFragment: Fragment() {

    val db = Firebase.firestore


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)


        val btnSimpanBuku = view.findViewById<Button>(R.id.btnSimpanBuku)

        btnSimpanBuku.setOnClickListener {
            val edtJudulBuku = view.findViewById<EditText>(R.id.edtJudulBuku)
            val edtNamaPenulis = view.findViewById<EditText>(R.id.edtNamaPenulis)
            val edtNamaPenerbit = view.findViewById<EditText>(R.id.edtNamaPenerbit)
            val edtTahunTerbit = view.findViewById<EditText>(R.id.edtTahunTerbit)
            val edtJumlahHalaman = view.findViewById<EditText>(R.id.edtJumlahHalaman)
            val buku = Buku(edtJudulBuku.text.toString(),
                edtNamaPenulis.text.toString(),
                edtNamaPenerbit.text.toString(),
                edtTahunTerbit.text.toString(),
                edtJumlahHalaman.text.toString())
            db.collection("buku")
                .add(buku)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(activity, "Berhasil menambah Data", Toast.LENGTH_LONG)
                    Log.d("DB_Check", "DocumentSnapshot added with ID: ${documentReference.id}")
                    edtJudulBuku.setText("")
                    edtNamaPenulis.setText("")
                    edtNamaPenerbit.setText("")
                    edtTahunTerbit.setText("")
                    edtJumlahHalaman.setText("")
                }
                .addOnFailureListener { e ->
                    Toast.makeText(activity, "Gagal menambah Data", Toast.LENGTH_LONG)
                    Log.w("DB_Check", "Error adding document", e)
                }
        }

        return view
    }

}