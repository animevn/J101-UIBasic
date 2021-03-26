package com.haanhgs.uibasic.model;

import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Repo {

    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final MutableLiveData<Model> liveData = new MutableLiveData<>();
    private final Model model = new Model();

    public Repo() {
        liveData.setValue(model);
    }

    public MutableLiveData<Model> getLiveData() {
        return liveData;
    }

    public void add(){
        executor.execute(() -> {
            model.setCount(model.getCount() + 1);
            liveData.postValue(model);
        });
    }

    public void take(){
        executor.execute(()->{
            model.setCount(model.getCount() - 1);
            liveData.postValue(model);
        });
    }

    public void grow(){
        executor.execute(()->{
            model.setSize(model.getSize() + 2);
            liveData.postValue(model);
        });
    }

    public void shrink(){
        executor.execute(()->{
            if (model.getSize() >= 2) {
                model.setSize(model.getSize() - 2);
                liveData.postValue(model);
            }
        });

    }

    public void reset(){
        executor.execute(()->{
            model.setCount(0);
            model.setSize(Model.SIZE);
            liveData.postValue(model);
        });
    }

    public void toggle(){
        executor.execute(()->{
            model.setShow(!model.isShow());
            liveData.postValue(model);
        });
    }

    public void shutdownExecutor(){
        executor.shutdown();
        try{
            if (!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
