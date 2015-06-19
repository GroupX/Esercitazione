package it.unibs.ing.fp.groupX.myutil;

import java.util.Iterator;

public class BasicIterator<E> implements Iterator<E>{

	int actIndex = 0;
	BasicIterable<E> bI;
	
	public BasicIterator(BasicIterable<E> obj) {
		bI = obj;
	}
	
	@Override
	public boolean hasNext() {
		if (actIndex < bI.size())
			return true;
		else
			return false;
	}

	@Override
	public E next() {
		if (hasNext())
		{
			return bI.get(actIndex++);
		}
		else
		{
			return null;
		}
	}

}
