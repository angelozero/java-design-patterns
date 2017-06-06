package br.com.angeloakm.bridge;

public class Detail {

	private String item;
	private String desc;

	public Detail(String item, String desc) {
		this.item = item;
		this.desc = desc;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
