package codes.nick.reusablelistadapter;

import android.view.View;

public abstract class ReusableViewHolder<T> {

	// Force constructor which takes a view.
	public ReusableViewHolder(View view) {
		view.setTag(this);
	}

	public abstract void bind(T data);
}
