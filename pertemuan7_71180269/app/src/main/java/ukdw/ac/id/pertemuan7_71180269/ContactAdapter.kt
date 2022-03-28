package ukdw.ac.id.pertemuan7_71180269

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var listContact: ArrayList<Contact>, var context: Context): RecyclerView.Adapter<ContactAdapter.ContactHolder>(){
    class ContactHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(contact: Contact, context: Context) {
            view.findViewById<TextView>(R.id.tvName).setText(contact.name)
            view.findViewById<TextView>(R.id.tvEmail).setText(contact.email)
            view.findViewById<TextView>(R.id.tvNoTelp).setText(contact.noTelp)
            view.setOnClickListener{
                val i = Intent(context, DetailContact::class.java)
                i.putExtra("name", contact.name)
                i.putExtra("notelp", contact.noTelp)
                i.putExtra("email", contact.email)

                context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_contact_list, parent, false)
        return ContactHolder(v)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(listContact[position], context)
    }

    override fun getItemCount(): Int {
        return listContact.size
    }


}