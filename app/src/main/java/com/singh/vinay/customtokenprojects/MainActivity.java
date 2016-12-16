package com.singh.vinay.customtokenprojects;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.plumillonforge.android.chipview.Chip;
import com.plumillonforge.android.chipview.ChipView;
import com.plumillonforge.android.chipview.ChipViewAdapter;
import com.plumillonforge.android.chipview.OnChipClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnChipClickListener {
    private List<Chip> chipArraylist;
    ChipViewAdapter particepetadapter;
    ChipView particepentschip;
    EditText input_value;
     ArrayList<String> sel_particepents;
    AutoCompleteTextView what;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        particepentschip = (ChipView) findViewById(R.id.participant_chip_chat);
        chipArraylist = new ArrayList<>();
        particepetadapter = new MainChipViewAdapter(this);
        what = (AutoCompleteTextView) findViewById(R.id.select_what);
        what.setFocusable(false);
        what.setClickable(true);
        input_value = (EditText) findViewById(R.id.input_value);
        sel_particepents = new ArrayList<>();
        Button button = (Button) findViewById(R.id.Create_token);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = input_value.getText().toString();
                sel_particepents.add(tag);
                createTokenView(tag, chipArraylist, particepentschip, particepetadapter);


            }
        });
        what.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                what.showDropDown();
            }
        });

        CustomAdapterWhat   adapterWhat = new CustomAdapterWhat(this, R.layout.spinner_rows, sel_particepents);
        what.setAdapter(adapterWhat);

    }

    private void createTokenView(String name, List<Chip> mTagList, ChipView chipView, ChipViewAdapter chipAdapter) {
        mTagList.add(new Tag(name));
        chipView.setAdapter(chipAdapter);
        chipView.setChipLayoutRes(R.layout.chip_close);
        chipView.setChipBackgroundColor(getResources().getColor(R.color.radio_button_selected_color));
        chipView.setChipList(mTagList);
        chipView.setOnChipClickListener(MainActivity.this);
    }

    @Override
    public void onChipClick(Chip chip) {
        particepentschip.remove(chip);
    }
}
