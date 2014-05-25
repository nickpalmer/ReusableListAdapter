package codes.nick.reusablelistadapter.example;

public class DataItem {
	private String text;
	private long timestamp;

	public DataItem(int i) {
		text = "Data Item: " + i;
		timestamp = System.currentTimeMillis();
	}

	public String getText() {
		return text;
	}

	public long getTimestamp() {
		return timestamp;
	}

}
