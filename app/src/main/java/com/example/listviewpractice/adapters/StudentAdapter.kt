package com.example.listviewpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listviewpractice.R
import com.example.listviewpractice.datas.Student

//ArrayAdapter의 기능을 상속받는다
class StudentAdapter(val mContext : Context,
                     val resId :Int,
                     val  mList : ArrayList<Student>) : ArrayAdapter <Student>(mContext,resId,mList){
                     val inf =LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.student_list_item,null)
        }

        val row = tempRow!!

//        위치에 맞는 데이터 가져오기
        val studentData = mList[position]

//        뷰를 아이디로 찾아달라
        val nameTxt =row.findViewById<TextView>(R.id.nameTxt)
        val birthYearTxt = row.findViewById<TextView>(R.id.birthYearTxt)
        val genderTxt = row.findViewById<TextView>(R.id.genderTxt)

        nameTxt.text = studentData.name
//        스트링 가공 법 ${변수사용 가능}
        birthYearTxt.text = "(${studentData.birthYear}년생)"
        genderTxt.text = studentData.gender

        return row
    }



}