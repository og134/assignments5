import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilterIterator<T> implements Iterator<T> {
	Iterator<T> iterator;
	Iterable<Filter<T>> filters;
	T next;
	
	public FilterIterator(Iterable<T> elements, Iterable<Filter<T>> filters) {
		this.filters = filters;
		this.iterator = elements.iterator();
		this.next = next();
		if(this.next == null)
			throw new NoSuchElementException("yea...sure...lets give conditions without meaning, why the hell not?");
	}
	
	@Override
	public boolean hasNext() {
		return this.next != null;

	}

	@Override
	public T next() {
		//write in two loops
		T elem = null;
		boolean found = false;
		while(!found) {
			if (this.iterator.hasNext())
				elem = this.iterator.next();
			else
				return null;
			Iterator<Filter<T>> iter = this.filters.iterator();
			boolean run = true;
			while (iter.hasNext() & run) {
				Filter<T> condition = iter.next();
				if (!condition.accept(elem))
					run = false;

			}
			if(!iter.hasNext()){
				found = true;
				this.next = elem;
			}
		}

		return elem;
	}
}
