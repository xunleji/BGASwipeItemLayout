package cn.bingoogolapple.androidcommon.adapter.demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import cn.bingoogolapple.androidcommon.adapter.demo.R;
import cn.bingoogolapple.androidcommon.adapter.demo.mode.IndexModel;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/5/22 16:31
 * 描述:
 */
public class RecyclerIndexAdapter extends BGARecyclerViewAdapter<IndexModel> {
    public RecyclerIndexAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.item_indexview);
    }

    @Override
    public void setItemChildListener(BGAViewHolderHelper viewHolderHelper) {
        viewHolderHelper.setItemChildClickListener(R.id.tv_item_indexview_name);
    }

    @Override
    public void fillData(BGAViewHolderHelper viewHolderHelper, int position, IndexModel model) {
        int section = getSectionForPosition(position);
        if (position == getPositionForSection(section)) {
            viewHolderHelper.setVisibility(R.id.tv_item_indexview_catalog, View.VISIBLE);
            viewHolderHelper.setText(R.id.tv_item_indexview_catalog, model.topc);
        } else {
            viewHolderHelper.setVisibility(R.id.tv_item_indexview_catalog, View.GONE);
        }
        viewHolderHelper.setText(R.id.tv_item_indexview_name, model.name);
    }

    public int getSectionForPosition(int position) {
        return mDatas.get(position).topc.charAt(0);
    }

    public int getPositionForSection(int section) {
        for (int i = 0; i < getItemCount(); i++) {
            String sortStr = mDatas.get(i).topc;
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }
}