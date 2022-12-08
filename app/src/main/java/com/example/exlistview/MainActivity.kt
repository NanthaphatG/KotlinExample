package com.example.exlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.internal.schedulers.IoScheduler
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView : RecyclerView? = null

        recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val url = "https://hf-android-app.s3-eu-west-1.amazonaws.com/android-test/"
        val retrofit = Retrofit.Builder().addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        ).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).baseUrl(url).build()

        val postFoodAPI = retrofit.create(INetworkAPI::class.java)
        val response = postFoodAPI.getAlldata()
        response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe{
            recyclerView!!.adapter = MyAdapter(it,this)
        }

    }
}