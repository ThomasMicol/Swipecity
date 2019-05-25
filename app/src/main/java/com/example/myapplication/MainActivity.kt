package com.example.myapplication

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val policyViewComponent: IViewComponent
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

        this.city = PrimaryGameLoadFactory(repo).GetCity();
        this.SetPolicy()

        this.policyViewComponent = PolicyViewComponent(R, this.currentPolicy)
        this.policyViewComponent.Draw();
        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    fun SetPolicy()
    {
        this.currentPolicy = this.ministerController.GetCurrentMinister().GetNextPolicy()
    }


    fun nextMinister()
    {
       this.ministerController.NextMinister()
       this.SetPolicy()
    }

    fun previousMinister()
    {
        this.ministerController.PreviousMinister()
        this.SetPolicy()
    }

    fun acceptPolicy()
    {
        val effectPack = this.currentPolicy.Accept()
        val city.ImplementPolicy(effectPack)
        this.SetPolicy()
    }

    fun declinePolicy()
    {
        val effectPack = this.currentPolicy.Decline()
        this.city.ImplementPolicy(effectPack)
        this.SetPolicy()
    }

}
