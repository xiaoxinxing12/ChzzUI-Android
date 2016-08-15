package org.chzz.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.chzz.R;


/**
 * @author angelo.marchesin
 */

@SuppressWarnings("unused")
public abstract class NiceSpinnerBaseAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected int mSelectedIndex;
    protected int mTextColor;
    protected int mBackgroundSelector;
    protected boolean isCheckBox;
    private onCheckBoxChecked mClickCheckBox;

    public NiceSpinnerBaseAdapter(Context context, int textColor, int backgroundSelector, boolean isCheckBox, onCheckBoxChecked onClickCheckBox) {
        mContext = context;
        mTextColor = textColor;
        mBackgroundSelector = backgroundSelector;
        this.isCheckBox = isCheckBox;
        mClickCheckBox = onClickCheckBox;
    }

    @Override
    @SuppressWarnings("unchecked")
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.spinner_list_item, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_tinted_spinner);
            viewHolder.mCheckBox = (CheckBox) convertView.findViewById(R.id.cb_tinted_spinner);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                viewHolder.textView.setBackground(ContextCompat.getDrawable(mContext, mBackgroundSelector));
                viewHolder.mCheckBox.setBackground(ContextCompat.getDrawable(mContext, mBackgroundSelector));
            }
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setVisibility(isCheckBox ? View.GONE : View.VISIBLE);
        viewHolder.mCheckBox.setVisibility(isCheckBox ? View.VISIBLE : View.GONE);
        viewHolder.textView.setText(getItem(position).toString());
        viewHolder.textView.setTextColor(mTextColor);
        viewHolder.mCheckBox.setText(getItem(position).toString());
        viewHolder.mCheckBox.setTextColor(mTextColor);
        viewHolder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mClickCheckBox == null)
                    return;
                mClickCheckBox.setOnCheckedListener(position, isChecked);
            }
        });
        return convertView;
    }

    public int getSelectedIndex() {
        return mSelectedIndex;
    }

    public void notifyItemSelected(int index) {
        mSelectedIndex = index;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract T getItem(int position);

    @Override
    public abstract int getCount();

    public abstract T getItemInDataset(int position);

    protected static class ViewHolder {

        public CheckBox mCheckBox;
        public TextView textView;

    }

    public interface onCheckBoxChecked {
        void setOnCheckedListener(int position, boolean isChecked);
    }
}
