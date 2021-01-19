package com.goubierarnaud.github.presentation.repos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.goubierarnaud.github.R
import com.goubierarnaud.github.domain.model.UserRepos

class RepoAdapter(private val context: Context) :
    RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    private val usersRepos: ArrayList<UserRepos> = ArrayList()

    private val inflater = LayoutInflater.from(context)

    override fun getItemCount() = usersRepos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_repos, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(usersRepos[position])
    }

    fun setData(usersRepos: List<UserRepos>?) {
        this.usersRepos.clear()

        usersRepos?.let {
            this.usersRepos.addAll(usersRepos)
        }

        notifyDataSetChanged()

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name: TextView = view.findViewById(R.id.name)
        private val description: TextView = view.findViewById(R.id.description)
        private val language: TextView = view.findViewById(R.id.language)
        private val forks: TextView = view.findViewById(R.id.forks)
        private val watchers: TextView = view.findViewById(R.id.watchers)
        private val license: TextView = view.findViewById(R.id.license)

        fun bind(userRepos: UserRepos) {
            name.text = userRepos.name

            description.text = userRepos.description?.let {
                context.getString(R.string.description, it)
            } ?: context.getString(R.string.no_description)

            language.text = userRepos.language?.let {
                context.getString(R.string.language, it)
            } ?: context.getString(R.string.no_language)

            forks.text = userRepos.forks.toString().let {
                context.getString(R.string.forks, it)
            }
            watchers.text = userRepos.watchers.toString().let {
                context.getString(R.string.watchers, it)
            }
            license.text = userRepos.license?.let {
                context.getString(R.string.license, it)
            } ?: context.getString(R.string.no_license)
        }
    }
}