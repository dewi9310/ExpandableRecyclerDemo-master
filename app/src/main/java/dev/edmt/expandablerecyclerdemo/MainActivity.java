package dev.edmt.expandablerecyclerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dev.edmt.expandablerecyclerdemo.Adapter.MyAdapter;
import dev.edmt.expandablerecyclerdemo.Models.TitleChild;
import dev.edmt.expandablerecyclerdemo.Models.TitleCreator;
import dev.edmt.expandablerecyclerdemo.Models.TitleParent;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this,initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);
    }

    private List<ParentObject> initData() {
        TitleCreator titleCreator = TitleCreator.get(this);
        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObject = new ArrayList<>();
//        LayoutInflater layoutInflater = LayoutInflater.from(this);
//        View viewTb = layoutInflater.inflate(R.layout.list_child, null);
//        LinearLayout layout;
//        layout = new LinearLayout(getApplicationContext());

//        titleChildViewHolder.option1.setText(title.getOption1());
//        titleChildViewHolder.option2.setText(title.getOption2());
//        LinearLayout.LayoutParams mRparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        for(TitleParent title:titles)
        {
            List<Object> childList = new ArrayList<>();
//            childList.add(new TitleChild("Add to contacts","Send message"));
//        final EditText myEditText = new EditText(layoutInflater.getContext());
//        myEditText.setId(String.valueOf(title.get_id()).hashCode());
////            myEditText.setText(title.getOption1().toString());
//        myEditText.setLayoutParams(mRparams);
//            layout.addView(myEditText);

            childList.add(new TitleChild(editText(String.valueOf(title.get_id()).hashCode())));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;

    }
    private List<EditText> editTextList = new ArrayList<EditText>();
    private EditText editText (int _ID){

        LayoutInflater inflater = LayoutInflater.from(this);
//        View viewTb = inflater.inflate(R.layout.list_child, null);
//        LinearLayout ln;
//        ln = (LinearLayout)viewTb.findViewById(R.id.ln);
        LinearLayout.LayoutParams mRparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        final EditText myEditText = new EditText(inflater.getContext());
        myEditText.setId(_ID);
//        myEditText.setText(title.getOption1().toString());
        myEditText.setLayoutParams(mRparams);
        editTextList.add(myEditText);
        return myEditText;
    }
}
