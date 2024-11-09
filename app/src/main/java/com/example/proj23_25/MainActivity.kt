package com.example.proj23_25

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.example.proj23_25.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = MainDb.getDb(this)
        db.getBookDao().getAllBooks().asLiveData().observe(this){
            binding.tvList.text = " "
            it.forEach {
                val text = "id: ${it.id}, author: ${it.author}, title ${it.title}\n"
                binding.tvList.append(text)
            }
        }

        binding.button.setOnClickListener{
            val book = BookEntity(null,
                                        binding.editTextText.text.toString(),
                                        binding.editTextText2.text.toString())
            Thread{
                db.getBookDao().insertNewBookData(book)
            }.start()

        }

        binding.button2.setOnClickListener{
            Thread{
                db.getBookDao().deleteBookDataById(binding.editTextText3.text.toString().toInt())
            }.start()
        }

    }
}