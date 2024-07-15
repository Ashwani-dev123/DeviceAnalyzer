package com.example.githhubdemo.databinding;
import com.example.githhubdemo.R;
import com.example.githhubdemo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DashboardFragmentBindingImpl extends DashboardFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.arc_progress, 2);
        sViewsWithIds.put(R.id.ramTxt, 3);
        sViewsWithIds.put(R.id.textView1, 4);
        sViewsWithIds.put(R.id.systemStorage, 5);
        sViewsWithIds.put(R.id.textView4, 6);
        sViewsWithIds.put(R.id.textView3, 7);
        sViewsWithIds.put(R.id.batteryProgress, 8);
        sViewsWithIds.put(R.id.batteryPercentage, 9);
        sViewsWithIds.put(R.id.textView, 10);
        sViewsWithIds.put(R.id.listView, 11);
        sViewsWithIds.put(R.id.ivAndroid, 12);
        sViewsWithIds.put(R.id.storageProgress, 13);
        sViewsWithIds.put(R.id.tvFreeSpace, 14);
        sViewsWithIds.put(R.id.tvTotalSapce, 15);
        sViewsWithIds.put(R.id.tvPercentage, 16);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DashboardFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private DashboardFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.github.lzyzsd.circleprogress.ArcProgress) bindings[2]
            , (android.widget.TextView) bindings[9]
            , (android.widget.ProgressBar) bindings[8]
            , (android.widget.ImageView) bindings[12]
            , (com.airbnb.epoxy.EpoxyRecyclerView) bindings[11]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ProgressBar) bindings[13]
            , (android.widget.ProgressBar) bindings[5]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (androidx.cardview.widget.CardView) bindings[1]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[15]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.topBar.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.ramLoad == variableId) {
            setRamLoad((com.example.githhubdemo.deviceinfo.data.model.RamLoad) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRamLoad(@Nullable com.example.githhubdemo.deviceinfo.data.model.RamLoad RamLoad) {
        this.mRamLoad = RamLoad;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.ramLoad);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.githhubdemo.deviceinfo.data.model.RamLoad ramLoad = mRamLoad;

        if ((dirtyFlags & 0x3L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.example.githhubdemo.deviceinfo.utils.ViewBindingKt.setRamLoadColor(this.topBar, ramLoad);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ramLoad
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}