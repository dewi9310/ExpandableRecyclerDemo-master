package dev.edmt.expandablerecyclerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.edmt.expandablerecyclerdemo.Adapter.MyAdapter;
import dev.edmt.expandablerecyclerdemo.Models.TitleChild;
import dev.edmt.expandablerecyclerdemo.Models.TitleCreator;
import dev.edmt.expandablerecyclerdemo.Models.TitleParent;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button submit;
    RecyclerView.ViewHolder holder;
    private String Text;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button)findViewById(R.id.save);
        recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this,initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i= 0; i<editTextList.size(); i++){
                    Toast.makeText(getApplicationContext(), editTextList.get(i).getText().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private List<ParentObject> initData() {
        TitleCreator titleCreator = TitleCreator.get(this);
        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObject = new ArrayList<>();
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View viewTb = layoutInflater.inflate(R.layout.list_child, null);
        LinearLayout layout;
        layout = (LinearLayout)viewTb.findViewById(R.id.ln);
        LinearLayout.LayoutParams mRparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        List<Object>  childList = new ArrayList<>();

        for(TitleParent title:titles) {
            final EditText myEditText = new EditText(this);
            myEditText.setId(String.valueOf(title.get_id()).hashCode());
            childList.add(new TitleChild(editText(String.valueOf(title.get_id()).hashCode())));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        for (int j =0; j< parentObject.size(); j++){
            HashMap<ParentObject, Object> map = new HashMap<ParentObject, Object>();
            map.put(parentObject.get(j), childList.indexOf(parentObject));
        }
        return parentObject;

    }
    private List<EditText> editTextList = new ArrayList<EditText>();
    private EditText editText (int _ID){
        LinearLayout.LayoutParams mRparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        final EditText myEditText = new EditText(this);
        myEditText.setId(_ID);
        myEditText.setLayoutParams(mRparams);
        editTextList.add(myEditText);
        return myEditText;
    }
}
