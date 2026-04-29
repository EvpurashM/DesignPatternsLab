package behavioral;

interface Iterator { boolean hasNext(); Object next(); }
interface Container { Iterator getIterator(); }

class NameRepository implements Container {
    public String names[] = {"Іван", "Марія"};
    public Iterator getIterator() { return new NameIterator(); }
    
    private class NameIterator implements Iterator {
        int index;
        public boolean hasNext() { return index < names.length; }
        public Object next() { return hasNext() ? names[index++] : null; }
    }
}

public class IteratorPattern {
    public static void run() {
        NameRepository namesRepository = new NameRepository();
        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            System.out.println("Ім'я: " + iter.next());
        }
    }
}