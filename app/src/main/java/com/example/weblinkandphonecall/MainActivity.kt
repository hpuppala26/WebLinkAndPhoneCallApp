package com.example.weblinkandphonecall


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by ID
        val urlInput = findViewById<EditText>(R.id.url_input)
        val phoneInput = findViewById<EditText>(R.id.phone_input)
        val launchButton = findViewById<Button>(R.id.launch_button)
        val callButton = findViewById<Button>(R.id.call_button)
        val closeButton = findViewById<Button>(R.id.close_button)

        // Launch URL
        launchButton.setOnClickListener {
            val url = urlInput.text.toString()
            if (url.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter a URL", Toast.LENGTH_SHORT).show()
            }
        }

        // Make phone call
        callButton.setOnClickListener {
            val phone = phoneInput.text.toString()
            if (phone.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$phone")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_SHORT).show()
            }
        }

        // Close App
        closeButton.setOnClickListener {
            finish()
        }
    }
}
