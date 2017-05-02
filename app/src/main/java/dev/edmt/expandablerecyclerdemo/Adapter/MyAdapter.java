package dev.edmt.expandablerecyclerdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

import dev.edmt.expandablerecyclerdemo.MainActivity;
import dev.edmt.expandablerecyclerdemo.Models.TitleChild;
import dev.edmt.expandablerecyclerdemo.Models.TitleCreator;
import dev.edmt.expandablerecyclerdemo.Models.TitleParent;
import dev.edmt.expandablerecyclerdemo.R;
import dev.edmt.expandablerecyclerdemo.ViewHolders.TitleChildViewHolder;
import dev.edmt.expandablerecyclerdemo.ViewHolders.TitleParentViewHolder;

/**
 * Created by reale on 23/11/2016.
 */

public class MyAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> {

    LayoutInflater inflater;
    private List<TitleChild> multipleRowModelList;
    List<TitleCreator> creatorList = new ArrayList<>();
    LinearLayout ln;

    public MyAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
       View view = inflater.inflate(R.layout.list_parent,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.list_child,viewGroup,false);
        TitleCreator titleCreator = TitleCreator.get(view.getContext());

        List<TitleParent> titles = titleCreator.getAll();
        int id = 0;
        for (int i  =0; i < creatorList.size(); i++){
            id = Integer.parseInt(String.valueOf(titles.get(i).get_id().hashCode()));
            LinearLayout.LayoutParams mRparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            ln = new LinearLayout(view.getContext());
            ln.setLayoutParams(mRparams);
            ln.setId(id);
            ln.setOrientation(LinearLayout.VERTICAL);
        }
        return new TitleChildViewHolder(view, id);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent title = (TitleParent)o;
        titleParentViewHolder._textView.setText(title.getTitle());

    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        TitleChild title = (TitleChild) o;
        LinearLayout.LayoutParams mRparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


        EditText editText;
   ln = titleChildViewHolder.ln;
        ln.setTag(title.getOption1());
//        titleChildViewHolder.option1.setText(title.getOption1());
//        titleChildViewHolder.option2.setText(title.getOption2());


    if (ln.getChildCount() == 0){
        ln.addView(title.getOption1());
//        ln.addView(editText(i));
//        final EditText myEditText = new EditText(inflater.getContext());
////        myEditText.setId(Integer.parseInt(String.valueOf(title.get_id())));
////            myEditText.setText(title.getOption1().toString());
//        myEditText.setLayoutParams(mRparams);
//        ln.addView(myEditText);
    }

    }


    private List<EditText> editTextList = new ArrayList<EditText>();
    private EditText editText (int _ID){

//        titleChildViewHolder.option1.setText(title.getOption1());
//        titleChildViewHolder.option2.setText(title.getOption2());
        LinearLayout.LayoutParams mRparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        final EditText myEditText = new EditText(inflater.getContext());
        myEditText.setId(_ID);
//        myEditText.setText(title.getOption1().toString());
        myEditText.setLayoutParams(mRparams);
        editTextList.add(myEditText);
        return myEditText;
    }
}
