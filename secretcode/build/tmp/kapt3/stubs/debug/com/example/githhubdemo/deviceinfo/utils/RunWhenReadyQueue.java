package com.example.githhubdemo.deviceinfo.utils;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A queue that acts as a gate, either executing tasks right away if the queue is marked as "ready",
 * i.e. gate is open, or queues them to be executed whenever the queue is marked as ready in the
 * future, i.e. gate becomes open.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\nJ\u0014\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/utils/RunWhenReadyQueue;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "isReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "tasks", "", "Lkotlin/Function0;", "", "", "ready", "runIfReadyOrQueue", "task", "app_debug"})
public final class RunWhenReadyQueue {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>> tasks = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.atomic.AtomicBoolean isReady = null;
    
    public RunWhenReadyQueue(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope scope) {
        super();
    }
    
    /**
     * Was this queue ever marked as 'ready' via a call to [ready]?
     *
     * @return Boolean value indicating if this queue is 'ready'.
     */
    public final boolean isReady() {
        return false;
    }
    
    /**
     * Runs the [task] if this queue is marked as ready, or queues it for later execution.
     *
     * @param task: The task to run now if queue is ready or queue for later execution.
     */
    public final void runIfReadyOrQueue(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> task) {
    }
    
    /**
     * Mark queue as ready. Pending tasks will execute, and all tasks passed to [runIfReadyOrQueue]
     * after this point will be executed immediately.
     */
    public final void ready() {
    }
    
    public RunWhenReadyQueue() {
        super();
    }
}