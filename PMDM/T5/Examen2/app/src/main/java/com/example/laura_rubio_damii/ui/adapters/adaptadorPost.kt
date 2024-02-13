package com.example.laura_rubio_damii.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.laura_rubio_damii.R
import com.example.laura_rubio_damii.ui.model.Post

class adaptadorPost(var context: Context) : RecyclerView.Adapter<adaptadorPost.MyHolder>() {

    private var listaPosts = ArrayList<Post>()

    class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {
        lateinit var body: TextView

        init {
            body = view.findViewById(R.id.textView_body)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.post_detail,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listaPosts.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var post: Post = listaPosts.get(position) as Post

    }
    fun addPost(item : Post): Unit {
        listaPosts.add(item)
        notifyItemInserted(listaPosts.size-1)
    }
}