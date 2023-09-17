package com.example.mad_practical5_21012011099

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val browse:Button=findViewById(R.id.browse)
        val url:EditText=findViewById(R.id.editTextUrl)
        browse.setOnClickListener()
        {
            if(url!=null){
                openUrl(url.text.toString())
            }
            else{
                ShowMessage("Enter valid URL!")
            }
        }

        val call:Button=findViewById(R.id.call)
        val number:EditText=findViewById(R.id.editTextNumber)
        call.setOnClickListener()
        {
            if(number!=null)
            {
                openDial(number.text.toString())
            }
            else{
                ShowMessage("Enter valid Phone Number !")
            }
        }

        val callLog:Button=findViewById(R.id.callLog)
        callLog.setOnClickListener()
        {
            openCallLog()
        }

        val gallary:Button=findViewById(R.id.gallary)
        gallary.setOnClickListener()
        {
            openGallary()
        }

        val camera:Button=findViewById(R.id.camera)
        camera.setOnClickListener()
        {
            openCamera()
        }

        val alarm:Button=findViewById(R.id.alarm)
        alarm.setOnClickListener()
        {
            openAlarm()
        }
    }

    fun ShowMessage (msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    fun openUrl(url:String)
    {
        Intent( Intent.ACTION_VIEW , Uri.parse("https://$url") ).also { startActivity(it) }
    }

    fun openDial(number:String)
    {
        Intent(Intent.ACTION_DIAL,Uri.parse("tel:$number") ).also { startActivity(it) }
    }

    fun openCallLog()
    {
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }

    fun openGallary()
    {
        Intent(Intent.ACTION_VIEW).setType("Image/*").also { startActivity(it) }
    }

    fun openCamera()
    {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }

    fun openAlarm() {
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }
}