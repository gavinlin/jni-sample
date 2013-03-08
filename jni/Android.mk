LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := nativejni
LOCAL_SRC_FILES := native_sample_jni.c
LOCAL_MODULE_TAGS :=debug
LOCAL_ARM_MODE := arm
LOCAL_LDFLAGS = -llog
include $(BUILD_SHARED_LIBRARY)

