# LiquidSwipe

[![GitHub license](https://img.shields.io/badge/license-MIT-lightgrey.svg)](https://raw.githubusercontent.com/Cuberto/flashy-tabbar-android/master/LICENSE)

[![](https://jitpack.io/v/SWRevo/LiquidSwipe.svg)](https://jitpack.io/#SWRevo/LiquidSwipe)

![Animation](https://raw.githubusercontent.com/Cuberto/liquid-swipe/master/Screenshots/animation.gif)

Create a beautiful animated slide courtesy of [Cuberto](https://github.com/Cuberto/liquid-swipe-android) and modified by SWRevo by adding a sample implementation in a Java project.

## Requirements

- Android 7.0+
- Java 1.8
- This library made with kotlin language

## Gradle

Add the following to your `build.gradle` to use:
```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.SWRevo:LiquidSwipe:1.0.0'
}
```

## Usage
Add LiquidPager to your xml and use it like you would ViewPager, define in xml:

```xml
<id.indosw.liquidswipe_lib.LiquidPager
        android:id="@+id/pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

Adapter in Kotlin :

```java
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.indosw.liquidswipesample.fragment.PageFragmentKt

class AdapterKt(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val total: Int = 6
    private val data : ArrayList<PageFragmentKt> = ArrayList(total)

    init {
        for (i in 0 until total) {
            val fragment = PageFragmentKt()
            val bundle = Bundle()
            bundle.putInt("POSITION", i+1)
            fragment.arguments = bundle
            data.add(fragment)
        }
    }


    override fun getItem(position: Int): Fragment {
        return data[position]
    }

    override fun getCount(): Int {
        return total
    }
}
```

Adapter in Java :

```java
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

```

PageFragment in Kotlin :

```java
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.indosw.liquidswipesample.R

class PageFragmentKt : Fragment() {
    private var position : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = arguments?.getInt("POSITION")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutId = when (position) {
            1 -> {
                R.layout.first_page
            }
            2 -> {
                R.layout.second_page
            }
            else -> R.layout.fragment_page_number
        }
        return layoutInflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (position) {
            1 -> return
            2 -> return
            3 -> view.setBackgroundColor(
                Color.rgb(
                    (0.3647058904 * 255).toInt(),
                    (0.06666667014 * 255).toInt(),
                    (0.9686274529 * 255).toInt()
                )
            )
            4 -> view.setBackgroundColor(
                Color.rgb(
                    255,
                    (0.3529352546 * 255).toInt(),
                    (0.2339158952 * 255).toInt()
                )
            )
            5 -> view.setBackgroundColor(
                Color.rgb(
                    (0.1215686277 * 255).toInt(),
                    (0.01176470611 * 255).toInt(),
                    (0.4235294163 * 255).toInt()
                )
            )
            6 -> view.setBackgroundColor(
                Color.rgb(
                    (0.3411764801 * 255).toInt(),
                    (0.6235294342 * 255).toInt(),
                    (0.1686274558 * 255).toInt()
                )
            )
            else -> view.setBackgroundColor(
                Color.rgb(
                    (Math.random() * 255).toInt(),
                    (Math.random() * 255).toInt(),
                    (Math.random() * 255).toInt()
                )
            )
        }

    }
}

```

PageFragment in Java :

```java
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

```

## iOS

Similar library [LiquidSwipe](https://github.com/Cuberto/liquid-swipe) by [Cuberto](https://github.com/Cuberto)

## Author

Cuberto Design, info@cuberto.com - Modification by IndoSW

## License

Liquid Swipe is available under the MIT license. See the LICENSE file for more info.
