package com.example.edittextbuttonkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) { // 액티비티가 최초 실행되면 이곳을 수행한다.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_navi.setOnClickListener {
            layout_drawer.openDrawer(GravityCompat.START) // START = left, END = right 같은 말
        }
        naviView.setNavigationItemSelectedListener(this) //네비게이션 메뉴 아이템에 클릭 속성 부여

        btn_getText.setOnClickListener { //에딧 텍스트에 입력되어 있는 값을 가지고와서 텍스트뷰에 뿌려준다.
            var resultText = et_id.text.toString() // 에딧텍스트에 입력되어있는 값
            tv_result.setText(resultText) // 입력된 값을 텍스트뷰에 set 해줌.

        }

        btn_a.setOnClickListener{
            // var : 변수 값이 언제든지 변경 될 수 있음.
            // val : 자바에서는 final 값이 변경되지 못하는 변수.

            val intent = Intent(this, SubActivity::class.java) // 다음 화면으로 이동하기 위한 인텐트 객체 생성
            intent.putExtra("msg", tv_result.text.toString()) // 첫 슬라이드 텍스트 값을 담은 뒤 msg라는 키로 잠궜다.
            startActivity(intent) // intent에 저장되어있는 엑티비티 쪽으로 이동한다.
            finish() // 자기 자신 엑티비티를 파괴한다.

        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { // 네비게이션 메뉴 아이템 클릭 시 수행
       when(item.itemId)
       {
           R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
           R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
           R.id.message -> Toast.makeText(applicationContext, "메세지", Toast.LENGTH_SHORT).show()
       }
        layout_drawer.closeDrawers() // 네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() {
        if(layout_drawer.isDrawerOpen(GravityCompat.START))
        {
            layout_drawer.closeDrawers()
        }
        else
        {
            super.onBackPressed() // 일반 백버튼 기능 실행 (finish)
        }
    }
}