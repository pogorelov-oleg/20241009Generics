package com.pogorelov.top.generics;

public class MyArrayList<E> {
    private Object[] data;
    private int size;
    private int capacity;

    /**
     * Конструктор принимает один параметр (задает capacity), выделяет память под массив (size = 0).
     *
     * @param capacity параметр типа int. Задает начальную емкость массива.
     */
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = new Object[capacity];
    }

    /**
     * Конструктор по умолчанию (без параметров). Выделяет память под массив на 10 элементов,
     * равных нулю (capacity = 10, size = 0).
     */
    public MyArrayList() {
        this(10);
    }

    /**
     * Добавляет новый элемент в конец массива. Если памяти не достаточно, увеличитивает емкость массива данных;
     *
     * @param e элемент, который нужно добавить.
     */
    public void pushBack(E e) {
        ensureCapacity();
        this.data[this.size] = e;
        this.size++;
    }

    /**
     * Удоляет первый элемент массива.
     */
    public void popFront() {
        Object[] temp = new Object[this.capacity];
        System.arraycopy(this.data, 1, temp, 0, this.size - 1);
        this.data = temp;
        this.size--;
    }

    /**
     * Добавляет новый елемент в начало массива.
     *
     * @param e элемент, который нужно добавить.
     */
    public void pushFront(E e) {
        ensureCapacity();
        Object[] temp = new Object[this.capacity];
        temp[0] = e;
        System.arraycopy(this.data, 0, temp, 1, this.size);
        this.data = temp;
        this.size++;
    }

    /**
     * Вставляет новый элемент в массив по указанному индексу, с проверкой на выход за пределы массива.
     *
     * @param index индекс массива, куда нужно вставить элемент.
     * @param e     элемент, который нужно добавить.
     */
    public void insert(int index, E e) {
        if (index >= this.size)
            throw new ArrayIndexOutOfBoundsException("Index: " + index + " находится за пределами массива");
        ensureCapacity();
        Object[] temp = new Object[this.capacity];
        System.arraycopy(this.data, 0, temp, 0, index);
        temp[index] = e;
        System.arraycopy(this.data, index, temp, index + 1, this.size - index);
        this.data = temp;
        this.size++;
    }

    /**
     * Удаляет один элемент по указанному индексу, с проверкой на выход за пределы массива.
     *
     * @param index индекс элемента, который нужно удалить.
     */
    public void removeAt(int index) {
        if (index >= this.size)
            throw new ArrayIndexOutOfBoundsException("Index: " + index + " находится за пределами массива");
        Object[] temp = new Object[this.capacity];
        System.arraycopy(this.data, 0, temp, 0, index);
        System.arraycopy(this.data, index + 1, temp, index, this.size - index - 1);
        this.data = temp;
        this.size--;
    }

    /**
     * Удаляет один элемент, значение которого совпадает со значением переданного параметра.
     *
     * @param e элемент, который нужно удалить.
     */
    public void remove(E e) {
        int index = indexOf(e);
        if (index != -1) {
            removeAt(index);
        } else
            throw new IllegalArgumentException("Вы пытаетесь удалить несуществующий элемент");
    }

    /**
     * Удаляет все элементы, значения которых совпадают со значением переданного параметра.
     *
     * @param e элемент, который нужно удалить.
     */
    public void removeAll(E e) {
        while (this.indexOf(e) != -1) {
            this.remove(e);
        }
    }

    /**
     * Удаляет последний элемент из массива.
     */
    public void popBack() {
        this.data[this.size - 1] = null;
        this.size--;
    }

    /**
     * Обнуляет массив – всем элементам массива по
     * индексам от 0 до size-1 присваивается значение null, полю size
     * присваивается значение 0.
     */
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.data[i] = null;
        }
        this.size = 0;
    }

    /**
     * Линейный поиск слева направо первого вхождения в массив указанного значения.
     *
     * @param e элемент, который нужно найти.
     * @return индекс найденного элемента (если ничего не найдено, возвращает -1).
     */
    public int indexOf(E e) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (data[i] == e) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * Проверяет, достаточно ли резерва памяти для хранения указанного в параметре количества элементов.
     * Если значение параметра меньше текущего capacity, то ничего не происходит. Если значение параметра больше
     * текущего capacity, то массив пересоздается, памяти выделяется в 1,5 раза + 1 элемент больше.
     * Существующие элементы переносятся в новый массив.
     */
    private void ensureCapacity() {
        if (this.size >= this.capacity) {
            this.capacity = (int) (this.capacity * 1.5 + 1);
            Object[] temp = new Object[this.capacity];
            System.arraycopy(this.data, 0, temp, 0, this.data.length);
            this.data = temp;
        }
    }

    /**
     * @return возвращает размер массива.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @return возвращает строковое представление элементов массива через пробел. Если массив пустой, возвращает null
     */
    @Override
    public String toString() {
        if (this.size == 0)

            return null;
        else {
            StringBuilder sb = new StringBuilder();
            for (Object element : this.data)
                if (element != null)
                    sb.append(element).append(" ");
            sb.deleteCharAt(sb.length() - 1); //удаляю последний ненужный пробел

            return sb.toString();
        }
    }
}
