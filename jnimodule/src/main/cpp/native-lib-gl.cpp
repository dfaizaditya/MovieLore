#include <jni.h>
#include <string>
#include <android/log.h>
#include <vector>

using namespace std;

vector<string> words = {"Movielore, a movie liblary app", "Hello this is the about page", "Implemented for final project asignment", "Dimas Aditya Faiz", "TKTPL 2020", "The end"};

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }

    srand(static_cast<unsigned int>(time(NULL)));

    return JNI_VERSION_1_6;
}

extern "C" JNIEXPORT jstring JNICALL
Java_id_ac_ui_cs_mobileprogramming_jnimodule_NativeModule_getRandomWords(JNIEnv *env, jclass) {
    string result = "";
    int randomNumber = 0 + ( std::rand() % ( 4 - 0 + 1 ) );
    result += words[randomNumber];

    return env->NewStringUTF(result.c_str());
}
