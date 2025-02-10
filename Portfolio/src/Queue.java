import java.util.ArrayList;

public class Queue {
    // Array
    ArrayList<Person> queue;

    // Constructor
    Queue() {
        queue = new ArrayList<>();
    }

    // Methods
    // Add person to array
    public void addToQueue(Person person) {
        queue.add(person);
    }

    // Partition
    int agePartition(ArrayList<Person> arr, int high, int low) {
        Person pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr.get(j).getAge() >= pivot.getAge()) {
                i++;

                Person temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        Person temp = arr.get(i+1);
        arr.set(i+1, arr.get(high));
        arr.set(high, temp);

        return i+1;
    }

    int namePartition(ArrayList<Person> arr, int high, int low) {
        Person pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr.get(j).getLastName().compareTo(pivot.getLastName()) >= 0) {
                i++;

                Person temp = arr.get(high);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        Person temp = arr.get(i+1);
        arr.set(i+1, arr.get(high));
        arr.set(high, temp);

        return i+1;
    }

    // choose sorting 
    public void startSort(int seclect, int high, int low) {
        ageQuickSort(queue, high, low);
    }

    public void startSort(String seclect, int high, int low) {
        nameQuickSort(queue, high, low);
    }

    // Quicksort
    private void ageQuickSort(ArrayList<Person> arr, int high, int low) {
        if (low < high) {
            int parIndex = agePartition(arr, high, low);

            ageQuickSort(arr, parIndex-1, low);
            ageQuickSort(arr, high, parIndex+1);
        }
    }

    private void nameQuickSort(ArrayList<Person> arr, int high, int low) {
        if (low < high) {
            int parIndex = namePartition(arr, high, low);

            nameQuickSort(arr, parIndex-1, low);
            nameQuickSort(arr, high, parIndex+1);
        }
    }

    // To String
    @Override
    public String toString() {
        String myReturnString = "Results of query:";
        for (int i = 0; i < 5; i++) {
            myReturnString = myReturnString + "\n\t" + queue.get(i).getFirstName() + " " + queue.get(i).getLastName() + " " + queue.get(i).getAge();
        }
        return myReturnString;
    }
}
