package id.ac.ui.cs.mobileprogramming.jnimodule;

public class NativeModule {
    static {
        System.loadLibrary("native-lib-gl");
    }

    public static native String getRandomWords();
}
