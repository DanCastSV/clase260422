package com.example.clase260422

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNotas.setOnClickListener {

            replaceFragment(OneFragment())
        }
        Intro.webChromeClient = object : WebChromeClient(){

        }

        Intro.webViewClient=object : WebViewClient(){

        }
        val settings: WebSettings = Intro.settings
        settings.javaScriptEnabled=true

       Intro.loadUrl("https://www.ugb.edu.sv")

        btnCand.setOnClickListener{
            replaceFragment(TwoFragment())
        }
        btnHimno.setOnClickListener {
            replaceFragment(ThreeFragment())
        }




    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}