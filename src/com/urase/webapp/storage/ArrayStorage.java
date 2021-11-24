/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                break;
            }
        }
    }

    void save(Resume r) {
        // находим первый null
        int index = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                continue;
            } else {
                index = i;
                break;
            }
        }
        // сохраняем в первый null новое резюме
        storage[index] = r;
    }

    Resume get(String uuid) {
        // проверяем, есть ли такое резюме, иначе возвращаем null
        Resume x = null;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
            else if (uuid.equals(storage[i].toString())) {
                x = storage[i];
            }
            else {
                continue;
            }
        }
        return x;
    }

    void delete(String uuid) {
        // находим индекс удаляемого элемента
        int index = -1;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && uuid.equals(storage[i].toString())) {
                storage[i] = null;
                index = i;
                break;
            }
        }
        if (index == - 1) {
            System.out.println("Не найдено.");
            return;
        }
        else {
            // сдвигаем массив, чтобы убрать null
            for (int i = index; i < storage.length; i++) {
                if (storage[i + 1] != null) {
                    storage[i] = storage[i + 1];
                } else {
                    storage[i] = null;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        // находим индекс последнего элемента, не равного null
        int index = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                index = i;
                break;
            } else {
                continue;
            }
        }
        // составляем список размером индекс первого null
        Resume[] x = new Resume[index];
        for (int i = 0; i < index; i++) {
            x[i] = storage[i];
        }
        return x;
    }

    int size() {
        // находим индекс первого null - это и есть размер
        int index = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                index = i;
                break;
            } else {
                continue;
            }
        }
        return index;
    }
}

