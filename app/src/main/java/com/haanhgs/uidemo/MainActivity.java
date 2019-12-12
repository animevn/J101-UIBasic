package com.haanhgs.uidemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvOutput)
    TextView tvOutput;
    @BindView(R.id.clUp)
    ConstraintLayout clUp;
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

    private static final float original = 15;
    private float size = 15;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tvOutput.setText(String.format("%s", 0));
    }

    private void add() {
        count++;
        tvOutput.setText(String.format("%s", count));
    }

    private void take() {
        count--;
        tvOutput.setText(String.format("%s", count));
    }

    private void grow() {
        size += 2;
        tvOutput.setTextSize(size);
    }

    private void shrink() {
        size -= 2;
        tvOutput.setTextSize(size);
    }

    private void reset() {
        count = 0;
        size = original;
        tvOutput.setTextSize(size);
        tvOutput.setText(String.format("%s", count));
    }

    private void toggle() {
        if (tvOutput.getVisibility() == View.VISIBLE) {
            tvOutput.setVisibility(View.INVISIBLE);
            bnShow.setText(R.string.bnShow);
        } else {
            tvOutput.setVisibility(View.VISIBLE);
            bnShow.setText(R.string.bnHide);
        }
    }

    @OnClick({R.id.bnAdd, R.id.bnTake, R.id.bnGrow, R.id.bnShrink, R.id.bnShow, R.id.bnReset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnAdd:
                add();
                break;
            case R.id.bnTake:
                take();
                break;
            case R.id.bnGrow:
                grow();
                break;
            case R.id.bnShrink:
                shrink();
                break;
            case R.id.bnShow:
                toggle();
                break;
            case R.id.bnReset:
                reset();
                break;
        }
    }
}
