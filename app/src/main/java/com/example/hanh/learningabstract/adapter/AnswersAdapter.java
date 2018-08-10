package com.example.hanh.learningabstract.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hanh.learningabstract.R;
import com.example.hanh.learningabstract.data.model.Item;
import com.example.hanh.learningabstract.data.model.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {


    private  List<Product> mItems;
    public void addItem(Product product)
    {
        mItems.add(product);

    }

    private Context mContext;
    private PostItemListener mItemListener;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView titleTv;
        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.tvNameCall);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Product item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.getProductId());

            notifyDataSetChanged();
        }
    }

    public AnswersAdapter(Context context, List<Product> posts, PostItemListener itemListener) {
        mItems = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public AnswersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_list_call_api, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AnswersAdapter.ViewHolder holder, int position) {

        Product item = mItems.get(position);
        TextView textView = holder.titleTv;
        textView.setText(item.getDescription().replaceAll("\n", "<br/>")
                .replaceAll("\t", " ")
                .replaceAll(" {2}", " ")
                .replaceAll(" ", ""));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateAnswers(List<Product> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private Product getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(long id);
    }
}