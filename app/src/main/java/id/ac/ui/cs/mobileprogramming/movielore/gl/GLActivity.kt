package id.ac.ui.cs.mobileprogramming.movielore.gl

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.ac.ui.cs.mobileprogramming.movielore.R
import id.ac.ui.cs.mobileprogramming.movielore.gl.CustomGLSurfaceView

class GLActivity : AppCompatActivity() {

    private lateinit var glSurfaceView: CustomGLSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initGL()
    }

    private fun initGL() {
        Log.e("Alert", "InitGL")
        glSurfaceView = CustomGLSurfaceView(this)
        setContentView(glSurfaceView)
    }


    override fun onPause() {
        super.onPause()
        if(glSurfaceView.rendererSet)
            glSurfaceView.onPause()
    }

    override fun onResume() {
        super.onResume()
        if(glSurfaceView.rendererSet)
            glSurfaceView.onResume()
    }
}
