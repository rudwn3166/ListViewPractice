package com.example.listviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listviewpractice.datas.Student

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("오경주",1995,"여성"))
        mStudentList.add(Student("김말수",1989,"남자"))
        mStudentList.add(Student("라용니",7818,"여성"))
        mStudentList.add(Student("개소리",2001,"남자"))
        mStudentList.add(Student("꼬미",2018,"여성"))
        mStudentList.add(Student("오나",1597,"성별모름"))
        mStudentList.add(Student("라벨라",1234,"남자"))
    }
}