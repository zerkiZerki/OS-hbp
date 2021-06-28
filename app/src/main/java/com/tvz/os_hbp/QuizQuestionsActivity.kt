package com.tvz.os_hbp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName= intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        txt_optionOne.setOnClickListener(this)
        txt_optionTwo.setOnClickListener(this)
        txt_optionThree.setOnClickListener(this)
        txt_optionFour.setOnClickListener(this)
        btn_main_submit.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition -1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size){
            btn_main_submit.text ="FINISH"
        }else{
            btn_main_submit.text="SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        txt_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        txt_question.text = question!!.question
        img_question.setImageResource(question.image)
        txt_optionOne.text = question.optionOne
        txt_optionTwo.text = question.optionTwo
        txt_optionThree.text = question.optionThree
        txt_optionFour.text = question.optionFour
    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, txt_optionOne)
        options.add(1, txt_optionTwo)
        options.add(2, txt_optionThree)
        options.add(3, txt_optionFour)

        for (option in options) {

            option.setTextColor(Color.parseColor("#1974D2"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.txt_optionOne -> {
                selectedOptionView(txt_optionOne, 1)
            }
            R.id.txt_optionTwo -> {
                selectedOptionView(txt_optionTwo, 2)
            }
            R.id.txt_optionThree -> {
                selectedOptionView(txt_optionThree, 3)
            }
            R.id.txt_optionFour -> {
                selectedOptionView(txt_optionFour, 4)
            }
            R.id.btn_main_submit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_QUESTIONS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_main_submit.text = "FINISH"
                    }else{
                        btn_main_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1->{
                txt_optionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2->{
                txt_optionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3->{
                txt_optionThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4->{
                txt_optionFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#15317E"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}