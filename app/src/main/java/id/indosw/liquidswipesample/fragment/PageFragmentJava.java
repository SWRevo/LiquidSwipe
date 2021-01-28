package id.indosw.liquidswipesample.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import id.indosw.liquidswipesample.R;
import kotlin.jvm.internal.Intrinsics;

public final class PageFragmentJava extends Fragment {
    private int position = -1;

    @SuppressWarnings("ConstantConditions")
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle varBundle = this.getArguments();
        Integer intPos = varBundle != null ? varBundle.getInt("POSITION") : null;
        Intrinsics.checkNotNull(intPos);
        this.position = intPos;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int viewPos;
        if (this.position == 1) {
            viewPos = R.layout.first_page;
        } else if (this.position == 2) {
            viewPos = R.layout.second_page;
        } else {
            viewPos = R.layout.fragment_page_number;
        }

        int layoutId = viewPos;
        return this.getLayoutInflater().inflate(layoutId, container, false);
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (this.position == 1) {
            return;
        } else if (this.position == 2) {
            return;
        } else if (this.position == 3) {
            view.setBackgroundColor(
                    Color.rgb(
                            (int) 93.000002052D,
                            (int) 17.0000008857D,
                            (int) 247.0000004895D)
            );
        } else if (this.position == 4) {
            view.setBackgroundColor(
                    Color.rgb(255,
                            (int) 89.99848992300001D,
                            (int) 59.648553276D)
            );
        } else if (this.position == 5) {
            view.setBackgroundColor(
                    Color.rgb(
                            (int) 31.0000000635D,
                            (int) 3.00000005805D,
                            (int) 108.0000011565D)
            );
        } else if (this.position == 6) {
            view.setBackgroundColor(
                    Color.rgb(
                            (int) 87.0000024255D,
                            (int) 159.00000572099998D,
                            (int) 43.000001229D)
            );
        } else {
            view.setBackgroundColor(
                    Color.rgb(
                            (int) (Math.random() * (double) 255),
                            (int) (Math.random() * (double) 255),
                            (int) (Math.random() * (double) 255))
            );
        }

    }
}