package com.example.proj23_25

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proj23_25.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = MainDb.getDb(this)

        binding.button.setOnClickListener{
            val book = BookEntity(null,
                                        binding.editTextText.text.toString(),
                                        binding.editTextText2.text.toString())
            Thread{
                db.getBookDao().insertNewBookData(book)
            }.start()

        }




    }
}