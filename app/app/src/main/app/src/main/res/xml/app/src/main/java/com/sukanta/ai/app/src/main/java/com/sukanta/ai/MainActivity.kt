package com.sukanta.ai

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Yahan baad me tum apni Claude API Key daloge
    private val CLAUDE_API_KEY = "sk-ant-api-key-here"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Mic permission maangna
        requestPermissions(arrayOf(Manifest.permission.RECORD_AUDIO), 101)
        
        val layout = LinearLayout(this).apply { 
            orientation = LinearLayout.VERTICAL 
            setPadding(50, 50, 50, 50)
        }
        
        val btnAccessibility = Button(this).apply { 
            text = "Enable AI Control (Settings)"
            setOnClickListener { 
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) 
            }
        }
        
        val btnTest = Button(this).apply {
            text = "Test Claude Setup"
            setOnClickListener {
                Toast.makeText(context, "App is Ready for API", Toast.LENGTH_SHORT).show()
            }
        }
        
        layout.addView(btnAccessibility)
        layout.addView(btnTest)
        setContentView(layout)
    }
}
