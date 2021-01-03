package id.ac.ui.cs.mobileprogramming.jnimodule;

public class NativeGL {

    static {
        System.loadLibrary("opengl-triangle");
    }

    public static native void init(int w, int h);

    public static native void update();

}
