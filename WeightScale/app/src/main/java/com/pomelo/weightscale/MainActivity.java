package com.pomelo.weightscale;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.app.TabActivity;
import android.content.Intent;

public class MainActivity extends TabActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAB_TAG_CHART  = "iChart";
    private static final String TAB_TAG_DATAS  = "iDatas";
    private static final String TAB_TAG_SQUARE = "iSquare";
    private static final String TAB_TAG_MORE   = "iMore";

    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));
        setContentView(R.layout.activity_main);

        RadioGroup mMainTab=(RadioGroup)findViewById(R.id.main_tab);
        mMainTab.setOnCheckedChangeListener(this);

        mTabHost = getTabHost();

        Intent iChart = new Intent(this, ChartActivity.class);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_TAG_CHART)
                .setIndicator(getResources().getString(R.string.menu_chart), getResources().getDrawable(R.drawable.menu_chart_selector))
                .setContent(iChart));

        Intent iDatas = new Intent(this, DataActivity.class);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_TAG_DATAS)
                .setIndicator(getResources().getString(R.string.menu_data), getResources().getDrawable(R.drawable.menu_data_selector))
                .setContent(iDatas));

        Intent iSquare = new Intent(this, SquareActivity.class);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_TAG_SQUARE)
                .setIndicator(getResources().getString(R.string.menu_more), getResources().getDrawable(R.drawable.menu_more_selector))
                .setContent(iSquare));

        Intent iMore = new Intent(this, MoreActivity.class);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_TAG_MORE)
                .setIndicator(getResources().getString(R.string.menu_more), getResources().getDrawable(R.drawable.menu_more_selector))
                .setContent(iMore));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.MenuButtonChart:
                this.mTabHost.setCurrentTabByTag(TAB_TAG_CHART);
                break;
            case R.id.MenuButtonDatas:
                this.mTabHost.setCurrentTabByTag(TAB_TAG_DATAS);
                break;
            case R.id.MenuButtonSquare:
                this.mTabHost.setCurrentTabByTag(TAB_TAG_SQUARE);
                break;
            case R.id.MenuButtonMore:
                this.mTabHost.setCurrentTabByTag(TAB_TAG_MORE);
                break;
            default:
                break;
        }
    }
}
