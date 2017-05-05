package dev.edmt.expandablerecyclerdemo.Adapter;

import android.content.Context;
import android.opengl.Visibility;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.edmt.expandablerecyclerdemo.Models.TitleChild;
import dev.edmt.expandablerecyclerdemo.Models.TitleParent;
import dev.edmt.expandablerecyclerdemo.R;
import dev.edmt.expandablerecyclerdemo.ViewHolders.TitleChildViewHolder;
import dev.edmt.expandablerecyclerdemo.ViewHolders.TitleParentViewHolder;

/**
 * Created by reale on 23/11/2016.
 */

public class MyAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> {

    LayoutInflater inflater;
    EditText text;
    LinearLayout ln;
    private List<Object> multipleRowModelList;
    private List<Object> objectList;
    private List<ParentObject> parentObjectList;
    private static final int CHILD_VEGETARIAN = 0;
    private static final int CHILD_NORMAL = 1;
    public MyAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
        this.parentObjectList = parentItemList;
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
       View view = inflater.inflate(R.layout.list_parent,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {

        View view = inflater.inflate(R.layout.list_child,viewGroup,false);

        return new TitleChildViewHolder(view);
    }

//    @Override
//    public int getItemViewType(int position) {
//        if (parentObjectList.get(position) == multipleRowModelList.get(position)){
//            ln.setVisibility(View.VISIBLE);
//        }
//        return super.getItemViewType(position);
//    }
        
    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent titleParent = (TitleParent)o;

        multipleRowModelList = titleParent.getChildObjectList();
//        objectList.add(multipleRowModelList);
        for (int j =0; j< parentObjectList.size(); j++){
            HashMap<ParentObject, Object> map = new HashMap<ParentObject, Object>();
            map.put(parentObjectList.get(j), multipleRowModelList.get(j));
        }

        titleParentViewHolder._textView.setText(titleParent.getTitle());


    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        TitleChild title = (TitleChild) o;
        LinearLayout.LayoutParams mRparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


        EditText editText;
        ln = titleChildViewHolder.ln;

    if (ln.getChildCount() == 0){
                ln.addView(title.getOption1());
                ln.setVisibility(View.VISIBLE);
//                getItemViewType(i);

    }

    }

}
