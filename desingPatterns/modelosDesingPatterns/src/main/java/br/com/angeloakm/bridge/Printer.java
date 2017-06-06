package br.com.angeloakm.bridge;

import java.util.List;

public abstract class Printer {

	public String print(Formatter formatter) {
		return formatter.format(getHeader(), getDeatails());
	}

	abstract protected String getHeader();

	abstract protected List<Detail> getDeatails();

}
