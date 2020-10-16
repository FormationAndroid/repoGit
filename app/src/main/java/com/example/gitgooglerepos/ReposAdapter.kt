package com.example.gitgooglerepos

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitgooglerepos.models.RepoItem
import kotlinx.android.synthetic.main.item_repo.view.*

class ReposAdapter(val repos: List<RepoItem>, val onClick: (name: String, description: String) -> Unit) : RecyclerView.Adapter<ReposAdapter.ReposViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ReposViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount() = repos.size

    inner class ReposViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_repo, parent, false)){

        fun bind(repo: RepoItem){

            itemView.run {
                textName.text = repo.name

                setOnClickListener {
                    onClick(repo.name, repo.description?:"no description")
                }
            }

        }

    }

}