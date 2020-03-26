package com.haanhgs.uibasic.viewmodel;

import android.app.Application;
import com.haanhgs.uibasic.model.Model;
import com.haanhgs.uibasic.model.Repo;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ViewModel extends AndroidViewModel {

    private Repo repo;

    public ViewModel(@NonNull Application application) {
        super(application);
        repo = new Repo();
    }

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
