package com.sparity.webchat.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sparity.webchat.R;
import com.sparity.webchat.activities.ListActivity;
import com.sparity.webchat.customviews.CircleTransform;
import com.sparity.webchat.models.ListModel;
import com.sparity.webchat.utility.Utility;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by madhu on 29-Jul-17.
 */

public class UserListAdapter extends BaseAdapter {
    private ListActivity mContext;
    private ArrayList<ListModel> listModels;
    private LayoutInflater layoutInflater;


    public UserListAdapter(ListActivity mContext, ArrayList<ListModel> listModels) {
        this.mContext = mContext;
        this.listModels = listModels;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listModels.size();
    }

    @Override
    public Object getItem(int position) {
        return listModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
            viewHolder = new ViewHolder();

            viewHolder.img_image = (ImageView) convertView.findViewById(R.id.img_image);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_email = (TextView) convertView.findViewById(R.id.tv_email);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }
        ListModel listModel = listModels.get(position);

        viewHolder.tv_name.setText(Utility.capitalizeFirstLetter(listModel.getUsername()));
        viewHolder.tv_email.setText(listModel.getEmail());

        Picasso.with(mContext)
                .load(listModel.getImage())
                .transform(new CircleTransform())
                .into(viewHolder.img_image);

        return convertView;
    }

    private class ViewHolder {
        private ImageView img_image;
        private TextView tv_name;
        private TextView tv_email;

    }
}
