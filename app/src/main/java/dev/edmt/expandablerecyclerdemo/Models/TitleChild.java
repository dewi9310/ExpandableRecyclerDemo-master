package dev.edmt.expandablerecyclerdemo.Models;

import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by reale on 23/11/2016.
 */

public class TitleChild {

    public EditText option1;
    public String option2;

    public TitleChild(EditText option1) {
        this.option1 = option1;
//        this.option2 = option2;
    }

    public EditText getOption1() {
        return option1;
    }

    public void setOption1(EditText option1) {
        this.option1 = option1;
    }

//    public String getOption2() {
//        return option2;
//    }
//
//    public void setOption2(String option2) {
//        this.option2 = option2;
//    }
}
