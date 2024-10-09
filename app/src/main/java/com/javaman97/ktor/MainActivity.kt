package com.javaman97.ktor

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.javaman97.ktor.network.model.Post
import com.javaman97.ktor.repository.getRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val post = Post(
            body = "This is body",
            id = 1,
            title = "Post Req",
            userId = 1
        )

        val map = mutableMapOf<String,String>()
        map.put("body","this is not my body")

        CoroutineScope(Dispatchers.IO).launch {
           // Log.d("TAG","onCreate:${getRepo().getPosts()}")
         //   Log.d("TAG","onCreate:${getRepo().getComments("1")}")
          //  Log.d("TAG","onCreate:${getRepo().postPost(post)}")
          //  Log.d("TAG","onCreate:${getRepo().putPost(1,post)}")
          // Log.d("TAG","onCreate:${getRepo().patchPost(1,map)}")
            Log.d("TAG","onCreate:${getRepo().deletePost(1).status}")
        }
    }
}