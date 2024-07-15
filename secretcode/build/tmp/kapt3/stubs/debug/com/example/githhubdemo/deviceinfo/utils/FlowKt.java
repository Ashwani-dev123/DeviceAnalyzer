package com.example.githhubdemo.deviceinfo.utils;

import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006\u001a<\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\b0\u0006\u001a\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a6\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006\u001a/\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"filterChanged", "Lkotlinx/coroutines/flow/Flow;", "T", "R", "", "transform", "Lkotlin/Function1;", "ifAnyChanged", "", "ifChanged", "scanAndLimit", "limit", "", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.FlowPreview.class})
public final class FlowKt {
    
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Object>kotlinx.coroutines.flow.Flow<T> ifChanged(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<? extends T> $this$ifChanged) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Object, R extends java.lang.Object>kotlinx.coroutines.flow.Flow<T> ifChanged(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<? extends T> $this$ifChanged, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super T, ? extends R> transform) {
        return null;
    }
    
    /**
     * Returns a [Flow] containing only changed elements of the lists of the original [Flow].
     *
     * ```
     * Example: Identity function
     * Transform: x -> x (transformed values are the same as original)
     * Original Flow: list(0), list(0, 1), list(0, 1, 2, 3), list(4), list(5, 6, 7, 8)
     * Transformed:
     * (0)          -> (0 emitted because it is a new value)
     *
     * (0, 1)       -> (0 not emitted because same as previous value,
     *                 1 emitted because it is a new value),
     *
     * (0, 1, 2, 3) -> (0 and 1 not emitted because same as previous values,
     *                 2 and 3 emitted because they are new values),
     *
     * (4)          -> (4 emitted because because it is a new value)
     *
     * (5, 6, 7, 8) -> (5, 6, 7, 8 emitted because they are all new values)
     * Returned Flow: 0, 1, 2, 3, 4, 5, 6, 7, 8
     * ---
     *
     * Example: Modulo 2
     * Transform: x -> x % 2 (emit changed values if the result of modulo 2 changed)
     * Original Flow: listOf(1), listOf(1, 2), listOf(3, 4, 5), listOf(3, 4)
     * Transformed:
     * (1)          -> (1 emitted because it is a new value)
     *
     * (1, 0)       -> (1 not emitted because same as previous value with the same transformed value,
     *                 2 emitted because it is a new value),
     *
     * (1, 0, 1)    -> (3, 4, 5 emitted because they are all new values)
     *
     * (1, 0)       -> (3, 4 not emitted because same as previous values with same transformed values)
     *
     * Returned Flow: 1, 2, 3, 4, 5
     * ---
     * ```
     */
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Object, R extends java.lang.Object>kotlinx.coroutines.flow.Flow<T> filterChanged(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<? extends java.util.List<? extends T>> $this$filterChanged, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super T, ? extends R> transform) {
        return null;
    }
    
    /**
     * Returns a [Flow] containing only values of the original [Flow] where the result array
     * of calling [transform] contains at least one different value.
     *
     * Example:
     * ```
     * Block: x -> [x[0], x[1]]  // Map to first two characters of input
     * Original Flow: "banana", "bandanna", "bus", "apple", "big", "coconut", "circle", "home"
     * Mapped: [b, a], [b, a], [b, u], [a, p], [b, i], [c, o], [c, i], [h, o]
     * Returned Flow: "banana", "bus, "apple", "big", "coconut", "circle", "home"
     * ``
     */
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Object, R extends java.lang.Object>kotlinx.coroutines.flow.Flow<T> ifAnyChanged(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<? extends T> $this$ifAnyChanged, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super T, R[]> transform) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final <T extends java.lang.Object>java.lang.Object scanAndLimit(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<? extends T> $this$scanAndLimit, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<? extends T>> $completion) {
        return null;
    }
}