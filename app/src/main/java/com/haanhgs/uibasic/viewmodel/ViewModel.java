package com.haanhgs.uibasic.viewmodel;

import com.haanhgs.uibasic.model.Model;
import com.haanhgs.uibasic.model.Repo;
import androidx.lifecycle.LiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private final Repo repo = new Repo();

    public LiveData<Model> getModel(){
        return repo.getLiveData();
    }

    public void add(){
        repo.add();
    }

    public void take(){
        repo.take();
    }

    public void grow(){
        repo.grow();
    }

    public void shrink(){
        repo.shrink();
    }

    public void reset(){
        repo.reset();
    }

    public void toggle(){
        repo.toggle();
    }

}
