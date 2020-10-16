package com.example.gitgooglerepos.api

import com.example.gitgooglerepos.models.RepoItem
import retrofit2.Call
import retrofit2.http.GET

interface StackService {

    @GET("users/google/repos")
    fun getRepos() : Call<List<RepoItem>>

}