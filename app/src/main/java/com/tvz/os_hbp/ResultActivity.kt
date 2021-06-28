package com.tvz.os_hbp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username= intent.getStringExtra(Constants.USER_NAME)
        txt_username.text = username
        val totalQuestions= intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers= intent.getIntExtra(Constants.CORRECT_QUESTIONS,0)

        txt_score.text ="Your Score is $correctAnswers out of $totalQuestions !"

        btn_logout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
                     startActivity(Intent(this@ResultActivity, LoginActivity::class.java))
                       finish()
        }
    }
}