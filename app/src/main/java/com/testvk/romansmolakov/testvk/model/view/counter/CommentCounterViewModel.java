package com.testvk.romansmolakov.testvk.model.view.counter;

import com.testvk.romansmolakov.testvk.model.Comments;

public class CommentCounterViewModel extends CounterViewModel{

    private Comments mComments;

    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());

        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}