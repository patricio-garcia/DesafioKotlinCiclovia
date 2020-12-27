package cl.serlitoral.desafiokotlinciclovia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import cl.serlitoral.desafiokotlinciclovia.adapter.CicloviaAdapter
import cl.serlitoral.desafiokotlinciclovia.databinding.ActivityMainBinding
import cl.serlitoral.desafiokotlinciclovia.util.SetupCiclovias

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val adapter = CicloviaAdapter()
    val cicloviaSetUp = SetupCiclovias()
    val spinnerList = cicloviaSetUp.getSpinnerList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showItems()
    }

    private fun showItems() {
        binding.cicloviaRecyclerview.adapter = adapter
        binding.cicloviaRecyclerview.layoutManager = LinearLayoutManager(this)

        val spinnerAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, spinnerList)
        binding.cicloviaSpinner.adapter = spinnerAdapter
        binding.cicloviaSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (spinnerList[position]) {
                    "Mostrar Todo" -> adapter.updateWithoutFilter()
                    else -> adapter.updateFilter(spinnerList[position])
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

}