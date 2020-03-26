package com.haanhgs.uibasic.view;

import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.haanhgs.uibasic.R;
import com.haanhgs.uibasic.viewmodel.ViewModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvOutput)
    TextView tvOutput;
    @BindView(R.id.bnAdd)
    Button bnAdd;
    @BindView(R.id.bnTake)
    Button bnTake;
    @BindView(R.id.bnGrow)
    Button bnGrow;
    @BindView(R.id.bnShrink)
    Button bnShrink;
    @BindView(R.id.bnShow)
    Button bnShow;
    @BindView(R.id.bnReset)
    Button bnReset;

    private ViewModel viewModel;

    private void initViewModel(){
        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        viewModel.getModel().observe(this, model -> {
            tvOutput.setText(String.valueOf(model.getCount()));
            tvOutput.setTextSize(model.getSize());
            if (model.isShow()){
                tvOutput.setVisibility(View.VISIBLE);
                bnShow.setText(R.string.bnHide);
            }else {
                tvOutput.setVisibility(View.INVISIBLE);
                bnShow.setText(R.string.bnShow);
            }
        });
    }

    private void hideActionBarInLandscapeMode(){
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_270 || rotation == Surface.ROTATION_90){
            if (getSupportActionBar() != null) getSupportActionBar().hide();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        hideActionBarInLandscapeMode();
        initViewModel();
    }

    @OnClick({R.id.bnAdd, R.id.bnTake, R.id.bnGrow, R.id.bnShrink, R.id.bnShow, R.id.bnReset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnAdd:
                viewModel.add();
                break;
            case R.id.bnTake:
                viewModel.take();
                break;
            case R.id.bnGrow:
                viewModel.grow();
                break;
            case R.id.bnShrink:
                viewModel.shrink();
                break;
            case R.id.bnShow:
                viewModel.toggle();
                break;
            case R.id.bnReset:
                viewModel.reset();
                break;
        }
    }
}
