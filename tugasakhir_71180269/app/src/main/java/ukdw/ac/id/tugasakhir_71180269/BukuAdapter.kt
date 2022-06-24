package ukdw.ac.id.tugasakhir_71180269

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BukuAdapter(var listBuku: ArrayList<Buku>, var context: Context): RecyclerView.Adapter<BukuAdapter.BukuHolder>() {

    class BukuHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(buku: Buku, context: Context) {
            view.findViewById<TextView>(R.id.tvJudulBuku).setText(buku.judulBuku)
            view.findViewById<TextView>(R.id.tvnamaPenulis).setText(buku.namaPenulis)
            view.findViewById<TextView>(R.id.tvNamaPenerbit).setText(buku.namaPenerbit)
            view.findViewById<TextView>(R.id.tvTahunTerbit).setText(buku.tahunTerbit)
            view.findViewById<TextView>(R.id.tvJumlahHalaman).setText(buku.jumlahHalaman)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_buku, parent, false)
        return BukuHolder(v)
    }

    override fun onBindViewHolder(holder: BukuHolder, position: Int) {
        holder.bind(listBuku[position], context)
    }

    override fun getItemCount(): Int {
        return listBuku.size
    }

}