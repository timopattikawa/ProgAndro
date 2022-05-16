package ukdw.ac.id.pertemuan10_71180269

import android.database.sqlite.SQLiteDatabase
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PendudukAdapter(var listPenduduk: ArrayList<String>, val db: SQLiteDatabase?): RecyclerView.Adapter<PendudukAdapter.PendudukHolder>() {
    class PendudukHolder(val v: View, val db: SQLiteDatabase?): RecyclerView.ViewHolder(v) {
        fun bind(data: String) {
            val tvinfo = v.findViewById<TextView>(R.id.txvInfo)
            tvinfo.setText(data)

            val btnHpus = v.findViewById<Button>(R.id.btnHapus)
            btnHpus.setOnClickListener {
                val selection = "${DatabaseContract.Penduduk.COLUMN_NAME_NAMA} LIKE ? OR "+
                        "${DatabaseContract.Penduduk.COLUMN_NAME_USIA} LIKE ?"
                val dataArray = data.split(" (")
                val sellectionArgs = arrayOf(dataArray[0])
                 db!!.delete(DatabaseContract.Penduduk.TABLE_NAME, selection, sellectionArgs)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendudukHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_penduduk, parent, false)
        return PendudukHolder(view, db)
    }

    override fun onBindViewHolder(holder: PendudukHolder, position: Int) {
        holder.bind(listPenduduk.get(position))
    }

    override fun getItemCount(): Int {
        return listPenduduk.size
    }
}