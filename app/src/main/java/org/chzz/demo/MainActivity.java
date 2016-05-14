package org.chzz.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.chzz.widget.CHZZDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CHZZDownMenu mCHZZDownMenu;
    private GirdDropDownAdapter batchAdapter, departmentsAdapter, stepAdapter, professionalAdapter;
    private String batch[] = {"人民医院外院2014级3年制5批次", "人民医院外院2014级3年制3批次", "人民医院2013级3年制1批次", "测试带批次的多次轮转4"};

    private String departments[] = {"心血管内科", "肾内科", "血液内科", "皮肤科", "肾内科", "血液内科", "皮肤科"};
    private String step[] = {"无阶段", "一阶段"};
    private String professional[] = {"全科", "产科"};
    private String headers[] = {"选择批次", "专业方向", "选择阶段", "选择科室"};
    private List<View> popupViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCHZZDownMenu = (CHZZDownMenu) findViewById(R.id.CHZZ_DownMenu);
        initView();
    }

    private void initView() {
        //init city menu
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


        TextView contentView = new TextView(this);
        contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        contentView.setText("内容显示区域");
        contentView.setGravity(Gravity.CENTER);
        contentView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        mCHZZDownMenu.setCHZZDownMenu(Arrays.asList(headers), popupViews, contentView);

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
}
