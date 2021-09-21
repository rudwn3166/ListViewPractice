package com.example.listviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listviewpractice.adapters.StudentAdapter
import com.example.listviewpractice.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    어레이리스트에 내가 datas에 작성한 학생 목록 클래스를 넣어줌
    val mStudentList = ArrayList<Student>()

//    나중에 채워넣는 변수,mAdapter가 Student클래스가 가진 StudentAdapter를 상속받는다
    lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        우리가 보여줄 리스트 뷰에 내용을 add로 추가 해줌
        mStudentList.add(Student("오경주",1995,"여성"))
        mStudentList.add(Student("김말수",1989,"남자"))
        mStudentList.add(Student("라용니",7818,"여성"))
        mStudentList.add(Student("개소리",2001,"남자"))
        mStudentList.add(Student("꼬미",2018,"여성"))
        mStudentList.add(Student("오나",1597,"성별모름"))
        mStudentList.add(Student("라벨라",1234,"남자"))

//       리스트 뷰에 내용을 보여주기 위해서 위에서 멤버변수로 선언한 mAdapter에 StudentAdapter와 연결후
//        실제 보여줄 내용을 작성함
//어떤화면에서 어떤 레이아웃의 모양으로 ,어떤 목록에 들어있는 걸 반영하는지
      mAdapter = StudentAdapter(this,R.layout.student_list_item,mStudentList)
      studentListView.adapter = mAdapter
        
//        리스트 뷰가 눌렸을 때 할 이벤트 작성
        studentListView.setOnItemClickListener { adapterView, view, position,id ->
            
            val clickedStudent = mStudentList[position]
            Toast.makeText(this, "${clickedStudent.name}이 눌림", Toast.LENGTH_SHORT).show()
            
        }

//        롱클릭 리스너는 리턴값을 줘야함
        studentListView.setOnItemLongClickListener { adapterView, view, position, id ->

//            리스트뷰의 눌린 것을 지워 줘라,이것만 누르면 실제 뷰에서는 지워지지 않음
            mStudentList.removeAt(position)
//            내가 true라고 하면 롱클릭 전용으로 생각하고
//            false라고 하면 롱클릭뿐아니라 일반 클릭도 사용한 것처럼 보이게 됨
            mAdapter.notifyDataSetChanged()
//            위 함수를 작성해야 삭제가 됨 .어댑터한테 리스트뷰가 변경 된 항목을 알려주는 함수


            return@setOnItemLongClickListener true
        }

    }
}