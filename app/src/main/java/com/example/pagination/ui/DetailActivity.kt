package com.example.pagination.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.pagination.Post
import com.example.pagination.R
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Get the post details from intent extras
        val postString: String? = intent.getStringExtra("POST_DETAILS")
        val post = Gson().fromJson(postString, Post::class.java)

        // Update UI with post details
        val titleTextView = findViewById<TextView>(R.id.textTitle)
        val bodyTextView = findViewById<TextView>(R.id.textBody)
        val userIdTextView = findViewById<TextView>(R.id.textUserId)
        val postIdTextView = findViewById<TextView>(R.id.textPostId)

        titleTextView.text = "title: "+post?.title
        bodyTextView.text = "body: "+post?.body

        userIdTextView.text = "UserId: "+post?.userId.toString()
        postIdTextView.text = "PostId: "+post?.id.toString()
    }
}