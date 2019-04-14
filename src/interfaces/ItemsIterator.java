package interfaces;

import receiptsystem.StoreItem;

// Check this is used
public interface ItemsIterator {
	boolean hasNext();
	StoreItem next();
}
