package py.com.sample.demo.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import py.com.sample.demo.R;
import py.com.sample.demo.activities.CardItemDetailActivity;
import py.com.sample.demo.utils.Bus;

/**
 * Created by Luis on 8/6/2016.
 */
public class CardListFragment extends Fragment {

    private List<Bus> busData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycleViewCardList);
        initRecycleView(mRecyclerView);

        return rootView;
    }

    /**
     * Config the RecyclerView
     *
     * @param mRecyclerView
     */
    private void initRecycleView(RecyclerView mRecyclerView) {
        initListCardView();
        // Set the LayoutManager for RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Set the Adapter for RecyclerView
        mRecyclerView.setAdapter(new ItemRecyclerViewAdapter(getActivity(), busData));
    }

    private void initListCardView() {
        busData = new ArrayList<Bus>();
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        Bus bus3 = new Bus();
        bus1.setImageResoureId(R.drawable.bus_5);
        bus1.setHorario("07:00 a 14:00");
        bus1.setPrecio("50000");
        bus2.setImageResoureId(R.drawable.bus_5);
        bus2.setHorario("07:00 a 14:00");
        bus2.setPrecio("50000");
        bus3.setImageResoureId(R.drawable.bus_5);
        bus3.setHorario("07:00 a 14:00");
        bus3.setPrecio("50000");
        busData.add(bus1);
        busData.add(bus2);
        busData.add(bus3);
    }

    /**
     * Get a ramdon list of Strings
     *
     * @param array  String's array
     * @param amount Amount of String output
     * @return
     */
    private List<String> getRandomSublist(String[] array, int amount) {
        ArrayList<String> list = new ArrayList<>(amount);
        Random random = new Random();
        while (list.size() < amount) {
            list.add(array[random.nextInt(array.length)]);
        }
        return list;
    }

    /**
     * Class Adapter for RecyclerView
     */
    public static class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        private List<Bus> mValues;

        public ItemRecyclerViewAdapter(Context context, List<Bus> items) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mBackground = mTypedValue.resourceId;
            mValues = items;
        }

        /**
         *
         */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public String mBoundString;

            public final View mView;
            public final ImageView mImageView;
            public final TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (ImageView) view.findViewById(R.id.card_item_image);
                mTextView = (TextView) view.findViewById(android.R.id.text1);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mTextView.getText();
            }
        }

        @Override
        public ItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_view_item_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ItemRecyclerViewAdapter.ViewHolder holder, int position) {
            holder.mImageView.setImageResource(mValues.get(position).getImageResoureId());

            //Set onClickListener over cardView item
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, CardItemDetailActivity.class);
                    intent.putExtra(CardItemDetailActivity.EXTRA_NAME_DETAIL, holder.mBoundString);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }
    }
}
