package com.example.myapplication

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private lateinit var ministerController: IMinisterController
    private lateinit var currentPolicy : IPolicy
    private lateinit var city: ICity

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val repo = MockRepo()
        findViewById<Button>(R.id.button4).setOnClickListener { this.nextMinister() }
        findViewById<Button>(R.id.button5).setOnClickListener { this.previousMinister() }
        this.ministerController = PrimaryGameLoadFactory(repo).GetMinisterController();
        this.SetPolicy()
        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    fun SetPolicy()
    {
        if(this.currentPolicy == null)
        {
            this.currentPolicy = this.ministerController.GetCurrentMinister().GetNextPolicy()
        }
    }


    fun nextMinister()
    {
       this.ministerController.NextMinister()
    }

    fun previousMinister()
    {
        this.ministerController.PreviousMinister()
    }

    fun acceptPolicy()
    {
        val effectPack = this.currentPolicy.Accept()
        val city.ImplementPolicy(effectPack)
    }

    fun declinePolicy()
    {

    }

}
