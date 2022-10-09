import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableMapADTPlaceHolder<KeyType, ValueType> implements IterableMapADT<KeyType, ValueType> {

    ArrayList<Book> book1 = new ArrayList<>();


    @Override @SuppressWarnings("unchecked")
    public Iterator<ValueType> iterator() {
        Book book2 = new Book("Frankenstein", "Mary Shelley", "54321");

        // book1.add(book2);
        return (Iterator<ValueType>) book1.iterator(); // casting because it was not letting me do this otherwise.

    }
    @Override
    public boolean put(KeyType key, ValueType value) {
        Book book2 = new Book ("Frankenstein", "Mary Shelley", "54321");// Later, replace with KeyType and ValueType
        book1.add(book2);
        return true;

    }

    @Override @SuppressWarnings("unchecked")
    public ValueType get(KeyType key) throws NoSuchElementException {
        Book book2 = new Book("Frankenstein", "Mary Shelley", "1234567");
        if(key.equals(0)) {
            return (ValueType) book1.get(0);
        }

        throw new NoSuchElementException(key + " does not exist.");


    }

    @Override
    public ValueType remove(KeyType key) {

        book1.remove(key);

        return null;
    }

    @Override
    public boolean containsKey(KeyType key) {

        Book book3 = book1.get(0);
        return book3.getISBN13().equals("54321");
    }

    @Override
    public int size() {
        return book1.size();
    }

    @Override
    public void clear() {
        book1.clear();
    }

}
