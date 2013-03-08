#include <stdio.h>
#include <jni.h>
#include <android/log.h>

void nativeIntToJni(JNIEnv* env, jobject clazz, jint num){
	__android_log_print(ANDROID_LOG_INFO,"TAG","native get num is %d",num);
}

jstring nativeConversation(JNIEnv* env, jobject clazz, jstring fromJava){
  const char* message;
  message = (*env)->GetStringUTFChars(env,fromJava,NULL);

  __android_log_print(ANDROID_LOG_INFO,"TAG","message from java: %s", message);

  (*env)->ReleaseStringUTFChars(env, fromJava, message);
  return (*env)->NewStringUTF(env, "nice to see you , i am c");
}

/************** for register api  **************/
static const char* const KClassPath = "com/lingavin/jnisample/JavaToJni";

// java_method,  (in)return,  native_method
static JNINativeMethod gMethods[] = {
	{"intToJni","(I)V", (void*)nativeIntToJni},
	{"conversation","(Ljava/lang/String;)Ljava/lang/String;", (void*)nativeConversation},
};

static int registerNativeMethods(JNIEnv* env,const char* className,
		JNINativeMethod* gMethods, int numMethods){
	jclass clz;
	clz = (*env)->FindClass(env, className);
	if(clz == NULL){
		return JNI_FALSE;
	}

	if((*env)->RegisterNatives(env, clz, gMethods, numMethods) < 0){
		return JNI_FALSE;
	}
	return JNI_TRUE;
}

static int registerNatives(JNIEnv* env){
	return registerNativeMethods(env,KClassPath,gMethods,
			sizeof(gMethods)/sizeof(gMethods[0]));
}

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved){
	JNIEnv* env = NULL;
	jint result = -1;
	if((*vm)->GetEnv(vm, (void**)&env, JNI_VERSION_1_4) != JNI_OK){
		return result;
	}

	if(!registerNatives(env)){
		return result;
	}
	result = JNI_VERSION_1_4;
	return result;
}

/***************end for register api************/
