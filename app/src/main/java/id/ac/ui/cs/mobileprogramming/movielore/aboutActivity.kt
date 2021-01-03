package id.ac.ui.cs.mobileprogramming.movielore


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.jnimodule.NativeModule
import id.ac.ui.cs.mobileprogramming.movielore.gl.GLFragment

class aboutActivity : AppCompatActivity() {

    private lateinit var listAdapter: ListAdapter
    private lateinit var listRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_page)

        initList()
        initButtons()
        initGL()
    }

    public fun initGL() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = GLFragment()
        fragmentTransaction.add(R.id.glContainer, fragment)
        fragmentTransaction.commit()
    }


    public fun initList() {
        listRV = findViewById(R.id.listView)
        listAdapter = ListAdapter(ArrayList())
        listRV.adapter = listAdapter
        listRV.layoutManager = LinearLayoutManager(this)
    }

    public fun initButtons() {
        val button1 = findViewById<Button>(R.id.addButton)
        button1.setOnClickListener {
            val words = NativeModule.getRandomWords()
            listAdapter.addItem(words)
            listRV.scrollToPosition(listAdapter.itemCount - 1)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
