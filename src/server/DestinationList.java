package server;

import java.util.ArrayList;
import util.StringUtils;

/**
 * Class to store a list of destination users.
 */
@SuppressWarnings("serial")
public class DestinationList extends ArrayList<String> {
	@Override
	public String toString() {
		return StringUtils.joinList(this, ", ");
	}
}
