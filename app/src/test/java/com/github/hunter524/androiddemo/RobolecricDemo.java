package com.github.hunter524.androiddemo;

import com.github.hunter524.androiddemo.activity.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by hunter on 2016/10/27.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RobolecricDemo {
    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.button).performClick();
//        TextView textView = (TextView) activity.findViewById(R.id.textView);
//        assertThat(textView.getText().toString(), equalTo("hello"));
    }
    @Test
    public void clickingLogin_shouldStartLoginActivity2() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.button).performClick();
//        TextView textView = (TextView) activity.findViewById(R.id.textView);
//        assertThat(textView.getText().toString(), equalTo("hello"));
    }


}
