public class MyLinkedList<E>
{
	Node<E> head;
	int numNode;
	
	public MyLinkedList()
	{
	}
	
	public void add(int index, E element)
	{
		if (index < 0 || index > numNode)
		{
			System.err.println("vị trí ngoài khoảng cho phép");
			return;
		}
		if (index == 0)
		{
			Node<E> oldHead = head;
			head = new Node<>(element, oldHead);
		}
		else
		{
			Node<E> prevNode = getNode(index - 1);
			Node<E> currNode = getNode(index);
			Node<E> newNode = new Node<>(element, currNode);
			prevNode.setNext(newNode);
		}
		numNode++;
	}
	
	private Node<E> getNode(int index)
	{
		int i = 0;
		Node<E> current = head;
		while (current != null)
		{
			if (index == i)
			{
				return current;
			}
			current = current.getNext();
			i++;
		}
		return null;
	}
	
	public void addFirst(E element)
	{
		add(0, element);
	}
	
	public void addLast(E element)
	{
		add(numNode, element);
	}
	
	public E remove(int index)
	{
		if (index < 0 || index > numNode)
		{
			System.err.println("vị trí ngoài khoảng cho phép");
			return null;
		}
		Node<E> oldNode = getNode(index);
		if (index == 0)
		{
			if (numNode == 1)
			{
				head = null;
			}
			else
			{
				Node<E> nextNode = getNode(index + 1);
				head = nextNode;
			}
		}
		else if (index == numNode - 1)
		{
			Node<E> prevNode = getNode(index - 1);
			prevNode.setNext(null);
		}
		else
		{
			Node<E> prevNode = getNode(index - 1);
			Node<E> nextNode = getNode(index + 1);
			prevNode.setNext(nextNode);
		}
		numNode--;
		return oldNode.getData();
	}
	
	public boolean remove(E element)
	{
		remove(indexOf(element));
		return true;
	}
	
	public int size()
	{
		return numNode;
	}
	
	public Object clone()
	{
		return null;
	}
	
	public boolean contains(E element)
	{
		return indexOf(element) >= 0;
	}
	
	public int indexOf(E element)
	{
		Node<E> current = head;
		int i = 0;
		while (current != null)
		{
			if (current.getData().equals(element))
			{
				return i;
			}
			current = current.getNext();
			i++;
		}
		return -1;
	}
	
	public boolean add(E element)
	{
		addLast(element);
		return true;
	}
	
	public void ensureCapacity(int minCapacity)
	{
	
	}
	
	public E get(int index)
	{
		return getNode(index).getData();
	}
	
	public E getFirst()
	{
		return getNode(0).getData();
	}
	
	public E getLast()
	{
		return getNode(numNode - 1).getData();
	}
	
	public void clear()
	{
		head.setNext(null);
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder("[");
		Node<E> current = head;
		while (current != null)
		{
			result.append(current.getData());
			if (current.getNext() != null)
			{
				result.append(", ");
			}
			current = current.getNext();
		}
		result.append("]");
		return result.toString();
	}
}
