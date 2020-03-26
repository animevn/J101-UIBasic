package com.haanhgs.uibasic.model;

import androidx.lifecycle.MutableLiveData;

public class Repo {

    private MutableLiveData<Model> liveData = new MutableLiveData<>();
    private Model model = new Model();

    public Repo() {
        liveData.setValue(model);
    }

    public MutableLiveData<Model> getLiveData() {
        return liveData;
    }

    public void add(){
        model.setCount(model.getCount() + 1);
        liveData.setValue(model);
    }

    public void take(){
        model.setCount(model.getCount() - 1);
        liveData.setValue(model);
    }

    public void grow(){
        model.setSize(model.getSize() + 2);
        liveData.setValue(model);
    }

    public void shrink(){
        if (model.getSize() >= 2) model.setSize(model.getSize() - 2);
        liveData.setValue(model);
    }

    public void reset(){
        model.setCount(0);
        model.setSize(Model.SIZE);
        liveData.setValue(model);
    }

    public void toggle(){
        model.setShow(!model.isShow());
        liveData.setValue(model);
    }


}
