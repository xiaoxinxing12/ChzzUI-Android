package org.chzz.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.chzz.badge.CHZZBadgeRadioButton;
import org.chzz.dialog.GradeAlertDialog;
import org.chzz.dialog.SweetAlertDialog;
import org.chzz.downmenu.DropDownMenu;
import org.chzz.downmenu.interfaces.OnFilterDoneListener;
import org.chzz.library.ColorUtil;
import org.chzz.library.DateUtils;
import org.chzz.library.DensityUtil;
import org.chzz.picker.TimePickerView;
import org.chzz.update.UpdateHelper;
import org.chzz.update.pojo.UpdateInfo;
import org.chzz.widget.CHZZDownMenu;
import org.chzz.widget.CHZZPickerView;
import org.chzz.widget.CHZZScrollView;
import org.chzz.widget.NiceSpinner;
import org.chzz.widget.NiceSpinnerBaseAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CHZZScrollView.ScrollListener, View.OnTouchListener, OnFilterDoneListener, NiceSpinnerBaseAdapter.onCheckBoxChecked {

    CHZZDownMenu mCHZZDownMenu;
    private GirdDropDownAdapter batchAdapter, departmentsAdapter, stepAdapter, professionalAdapter;
    private String batch[] = {"人民医院外院2014级3年制5批次", "人民医院外院2014级3年制3批次", "人民医院2013级3年制1批次", "测试带批次的多次轮转4"};

    private String departments[] = {"心血管内科", "肾内科", "血液内科", "皮肤科", "肾内科", "血液内科", "皮肤科"};
    private String step[] = {"无阶段", "一阶段"};
    private String professional[] = {"全科`11111111111", "产科1111111111111"};
    private String headers[] = {"选择批次", "专业方向", "选择阶段", "选择科室"};
    private List<View> popupViews = new ArrayList<>();
    private int adViewHeight = 180; // 广告视图的高度
    private int adViewTopSpace; // 广告视图距离顶部的距离
    private int titleViewHeight = 50; // 标题栏的高度
    private boolean isStickyTop = false; // 是否吸附在顶部
    private Toolbar mToolbar;
    private LinearLayout mLinearLayout;
    private CHZZScrollView mScrollView;
    private Button mColor;
    private CHZZBadgeRadioButton mBadgeRadioButton;
    private CHZZPickerView mNumberPicker;
    private List<String> mNumData = new ArrayList<String>();
    private Button mGrade;
    private TextView mTime;
    private TimePickerView pvTime;
    DropDownMenu dropDownMenu;
    private Map<String, Integer> mIntegerList = new HashMap<>();
    NiceSpinner niceSpinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCHZZDownMenu = (CHZZDownMenu) findViewById(R.id.CHZZ_DownMenu);
        dropDownMenu = (DropDownMenu) findViewById(R.id.dropDownMenu);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mLinearLayout = (LinearLayout) findViewById(R.id.toolbar_top);
        mScrollView = (CHZZScrollView) findViewById(R.id.sv_test);
        mColor = (Button) findViewById(R.id.but_color);
        mBadgeRadioButton = (CHZZBadgeRadioButton) findViewById(R.id.brb_main_home);
        mBadgeRadioButton.showTextBadge("10");
        mNumberPicker = (CHZZPickerView) findViewById(R.id.numberpicker);
        mGrade = (Button) findViewById(R.id.but_grade);
        mTime = (TextView) findViewById(R.id.tvTime);

        getData();
        mNumberPicker.setData(mNumData);
        mNumberPicker.setOnSelectListener(new CHZZPickerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                Toast.makeText(MainActivity.this, "your select " + text, Toast.LENGTH_SHORT).show();
            }
        });
        initView();

        NiceSpinner niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
        final List<String> dataset = new LinkedList<>(Arrays.asList("One11111111111111111111111111111111111111111111111111111111", "Two", "Three", "Four", "Five"));
        niceSpinner.attachDataSource(dataset);
        niceSpinner.setSelectedIndex(3);
        niceSpinner.setText("9999");
        niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, dataset.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        niceSpinner1 = (NiceSpinner) findViewById(R.id.nice_spinner1);
        final List<String> dataset1 = new LinkedList<>(Arrays.asList("One11111111111111111111111111111111111111111111111111111111", "Two", "Three", "Four", "Five"));
        niceSpinner1.attachDataSource(dataset, true, this);
        niceSpinner1.setSelectedIndex(3);
        niceSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, dataset.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    private void initView() {
        //init city menu


        mScrollView.setScrollListener(this);
        mScrollView.setOnTouchListener(this);
        final ListView batchView = new ListView(this);
        batchAdapter = new GirdDropDownAdapter(this, Arrays.asList(batch));
        batchView.setDividerHeight(0);
        batchView.setAdapter(batchAdapter);

        final ListView departmentsView = new ListView(this);
        departmentsAdapter = new GirdDropDownAdapter(this, Arrays.asList(departments));
        departmentsView.setDividerHeight(0);
        departmentsView.setAdapter(departmentsAdapter);

        final ListView stepView = new ListView(this);
        stepAdapter = new GirdDropDownAdapter(this, Arrays.asList(step));
        stepView.setDividerHeight(0);
        stepView.setAdapter(stepAdapter);

        final ListView professionalView = new ListView(this);
        professionalAdapter = new GirdDropDownAdapter(this, Arrays.asList(professional));
        professionalView.setDividerHeight(0);
        professionalView.setAdapter(professionalAdapter);

        DropMenuAdapter dropMenuAdapter = new DropMenuAdapter(this, professional, this);
        dropDownMenu.setMenuAdapter(dropMenuAdapter);

        popupViews.add(batchView);
        popupViews.add(departmentsView);
        popupViews.add(stepView);
        popupViews.add(professionalView);

        batchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                batchAdapter.setCheckItem(position);
                mCHZZDownMenu.setTabText(position == 0 ? headers[0] : batch[position]);
                mCHZZDownMenu.closeMenu();
            }
        });
        departmentsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                departmentsAdapter.setCheckItem(position);
                mCHZZDownMenu.setTabText(position == 0 ? headers[1] : departments[position]);
                mCHZZDownMenu.closeMenu();
            }
        });

        stepView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                stepAdapter.setCheckItem(position);
                mCHZZDownMenu.setTabText(position == 0 ? headers[2] : step[position]);
                mCHZZDownMenu.closeMenu();
            }
        });

        professionalView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                professionalAdapter.setCheckItem(position);
                mCHZZDownMenu.setTabText(position == 0 ? headers[3] : professional[position]);
                mCHZZDownMenu.closeMenu();
            }
        });
        mColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent color = new Intent(MainActivity.this, ColorActivity.class);
                color.putExtra("colors", mColor.getCurrentTextColor());
                startActivityForResult(color, 100);
            }
        });

        TextView contentView = new TextView(this);
        contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //contentView.setText("内容显示区域");
        contentView.setGravity(Gravity.CENTER);
        contentView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        contentView.setVisibility(View.GONE);

        mCHZZDownMenu.setCHZZDownMenu(Arrays.asList(headers), popupViews, contentView);
        mGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeAlertDialog g = new GradeAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
                g.setCanceledOnTouchOutside(true);
                g.setNumData(mNumData);
                g.setGradeClickListener(new GradeAlertDialog.OnGradeClickListener() {
                    @Override
                    public void onClick(String text, GradeAlertDialog dialog) {
                        mGrade.setText(text);
                        dialog.cancel();
                    }
                });
                g.show();
            }
        });

        mTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvTime.setStartDateAndTips(DateUtils.stringToDates("2016-09-06"), "不能小于开始日期");
                pvTime.show();
            }
        });

        pvTime = new TimePickerView(this, TimePickerView.Type.YEAR_MONTH_DAY,
                DateUtils.stringToDates("2016-09-04"), DateUtils.stringToDates("2016-09-07"), "不能超出轮转期");
        //控制时间范围
//        Calendar calendar = Calendar.getInstance();
//        pvTime.setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR));//要在setTime 之前才有效果哦
        pvTime.setTime(new Date());
        pvTime.setTitle("2016-09-04至2016-09-07");
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);
        //时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                mTime.setText(getTime(date));
            }
        });


        UpdateInfo u = new UpdateInfo();
        u.setAppName("11");
        u.setApkUrl("11");
        u.setUpdateTips("11");
        u.setChangeLog("11");
        u.setVersionCode("55");
        UpdateHelper updateHelper = new UpdateHelper.Builder(this)
                .isAutoInstall(true) //设置为false需在下载完手动点击安装;默认值为true，下载后自动安装。
                .build();

        updateHelper.check(u, true);


    }

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (mCHZZDownMenu.isShowing()) {
            mCHZZDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }

    // 处理标题栏颜色渐变
    private void handleTitleBarColorEvaluate(int height) {
        float fraction;
        Log.i("adViewTopSpace", +adViewTopSpace + "");
        if (height < 60 && height > 0) {
            fraction = 1f - adViewTopSpace * 1f / 60;
            if (fraction < 0f) fraction = 0f;
            mToolbar.setAlpha(fraction);
            return;
        }

        float space = Math.abs(adViewTopSpace) * 1f;
        fraction = height;
        if (fraction < 0f) fraction = 0f;
        if (fraction > 1f) fraction = 1f;
        mToolbar.setAlpha(1f);

        if (fraction >= 1f || isStickyTop) {
            isStickyTop = true;
            //viewTitleBg.setAlpha(0f);
            //   viewActionMoreBg.setAlpha(0f);
            mToolbar.setBackgroundColor(this.getResources().getColor(R.color.colorPrimary));
        } else {
            //  viewTitleBg.setAlpha(1f - fraction);
            //  viewActionMoreBg.setAlpha(1f - fraction);
            mToolbar.setBackgroundColor(ColorUtil.getNewColorByStartEndColor(this, fraction, R.color.transparent, R.color.colorPrimary));
        }


    }


    @Override
    public void scrollOritention(int oritention) {
        switch (oritention) {
            case CHZZScrollView.SCROLL_DOWN:
                break;
            case CHZZScrollView.SCROLL_UP:
                break;
        }

        adViewTopSpace = DensityUtil.px2dip(this, mCHZZDownMenu.getTop());
        adViewHeight = DensityUtil.px2dip(this, mCHZZDownMenu.getHeight());
        // Log.i("adViewTopSpace", adViewTopSpace + ">" + adViewHeight + ">" + mScrollView.getScrollY());

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            // 可以监听到ScrollView的滚动事件
            Log.i("adViewTopSpace", "adViewTopSpace>" + mScrollView.getScrollY());
            handleTitleBarColorEvaluate(mScrollView.getScrollY());
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 100 && null != data) {
            int color = data.getIntExtra("color", -1);
            mColor.setTextColor(color);


        }

    }

    private void getData() {
        for (int i = 0; i < 10; i++) {
            mNumData.add("" + i);
        }
    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {

    }


    @Override
    public void setOnCheckedListener(int position, boolean isChecked) {
        if (isChecked) {
            mIntegerList.put(position + "", position);
            Toast.makeText(this, position + "增加", Toast.LENGTH_LONG).show();
        } else {
            mIntegerList.remove(position + "");
            Toast.makeText(this, position + "删除", Toast.LENGTH_LONG).show();
        }
        niceSpinner1.setText("已选" + mIntegerList.size() + "");
    }
}
