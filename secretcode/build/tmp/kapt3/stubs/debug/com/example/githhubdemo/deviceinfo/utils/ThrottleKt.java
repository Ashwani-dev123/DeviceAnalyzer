package com.example.githhubdemo.deviceinfo.utils;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, xi = 48, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a>\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a>\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a8\u0006\f"}, d2 = {"throttleFirst", "Lkotlin/Function1;", "T", "", "skipMs", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "destinationFunction", "throttleLatest", "skipTimeInMs", "block", "app_debug"})
public final class ThrottleKt {
    
    /**
     * Returns a function that limits the executions of the [block] function, until the [skipTimeInMs]
     * passes, then the latest value passed to [block] will be used. Any calls before [skipTimeInMs]
     * passes will be ignored. All calls to the returned function must happen on the same thread.
     *
     * Credit to Terenfear https://gist.github.com/Terenfear/a84863be501d3399889455f391eeefe5
     *
     * @param skipTimeInMs the time to wait until the next call to [block] be processed.
     * @param coroutineScope the coroutine scope where [block] will executed.
     * @param block function to be execute.
     */
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Object>kotlin.jvm.functions.Function1<T, kotlin.Unit> throttleLatest(long skipTimeInMs, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> block) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Object>kotlin.jvm.functions.Function1<T, kotlin.Unit> throttleFirst(long skipMs, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> destinationFunction) {
        return null;
    }
}