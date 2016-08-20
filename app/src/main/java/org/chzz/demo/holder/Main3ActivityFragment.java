package org.chzz.demo.holder;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.chzz.demo.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class Main3ActivityFragment extends Fragment {

    public Main3ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main3, container, false);
    }
}
