package hashing;

enum Flag {
	EMPTY,
	DELETED,
	FULL
}

public class HNode<T extends Comparable<T>> {
	
	private T data;
	private Flag flag;
	
	public HNode(T data) {
		this.data = data;
		flag = Flag.EMPTY;
	}
	
	@Override
	public String toString() {
		return String.format("[%s | %s]", data.toString(), flag);
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
