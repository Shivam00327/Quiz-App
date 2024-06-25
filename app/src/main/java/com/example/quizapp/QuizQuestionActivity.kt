package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionBinding
    private var mCurrentPosition=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedQptionPosition:Int=0
    private var mCorrectAnswers: Int = 0

    private var mUserName:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        mUserName=intent.getStringExtra(constants.USER_NAME)
        mQuestionList = constants.getQuestion()
        setQuestion(

        )


    }

    private fun setQuestion() {
        defaultOptionView()

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        binding.textViewQuestion.text = question.questions
        binding.imageQuestion.setImageResource(question.image)
        binding.progressBar.progress = mCurrentPosition
        binding.textProgress.text = "$mCurrentPosition/10"
        binding.textOption1.text = question.optionOne
        binding.textOption2.text = question.optionTwo
        binding.textOption3.text = question.optionThree
        binding.textOption4.text = question.optionFour


        binding.textOption1.setOnClickListener(this)
        binding.textOption2.setOnClickListener(this)
        binding.textOption3.setOnClickListener(this)
        binding.textOption4.setOnClickListener(this)
        binding.submitButton.setOnClickListener(this)

        if(mCurrentPosition==mQuestionList!!.size){
            binding.submitButton.text="Finish"

        }else{
            binding.submitButton.text="Submit"
        }
    }
    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        binding.textOption1.let {
            options.add(0,it)
        }
        binding.textOption2.let {
            options.add(1,it)
        }
        binding.textOption3.let {
            options.add(2,it)
        }
        binding.textOption4.let {
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface=Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.optionbackground)
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()

        mSelectedQptionPosition=selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option
        )
    }

    override fun onClick(view: View?) {
        when(view){
            binding.textOption1->{
                binding.textOption1.let {
                    selectedOptionView(it,1)
                }
            }
            binding.textOption2->{
                binding.textOption2.let {
                    selectedOptionView(it,2)
                }
            }
            binding.textOption3->{
                binding.textOption3.let {
                    selectedOptionView(it,3)
                }
            }
            binding.textOption4->{
            binding.textOption4.let {
                selectedOptionView(it,4)
                }
            }
            binding.submitButton->{
                if (mSelectedQptionPosition == 0) {

                    mCurrentPosition++

                when {

                    mCurrentPosition <= mQuestionList!!.size -> {

                        setQuestion()
                    }
                    else -> {
                        val intent=Intent(this,ResultScreen::class.java)
                        intent.putExtra(constants.USER_NAME,mUserName)
                        intent.putExtra(constants.CORRECT_ANSWER,mCorrectAnswers)
                        intent.putExtra(constants.TOTAL_QUESTION,mQuestionList!!.size)
                        startActivity(intent)
                        finish()

                    }

                }
            } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAns != mSelectedQptionPosition) {
                        answerView(mSelectedQptionPosition, R.drawable.wrongoptionbackground)
                    }

                    // START
                    else {
                        mCorrectAnswers++
                    }
                    // END
                    // This is for correct answer
                    answerView(question.correctAns, R.drawable.correctoptionbackground)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        binding.submitButton?.text = "FINISH"
                    } else {
                        binding.submitButton?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedQptionPosition = 0
                }

            }

        }
    }
     fun answerView(answer:Int,drawableView:Int ){
        when(answer){
            1->{
                binding.textOption1.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                binding.textOption2.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                binding.textOption3.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                binding.textOption4.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

}