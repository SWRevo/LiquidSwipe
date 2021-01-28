package id.indosw.liquidswipesample.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

import id.indosw.liquidswipesample.fragment.PageFragmentJava;
import kotlin.jvm.internal.Intrinsics;

public class AdapterJava extends FragmentPagerAdapter {

    private final int total;
    private final ArrayList<PageFragmentJava> data;

    @NotNull
    public Fragment getItem(int position) {
        Fragment obj = data.get(position);
        Intrinsics.checkNotNullExpressionValue(obj, "data[position]");
        return obj;
    }

    public int getCount() {
        return total;
    }

    public AdapterJava(@NotNull FragmentManager fragmentManager) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        total = 6;
        data = new ArrayList<>(total);
        int i = 0;

        for(; i < total; ++i) {
            PageFragmentJava fragment = new PageFragmentJava();
            Bundle bundle = new Bundle();
            bundle.putInt("POSITION", i + 1);
            fragment.setArguments(bundle);
            data.add(fragment);
        }

    }
}
