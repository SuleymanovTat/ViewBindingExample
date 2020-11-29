package ru.suleymanovtat.viewbindingapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.suleymanovtat.viewbindingapplication.databinding.ActivityOtherBinding
import ru.suleymanovtat.viewbindingapplication.ui.fragment.HomeFragment

class OtherActivity : AppCompatActivity() {

    lateinit var binding: ActivityOtherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(binding.parentLayout.id, HomeFragment())
                .addToBackStack("nav")
                .commit()
        }
    }
}