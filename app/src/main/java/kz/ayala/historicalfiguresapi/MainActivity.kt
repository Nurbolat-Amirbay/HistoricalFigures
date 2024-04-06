package kz.ayala.historicalfiguresapi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kz.ayala.historicalfiguresapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val adapter = HistAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)



        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(this)
        binding.etSearch.setOnEditorActionListener { it, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
                RetrofitMod.api.getHistFiguresByName(it.text.toString()).enqueue(object : Callback<List<HistFigure>> {
                    override fun onResponse(call: Call<List<HistFigure>>, response: Response<List<HistFigure>>) {
                        if (response.isSuccessful) {
                            adapter.submitList(response.body())
                        } else {
                            Log.e("Network 1", response.errorBody().toString())
                        }
                    }

                    override fun onFailure(call: Call<List<HistFigure>>, t: Throwable) {
                        Log.e("Network 2", t?.message.toString())
                    }
                })
                true
            } else false
        }

        setContentView(binding.root)
    }

}