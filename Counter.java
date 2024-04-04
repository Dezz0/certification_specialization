public class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        if (count > 0) {
            throw new IllegalStateException("Ресурс не был закрыт. Значение счетчика: " + count);
        }
    }
}
