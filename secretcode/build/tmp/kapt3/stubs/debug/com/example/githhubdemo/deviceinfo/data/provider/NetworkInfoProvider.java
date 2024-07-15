package com.example.githhubdemo.deviceinfo.data.provider;

import android.net.wifi.WifiManager;
import kotlinx.coroutines.Dispatchers;
import java.net.InetAddress;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\f\u0010\u0010\u001a\u00020\u0011*\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/provider/NetworkInfoProvider;", "", "wifiManager", "Landroid/net/wifi/WifiManager;", "(Landroid/net/wifi/WifiManager;)V", "getLocalIPAndSubnetMask", "Lkotlin/Pair;", "Ljava/net/InetAddress;", "", "ping", "", "ip", "", "scanNetwork", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toByteArray", "", "app_debug"})
public final class NetworkInfoProvider {
    @org.jetbrains.annotations.NotNull
    private final android.net.wifi.WifiManager wifiManager = null;
    
    public NetworkInfoProvider(@org.jetbrains.annotations.NotNull
    android.net.wifi.WifiManager wifiManager) {
        super();
    }
    
    private final kotlin.Pair<java.net.InetAddress, java.lang.Integer> getLocalIPAndSubnetMask() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object scanNetwork(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    private final boolean ping(java.lang.String ip) {
        return false;
    }
    
    private final byte[] toByteArray(int $this$toByteArray) {
        return null;
    }
}