package com.example.l5

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ValidationForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validation_form)

        // Initialize views
        val toggleButton: ToggleButton = findViewById(R.id.toggle_button)
        val fullName: EditText = findViewById(R.id.full_name)
        val emailAddress: EditText = findViewById(R.id.email_address)
        val password: EditText = findViewById(R.id.password)
        val genderGroup: RadioGroup = findViewById(R.id.gender_group)
        val seekBar: SeekBar = findViewById(R.id.progress_bar)
        val submitButton: Button = findViewById(R.id.submit_button)

        // ToggleButton logic
        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                toggleButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#8A2BE2"))
            } else {
                toggleButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#CCCCCC"))
            }
        }

        // Submit button logic
        submitButton.setOnClickListener {
            val name = fullName.text.toString()
            val email = emailAddress.text.toString()
            val pass = password.text.toString()
            val selectedGenderId = genderGroup.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                null
            }
            val experienceRating = seekBar.progress

            // Validation logic
            if (name.isEmpty()) {
                showToast("Please enter your full name.")
                return@setOnClickListener
            }
            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                showToast("Please enter a valid email address.")
                return@setOnClickListener
            }
            if (pass.isEmpty() || pass.length < 6) {
                showToast("Password must be at least 6 characters long.")
                return@setOnClickListener
            }
            if (gender == null) {
                showToast("Please select a gender.")
                return@setOnClickListener
            }

            // If all validations pass
            val message = """Registration Successful!"""
            showToast(message)
        }
    }

    // Helper function to show toast messages
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
