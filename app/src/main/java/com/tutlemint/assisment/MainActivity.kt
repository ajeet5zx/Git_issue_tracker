package com.tutlemint.assisment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutlemint.assisment.adapters.CustomAdapter
import com.tutlemint.assisment.models.IssueListItem
import com.tutlemint.assisment.viewmodels.MainViewModel
import com.tutlemint.assisment.viewmodels.MainViewModelFactory
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private var adapter: RecyclerView.Adapter<*>? = null
    private var issuesList = ArrayList<IssueListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Paper.init(applicationContext);

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setItemAnimator(DefaultItemAnimator())
        adapter = CustomAdapter(issuesList)
        recyclerview.adapter=adapter
        val repository = (application as IssuesApplication).quoteRepository

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.issues.observe(this, Observer {
            issuesList.clear()
            issuesList.addAll(it)
            (adapter as CustomAdapter).notifyDataSetChanged()
            Toast.makeText(this@MainActivity, it.size.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}



/* REQUIREMENTS

You have to build an app, which displays GitHub issues of okhttp (https://github.com/square/okhttp/issues) repository from square.



Features required:



1. Show the issues provided by API in a List.

- Show complete title.

- Show first 200 Characters of the issue description.

- Show user info. (userName and avatar)

- updated_at date in mm-dd-yyyy format.



2. App should show all the comments and issue info when the user clicks on the issue from the issue list.



App should work in offline mode also.



APIs info.

https://api.github.com/repos/square/okhttp/issues



This will give you a list of all issues.

In response to the above URL. Each json object’s comments_url will give you a list of comments.



Use any library for Networking, Image loading.

Write all the code in Kotlin. We are looking for unit test as well

Use your favourite Architecture pattern.



After finishing this project, upload your project on GitHub or bitbucket, and share the link with us.



Do reach out to me in case of any query. We look forward to hearing from you.


 */