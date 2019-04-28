package interfaces;

import receiptsystem.StoreItem;

public interface ItemsIterator {
	boolean hasNext();
	StoreItem next();
}
