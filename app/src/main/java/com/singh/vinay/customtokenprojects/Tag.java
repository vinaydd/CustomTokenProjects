package com.singh.vinay.customtokenprojects;

import com.plumillonforge.android.chipview.Chip;

/**
 * Created by root on 26/11/15.
 */
public class Tag implements Chip {
    private String mName;
    private int mType = 0;

    public Tag(String name, int type) {
        this(name);
        mType = type;
    }

    public Tag(String name) {
        mName = name;
    }

    @Override
    public String getText() {
        return mName;
    }

    public int getType() {
        return mType;
    }
}