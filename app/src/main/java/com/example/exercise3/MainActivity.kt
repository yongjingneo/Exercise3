package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myData: myModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = ViewModelProviders.of(this)
            .get(myModel::class.java)
        
        display()

        btnCal.setOnClickListener(){
            myData.total = getPremium()
            display()
        }

        btnReset.setOnClickListener(){
            lblTotal.setText("")
            radioGroup.clearCheck()
            spinner.setSelection(0)
            chkSmoke.setChecked(false)
            myData.total = getPremium()
        }
    }

    fun display(){
        lblTotal.setText(getPremium().toString())
    }

    fun getPremium():Double{

        return when(spinner.selectedItemPosition){
            0 -> 60.00
            1 -> 70.00 +
                    (if(btnRadioMale.isChecked)50.00 else 0.0) +
                    (if(chkSmoke.isChecked) 100.00 else 0.0)
            2 -> 90.00 +
                    (if(btnRadioMale.isChecked)100.00 else 0.0) +
                    (if(chkSmoke.isChecked) 150.00 else 0.0)
            3 -> 90.00 +
                    (if(btnRadioMale.isChecked)150.00 else 0.0) +
                    (if(chkSmoke.isChecked) 200.00 else 0.0)
            4 -> 90.00 +
                    (if(btnRadioMale.isChecked)200.00 else 0.0) +
                    (if(chkSmoke.isChecked) 250.00 else 0.0)
            else -> 90.00 +
                    (if(btnRadioMale.isChecked)200.00 else 0.0) +
                    (if(chkSmoke.isChecked) 300.00 else 0.0)
        }
    }
}
