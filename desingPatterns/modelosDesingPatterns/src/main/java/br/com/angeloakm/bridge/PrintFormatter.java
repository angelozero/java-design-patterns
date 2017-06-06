package br.com.angeloakm.bridge;

import java.util.List;

public class PrintFormatter implements Formatter {

	public String format(String header, List<Detail> details) {
		StringBuilder builder = new StringBuilder();
		builder.append(header);
		builder.append("\n");

		for (Detail detail : details) {
			builder.append(detail.getItem());
			builder.append(":");
			builder.append(detail.getDesc());
			builder.append("\n");
		}

		return builder.toString();
	}

	

}
