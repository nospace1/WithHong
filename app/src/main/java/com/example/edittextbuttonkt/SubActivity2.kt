package com.example.edittextbuttonkt

import android.net.wifi.p2p.WifiP2pManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub2.*

class SubActivity2 : AppCompatActivity() {

    var UserList = arrayListOf<User>(
        User(R.drawable.seoul_university, "안우주", "27", "안녕하세요"),
        User(R.drawable.android, "기계","20", "ㅎㅎ"),
        User(R.drawable.ic_launcher_background, "안드로이드", "23", "안녕"),
        User(R.drawable.press_button, "화살표", "30", "어디로 가야해"),
        User(R.drawable.ic_launcher_foreground, "시작", "27", "반가워")

    )

    override fun onCreate(savedInstanceState: Bundle?) { // 엑티비티의 실행 시작 지점
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub2)

//        val item = arrayOf("사과", "배", "딸기", "바나나")
//        // context란 한 액티비티의 모든 정보를 담고있다.
//        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this, UserList)
        listView.adapter = Adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()


        }


    }
}