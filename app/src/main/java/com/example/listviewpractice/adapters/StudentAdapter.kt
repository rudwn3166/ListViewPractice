package com.example.listviewpractice.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.example.listviewpractice.datas.Student

//ArrayAdapter의 기능을 상속받는다
class StudentAdapter(val mContext : Context,
                     val resId :Int,
                     val  mList : ArrayList<Student>) : ArrayAdapter <Student>(mContext,resId,mList){



}