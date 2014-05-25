package codes.nick.reusablelistadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class ReusableListAdapter<T> extends BaseAdapter {

	private final LayoutInflater mInflater;
	private final int mLayoutId;
	protected List<T> mData;

	public ReusableListAdapter(Context context, int layoutId, List<T> items) {
		mInflater = LayoutInflater.from(context);
		mLayoutId = layoutId;
		mData = items;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public T getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ReusableViewHolder<T> holder;
		View boundView;

		if (convertView == null) {
			boundView = mInflater.inflate(mLayoutId, null);
			holder = buildViewHolder(boundView);
		} else {
			boundView = convertView;
			holder = (ReusableViewHolder<T>) boundView.getTag();
		}
		holder.bind(getItem(position));

		return boundView;
	}

	protected abstract ReusableViewHolder<T> buildViewHolder(View view);
}
