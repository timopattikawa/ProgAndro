package ukdw.ac.id.tugasakhir_71180269

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ListFragment: Fragment() {
    val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_list, container, false)
        val listBuku = arrayListOf<Buku>()
        db.collection("buku")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("GET", "${document.id} => ${document.data}")
                    val buku = Buku(
                        document.data.get("judulBuku").toString(),
                        document.data.get("namaPenulis").toString(),
                        document.data.get("namaPenerbit").toString(),
                        document.data.get("tahunTerbit").toString(),
                        document.data.get("jumlahHalaman").toString()
                    )
                    listBuku.add(buku)
                    for(doc in listBuku) {
                        Log.d("CEK", "${doc.judulBuku} => ${doc.namaPenulis}")
                    }

                    val rcyBuku = view.findViewById<RecyclerView>(R.id.rcyListBuku)
                    rcyBuku.layoutManager = LinearLayoutManager(activity)
                    rcyBuku.adapter = BukuAdapter(listBuku, view.context)
                    continue
                }
            }.addOnFailureListener { exception ->
                Log.w("GET", "Error getting documents.", exception)
            }
        return view
    }

//    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
//        val listContact = arrayListOf<Buku>()
//        listContact.add(Buku("Matahariku","Abraham", "sinar buku", "2001", 20))
//        listContact.add(Buku("Buku TEst", "Timotius Pattikawa", "sinar buku", "2001", 200))
//        listContact.add(Buku("Buku Membaca", "Budi", "sinar buku", "2001", 1000))
//        listContact.add(Buku("Buku Apapun", "Antonius", "sinar buku", "2001", 101))
//        super.onViewCreated(itemView, savedInstanceState)
//
//        var recyclerView = itemView.findViewById<RecyclerView>(R.id.rcyListBuku)
//        recyclerView.layoutManager = LinearLayoutManager(activity)
//        val adapter = BukuAdapter(listContact )
//        recyclerView.adapter = adapter
//    }
}