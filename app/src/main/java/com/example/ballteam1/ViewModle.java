package com.example.ballteam1;

import android.widget.BaseAdapter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

class MyViewModel5 extends ViewModel {
    private MutableLiveData AScore;
    private MutableLiveData BScore;
    private int aBack, bBack;//这里定义了两个变量 用来存放前一个分值

    public MutableLiveData getANumber() {
        if (AScore == null) {
            AScore = new MutableLiveData<>();
            AScore.setValue(0);
        }
        return AScore;
    }

    public MutableLiveData<Integer> getBNumber() {
        if (BScore == null) {
            BScore = new MutableLiveData<>();
            BScore.setValue(0);
        }
        return BScore;
    }

    //当你每次点击加的时候就要把两个分值记录下来 如果不这样 但你多次操作撤回的时候 两边的分值可能都会发生变化
    public void addA(int s) {
        aBack = (int) AScore.getValue();
        bBack = (int) BScore.getValue();
        AScore.setValue(AScore.getValue() + "s");
    }

    public void addB(int s) {
        aBack = (int) AScore.getValue();
        bBack = (int) BScore.getValue();
        BScore.setValue(BScore.getValue() +"s");
    }

    public void reset() {//这里是当你点击重置按钮时，就清零,也要保存数据
        aBack = (int) AScore.getValue();
        bBack = (int) BScore.getValue();
        AScore.setValue(0);
        BScore.setValue(0);
    }

    public void undo() {//这里就是点击撤回的时候把前一个保存的值取回来，再填到里面去
        AScore.setValue(aBack);
        BScore.setValue(bBack);
    }
}
