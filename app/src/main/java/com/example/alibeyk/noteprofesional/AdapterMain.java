package com.example.alibeyk.noteprofesional;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {
    private Context context;
    private List<ModelNote> modelNoteList;

    public AdapterMain(Context context) {
        this.context = context;
        modelNoteList = new ArrayList<>();
        //برای اینکه ما بگیم لیست رو بگیر اما لیست فعلا داخلش هیچی نیست باید این کد را بنویسیم
        //modelNoteList=new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_note_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.BindItem(modelNoteList.get(position));
//        holder.itemCardView.setCardBackgroundColor(randomColor());


    }

    @Override
    public int getItemCount() {
        return modelNoteList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CardView itemCardView;
        private ConstraintLayout itemConstrainDescribe;
        private TextView itemTextDescribe;
        private ConstraintLayout itemConstrainSubject;
        private TextView itemTextSubject;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCardView = itemView.findViewById(R.id.ItemCardView);
            itemConstrainDescribe = itemView.findViewById(R.id.ItemConstrainDescribe);
            itemTextDescribe = itemView.findViewById(R.id.ItemTextDescribe);
            itemConstrainSubject = itemView.findViewById(R.id.ItemConstrainSubject);
            itemTextSubject = itemView.findViewById(R.id.ItemTextSubject);
        }

        public void BindItem(ModelNote modelNote) {
            itemTextSubject.setText(modelNote.getSubject());
            itemTextDescribe.setText(modelNote.getDescribe());
            itemConstrainDescribe.setBackgroundColor(Color.parseColor(modelNote.getColor()));
        }
    }

    public void addNote(ModelNote modelNote) {
        modelNoteList.add(modelNote);
        notifyDataSetChanged();
    }


}


//    public  int randomColor()
//    {
//        Random random= new Random();
//        return Color.argb(255, random.nextInt(256), random.nextInt(256),
//                random.nextInt(256));
//   }

//             if(nowaWplata.flag==1){
//                     holder.osoba.setTextColor(Color.RED);
//                     }
//                     else if(nowaWplata.flag==2){
//                     holder.osoba.setTextColor(Color.BLUE);
//                     }else if(nowaWplata.flag==3){
//                     holder.osoba.setTextColor(Color.GREEN);

