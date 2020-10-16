package com.example.gitgooglerepos.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gitgooglerepos.R
import com.example.gitgooglerepos.ReposAdapter
import com.example.gitgooglerepos.api.retrofitClient
import com.example.gitgooglerepos.models.RepoItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_repos.*
import retrofit2.Call
import retrofit2.Response

class ReposFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repos, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        retrofitClient.getRepos().enqueue(object : retrofit2.Callback<List<RepoItem>> {
            override fun onResponse(
                call: Call<List<RepoItem>>,
                response: Response<List<RepoItem>>
            ) {
                response.body()?.let {
                    val adapter = ReposAdapter(it){ name, description ->
                        val action = ReposFragmentDirections.actionReposFragmentToRepoDetailsFragment2(
                            name = name,
                            description = description
                        )
                        fragmentContainer.findNavController().navigate(action)
                    }
                    recyclerRepos.adapter = adapter
                }


            }

            override fun onFailure(call: Call<List<RepoItem>>, t: Throwable) {
            }

        })

    }


}