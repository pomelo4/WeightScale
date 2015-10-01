package com.pomelo.weightscale;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class DataActivity extends Activity {

    private LinearLayout mDataSummary;
    private TextView mTextContinuousDays;
    private TextView mTextReduceWeek;
    private TextView mTextReduceMonth;
    private ListView mWeightListView;
    private int mSelectedPosition = -1;
    private WeightDataAdapter mWeightDataAdapter;
    private String mCondition = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        mDataSummary = (LinearLayout)findViewById(R.id.DataSummary);

        mCondition = getIntent().getStringExtra("Condition");
        if( mCondition != null && !"".equals(mCondition) ) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));
            getActionBar().setTitle(getString(R.string.activity_title_search_result));
            mDataSummary.setVisibility(View.GONE);
        }

        mTextContinuousDays = (TextView)findViewById(R.id.TextContinuousDays);
        mTextReduceWeek  = (TextView)findViewById(R.id.TextReduceWeek);
        mTextReduceMonth = (TextView)findViewById(R.id.TextReduceMonth);
//        updateDataSummary();

        mWeightListView = (ListView)findViewById(R.id.WeightDataListView);
        mWeightDataAdapter = new WeightDataAdapter(this,mCondition);
        mWeightListView.setAdapter(mWeightDataAdapter);
        registerForContextMenu(mWeightListView);
    }
}
