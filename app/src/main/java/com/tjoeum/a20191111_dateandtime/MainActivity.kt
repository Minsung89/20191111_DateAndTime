package com.tjoeum.a20191111_dateandtime

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import com.tjoeum.a20191111_dateandtime.datas.ScheduleType
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity(){

    var scheduleTyeList = ArrayList<ScheduleType>()

    //시작 일자 / 시간을 모두 저장하고 있는 캘린더 변수
    var startDateTimeCalenar = Calendar.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvent()
        setValues()
    }

    override fun setupEvent() {

        saveBtn.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setTitle("저장 확인")
            alert.setMessage("정말 일정을 저장하겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->

                Toast.makeText(this, "일정을 저장했습니다.", Toast.LENGTH_SHORT).show()
            })
            alert.setNegativeButton("취소",null)
            alert.show()
        }

        startDateBtn.setOnClickListener {


            var datePickerDialog = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                    //시작일시 변수에 선택값 반영
                startDateTimeCalenar.set(year,month,dayOfMonth)

                  //버튼에 2019-09-08 양식으로 출력
                var sdf = SimpleDateFormat("yyyy-MM-dd (EEE)")

                //버튼에 sdf를 이용해서 선택된 날짜를 String으로 변환
                startDateBtn.text = sdf.format(startDateTimeCalenar.time)


            },startDateTimeCalenar.get(Calendar.YEAR),startDateTimeCalenar.get(Calendar.MONTH),startDateTimeCalenar.get(Calendar.DAY_OF_MONTH))


            datePickerDialog.show()
        }

        startTimeBtn.setOnClickListener {
            var timePickerDialog = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                startDateTimeCalenar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                startDateTimeCalenar.set(Calendar.MINUTE, minute)

                var sdf = SimpleDateFormat("a h시:m분")
                startTimeBtn.text = sdf.format(startDateTimeCalenar.time)

            }, startDateTimeCalenar.get(Calendar.HOUR_OF_DAY), startDateTimeCalenar.get(Calendar.MINUTE),false)

            timePickerDialog.show()
        }

    }

    override fun setValues() {
    }

    fun addScheduleTypes(){

        scheduleTyeList.add(ScheduleType("개인 일정","#FF0000"))
        scheduleTyeList.add(ScheduleType("동아리 모임","#00FF00"))
        scheduleTyeList.add(ScheduleType("업무 일정","#0000FF"))
        scheduleTyeList.add(ScheduleType("공식 행사","#000000"))




    }



}
