package id.ac.ui.cs.mobileprogramming.movielore.gl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

import id.ac.ui.cs.mobileprogramming.jnimodule.NativeGL;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLRenderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Log.i("DEMO", "w:"+width);
        Log.i("DEMO", "h:"+height);
        NativeGL.init(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        NativeGL.update();
    }
}
