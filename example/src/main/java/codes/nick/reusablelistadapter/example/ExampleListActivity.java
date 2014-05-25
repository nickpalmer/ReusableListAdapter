package codes.nick.reusablelistadapter.example;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import codes.nick.reusablelistadapter.ReusableListAdapter;
import codes.nick.reusablelistadapter.ReusableViewHolder;

public class ExampleListActivity extends Activity {

	private static class DataItemViewHolder extends ReusableViewHolder<DataItem> {

		private final TextView mText;
		private final TextView mTimestamp;

		public DataItemViewHolder(View view) {
			super(view);
			mText = (TextView) view.findViewById(R.id.text);
			mTimestamp = (TextView) view.findViewById(R.id.timestamp);
		}

		@Override
		public void bind(DataItem data) {
			mText.setText(data.getText());
			mTimestamp.setText(String.valueOf(data.getTimestamp()));
		}
	}

	private static class DataItemListAdapter extends ReusableListAdapter<DataItem> {

		public DataItemListAdapter(Context context, int layoutId, List<DataItem> items) {
			super(context, layoutId, items);
		}

		@Override
		protected ReusableViewHolder<DataItem> buildViewHolder(View view) {
			return new DataItemViewHolder(view);
		}
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
		ListView list = (ListView) findViewById(R.id.list);
		list.setAdapter(new DataItemListAdapter(this, R.layout.item_layout, getData()));
    }

	public List<DataItem> getData() {
		List<DataItem> data = new ArrayList<DataItem>();
		for (int i = 0; i < 100; i++) {
			data.add(new DataItem(i));
		}
		return data;
	}
}
