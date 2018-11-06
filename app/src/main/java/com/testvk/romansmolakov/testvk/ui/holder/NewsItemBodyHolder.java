package com.testvk.romansmolakov.testvk.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.testvk.romansmolakov.testvk.R;
import com.testvk.romansmolakov.testvk.model.view.NewsItemBodyViewModel;

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    public TextView tvText;


    public NewsItemBodyHolder(View itemView) {
        super(itemView);

        tvText = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel item) {
        tvText.setText(item.getText());
    }

    @Override
    public void unbindViewHolder() {
        tvText.setText(null);
    }
}