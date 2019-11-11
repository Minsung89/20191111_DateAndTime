package com.tjoeum.a20191111_dateandtime

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity(){

    //시작 일자 / 시간을 모두 저장하고 있는 캘린더 변수
    var startDateTimeCalenar = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setupEvent() {
        startDateBtn.setOnClickListener {


            var datePickerDialog = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->  },startDateTimeCalenar.get(Calendar.YEAR),startDateTimeCalenar.get(Calendar.MONTH),startDateTimeCalenar.get(Calendar.DAY_OF_MONTH))


            datePickerDialog.show()
        }

    }

    override fun setValues() {
    }
}
