package com.example.edittextbuttonkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        if(intent.hasExtra("msg")){
            tv_get.text = intent.getStringExtra("msg") // 서브 엑티비티의 존재하는 텍스트뷰에다가  첫슬라이드 값 옮겨짐.

        }

        btn_toast.setOnClickListener {

            ConstraintLayout.setImageResource(R.drawable.seoul_university) // 이미지 뷰에 새로운 이미지 등록
            Toast.makeText(this@SubActivity, "버튼이 클릭 되었습니다.", Toast.LENGTH_SHORT).show()

        }

        btn_b.setOnClickListener {
            val intent = Intent(this, SubActivity2::class.java)
            startActivity(intent)

        }

    }
}