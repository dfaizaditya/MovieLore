package id.ac.ui.cs.mobileprogramming.movielore

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.jnimodule.NativeModule
import id.ac.ui.cs.mobileprogramming.movielore.gl.GLActivity
import id.ac.ui.cs.mobileprogramming.movielore.gl.GLFragment

class about_fragment : Fragment(R.layout.about_page){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent = Intent(getActivity(), aboutActivity::class.java)
        startActivity(intent)
//        (activity as aboutActivity).initList()
//        (activity as aboutActivity).initButtons()
//        (activity as aboutActivity).initGL()
//        initList()
//        initButtons()
//        initGL()
    }

}
