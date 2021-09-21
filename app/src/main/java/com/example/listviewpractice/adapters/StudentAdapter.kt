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
//여기가 StudentAdapter
class StudentAdapter(val mContext : Context,
                     val resId :Int,
                     val  mList : ArrayList<Student>) : ArrayAdapter <Student>(mContext,resId,mList){
                     val inf =LayoutInflater.from(mContext)
//겟뷰는 리스트 뷰에 한줄을 작성하게 도와주는 것 이 겟뷰를 오버라이딩하고 겟뷰(뷰를 만들어서)
//    만약 그 뷰가 비어 있다면 내용을 채우는 것을 inflate로 작성해준다
//    단 inflate는 너무 많이 사용하면 OOM이 되기 때문에 아래와 같이
//    컨버트뷰(돌려막기할 뷰)가 없다면 그때 inflate해서 리스트 한줄 한줄을 만들어줘라고 코드 작성
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.student_list_item,null)
        }

        val row = tempRow!!

//        위치에 맞는 데이터 가져오기
//    Student에 있는 list를 위치 [position]에서 값을 가져와 studentData에 저장
        val studentData = mList[position]

//        뷰를 아이디로 찾아달라
        val nameTxt =row.findViewById<TextView>(R.id.nameTxt)
        val birthYearTxt = row.findViewById<TextView>(R.id.birthYearTxt)
        val genderTxt = row.findViewById<TextView>(R.id.genderTxt)

        nameTxt.text = studentData.name


//   출생년도를 가지고 ->(2021년도 한국식)나이로 변환해서 보여주기

    val koreanAge = 2021 -studentData.birthYear +1

//        스트링 가공 법 ${변수사용 가능}
        birthYearTxt.text = "(${koreanAge}세)"
        genderTxt.text = studentData.gender

        return row
    }



}