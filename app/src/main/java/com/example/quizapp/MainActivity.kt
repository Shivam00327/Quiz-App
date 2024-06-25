package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets

            binding.startButton.setOnClickListener {
                if(binding.editTextName.text.toString().trim().isEmpty()){
                    Toast.makeText(this, "EditText is empty", Toast.LENGTH_LONG).show()
                }
                else{
                    val intent=Intent(this,QuizQuestionActivity::class.java)
                    intent.putExtra(constants.USER_NAME,binding.editTextName.text.toString())
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
