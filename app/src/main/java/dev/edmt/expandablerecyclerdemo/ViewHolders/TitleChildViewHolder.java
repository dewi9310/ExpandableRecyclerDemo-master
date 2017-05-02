package dev.edmt.expandablerecyclerdemo.ViewHolders;

import android.support.v7.widget.CardView;
import android.text.Editable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import dev.edmt.expandablerecyclerdemo.MainActivity;
import dev.edmt.expandablerecyclerdemo.R;

/**
 * Created by reale on 23/11/2016.
 */

public class TitleChildViewHolder extends ChildViewHolder {
    public TextView option1,option2;
    public LinearLayout ln;
    public CardView cardView;
    public TitleChildViewHolder(View itemView, int id) {
        super(itemView);
//        option1 = (TextView)itemView.findViewById(R.id.option1);
//        option2 = (TextView)itemView.findViewById(R.id.option2);
        cardView = (CardView) itemView.findViewById(R.id.myRoot);
        LinearLayout.LayoutParams mRparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ln = new LinearLayout(cardView.getContext());
        ln.setLayoutParams(mRparams);
        ln.setId(id);
        ln.setOrientation(LinearLayout.VERTICAL);
        cardView.addView(ln);


    }

}
