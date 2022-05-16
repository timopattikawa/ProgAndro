package ukdw.ac.id.pertemuan10_71180269

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.database.getStringOrNull
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var dbHelper: SQLiteOpenHelper? = null
    var db: SQLiteDatabase? = null
    val listpenduduk = ArrayList<String>()
    var adapter: PendudukAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatabaseHelper(this)
        db = dbHelper?.readableDatabase

        val btnSiman = findViewById<Button>(R.id.buttonSimpan)
        val edtNama = findViewById<EditText>(R.id.edtNama)
        val edtUsia = findViewById<EditText>(R.id.edtUsia)


        btnSiman.setOnClickListener {
            val values = ContentValues().apply {
                put(DatabaseContract.Penduduk.COLUMN_NAME_NAMA, edtNama.text.toString())
                put(DatabaseContract.Penduduk.COLUMN_NAME_USIA, edtUsia.text.toString())
            }
            db?.insert(DatabaseContract.Penduduk.TABLE_NAME, null, values)
            edtNama.setText("")
            edtUsia.setText("")
            reloadData()
        }

        val btnCari = findViewById<Button>(R.id.buttonCari)
        btnCari.setOnClickListener {
            searchData()
        }


        val rcyPenduduk = findViewById<RecyclerView>(R.id.rcypenduduk)
        rcyPenduduk.layoutManager = LinearLayoutManager(this)
        val adapter = PendudukAdapter(listpenduduk, db)
        rcyPenduduk.adapter = adapter
    }

    fun reloadData() {
        listpenduduk.clear()
        val columns = arrayOf(
            BaseColumns._ID,
            DatabaseContract.Penduduk.COLUMN_NAME_NAMA,
            DatabaseContract.Penduduk.COLUMN_NAME_USIA
        )

        val cursor = db?.query(
            DatabaseContract.Penduduk.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null
        )

        with(cursor!!) {
            while (moveToNext()) {
                val nama = getStringOrNull(getColumnIndex(DatabaseContract.Penduduk.COLUMN_NAME_NAMA))
                val usia =  getStringOrNull(getColumnIndex(DatabaseContract.Penduduk.COLUMN_NAME_USIA))
                listpenduduk.add("${nama} (${usia})")
                Log.d("SQLITE", "${nama} (${usia})")
            }
            adapter?.notifyDataSetChanged()
        }
    }

    fun searchData() {
        listpenduduk.clear()
        val columns = arrayOf(
            BaseColumns._ID,
            DatabaseContract.Penduduk.COLUMN_NAME_NAMA,
            DatabaseContract.Penduduk.COLUMN_NAME_USIA
        )

        val edtCari = findViewById<EditText>(R.id.edtCari)

        val selection = "${DatabaseContract.Penduduk.COLUMN_NAME_NAMA} LIKE ?"
        val dataArray = arrayListOf<String>(edtCari.text.toString())
        val sellectionArgs = arrayOf(dataArray[0])

        val cursor = db?.query(
            DatabaseContract.Penduduk.TABLE_NAME,
            columns,
            selection,
            sellectionArgs,
            null,
            null,
            null
        )

        with(cursor!!) {
            while (moveToNext()) {
                val nama = getStringOrNull(getColumnIndex(DatabaseContract.Penduduk.COLUMN_NAME_NAMA))
                val usia =  getStringOrNull(getColumnIndex(DatabaseContract.Penduduk.COLUMN_NAME_USIA))
                listpenduduk.add("${nama} (${usia})")
                Log.d("SQLITE", "${nama} (${usia})")
            }
            adapter?.notifyDataSetChanged()
        }
    }
}