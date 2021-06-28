package com.tvz.os_hbp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    btn_main_start.setOnClickListener{
        if(txt_main_name.text.toString().isEmpty()){
            Toast.makeText(this,"Please enter your name.", Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.USER_NAME, txt_main_name.text.toString())
            startActivity(intent)
            finish()
        }
    }

    }
}


/*  val userId = intent.getStringExtra("user_id")
  val emailId = intent.getStringExtra("email_id")*/

 /*       txt_main_user.text = "User ID :: $userId"
        txt_main_email.text = "Email ID :: $emailId"

        btn_main_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
*/
 /*           startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()*/
