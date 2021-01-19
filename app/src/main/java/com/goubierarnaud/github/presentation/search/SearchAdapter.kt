package com.goubierarnaud.github.presentation.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.goubierarnaud.github.R
import com.goubierarnaud.github.domain.model.UserShort
import com.squareup.picasso.Picasso

class SearchAdapter(context: Context) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private val users: ArrayList<UserShort> = ArrayList()

    private val inflater = LayoutInflater.from(context)

    override fun getItemCount() = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun setData(users: List<UserShort>?) {
        this.users.clear()

        users?.let {
            this.users.addAll(users)
        }

        notifyDataSetChanged()

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val login: TextView = view.findViewById(R.id.login)
        private val avatar: ImageView = view.findViewById(R.id.avatar)

        fun bind(userShort: UserShort) {
            login.text = userShort.login

            if (userShort.avatar.isNotEmpty() && userShort.avatar.isNotBlank()) {
                Picasso.get().load(userShort.avatar).into(avatar)
            } else {
                avatar.setImageDrawable(null)
            }
        }

    }
}