package com.haanhgs.uibasic.view;

import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import com.haanhgs.uibasic.R;
import com.haanhgs.uibasic.databinding.ActivityMainBinding;
import com.haanhgs.uibasic.viewmodel.ViewModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        hideActionBarInLandscapeMode();
        viewModel.getModel().observe(this, model -> {
            binding.tvOutput.setText(String.valueOf(model.getCount()));
            binding.tvOutput.setTextSize(model.getSize());
            if (model.isShow()){
                binding.tvOutput.setVisibility(View.VISIBLE);
                binding.bnShow.setText(R.string.bnHide);
            }else {
                binding.tvOutput.setVisibility(View.INVISIBLE);
                binding.bnShow.setText(R.string.bnShow);
            }
        });

        binding.bnAdd.setOnClickListener(v -> viewModel.add());
        binding.bnTake.setOnClickListener(v -> viewModel.take());
        binding.bnGrow.setOnClickListener(v -> viewModel.grow());
        binding.bnShrink.setOnClickListener(v -> viewModel.shrink());
        binding.bnShow.setOnClickListener(v -> viewModel.toggle());
        binding.bnReset.setOnClickListener(v -> viewModel.reset());
    }

    private void hideActionBarInLandscapeMode(){
        int rotation = getDisplay().getRotation();
        if (rotation == Surface.ROTATION_270 || rotation == Surface.ROTATION_90){
            if (getSupportActionBar() != null) getSupportActionBar().hide();
        }
    }

}
