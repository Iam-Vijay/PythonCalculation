package `in`.angryvijay.pythoncalculation

import `in`.angryvijay.pythoncalculation.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!Python.isStarted()){
            Python.start(AndroidPlatform(this))
        }

        var python = Python.getInstance()
        var pyobject = python.getModule("calculation")


        binding.add.setOnClickListener {
            var calculate = pyobject.callAttr("calculate",binding.firstnum.text.toString(),binding.secondnum.text.toString())
            Toast.makeText(this, calculate.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}