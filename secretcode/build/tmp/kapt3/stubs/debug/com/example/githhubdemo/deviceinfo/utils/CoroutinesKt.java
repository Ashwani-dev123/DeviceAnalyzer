package com.example.githhubdemo.deviceinfo.utils;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ad\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072/\b\u0004\u0010\b\u001a)\b\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0002\b\rH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"launchAndCollectWithViewLifecycle", "", "T", "Landroidx/fragment/app/Fragment;", "flow", "Lkotlinx/coroutines/flow/Flow;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "block", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/fragment/app/Fragment;Lkotlinx/coroutines/flow/Flow;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function3;)V", "app_debug"})
public final class CoroutinesKt {
    
    /**
     * Runs a block of code within a [CoroutineScope], and the execution of the block is repeated
     * until the lifecycle state of the [Fragment] is below [minActiveState].
     * This function is similar to [lifecycleScope.launch] with the difference that it repeats the execution of the block
     * until the [Fragment]'s lifecycle state is below [minActiveState].
     * @param minActiveState the minimum [Lifecycle.State] required to keep the block running.
     * @param block the block of code to be executed within the [CoroutineScope].
     */
    public static final <T extends java.lang.Object>void launchAndCollectWithViewLifecycle(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment $this$launchAndCollectWithViewLifecycle, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.Lifecycle.State minActiveState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block) {
    }
}