// --== CS400 Project One File Header ==--
// Name: Amit Diggavi
// CSL Username: diggavi
// Email: diggavi@wisc.edu
// Lecture #:  003 @2:25pm
// Notes to Grader: This is the other class I made for key value pairs

import java.util.LinkedList;

public class Pairs<KeyType, ValueType> {
    // this class is basically for organization, so it is easier to understand class HashtableMap.java
    KeyType key;
    ValueType val;



    public Pairs(KeyType key, ValueType val) // constructor
    {
        this.key = key;
        this.val = val;
    }

    public ValueType getVal() { // retrieves value
        return val;
    }

    public KeyType getKey() { // retrieves key
        return key;
    }

    public void changeValue(ValueType value) {
        this.val = value;
    }

    public void changeKey(KeyType key) {
        this.key = key;
    }


    //public boolean put2 (KeyType key, ValueType val, LinkedList<Pairs<KeyType, ValueType>>[] array) {
       // int existing = Math.abs(this.key.hashCode()) % capacity;
      //  Pairs<KeyType, ValueType> pairs = new Pairs<>(key, val);

      //  if(array[existing].isEmpty()) // the first thing to check is if the existing linked list empty
     //   {
    //       array[existing].add(pairs); // so here we just add to empty list to make it fuller
      //      size_array++; // add size since the pair was added
          // return true;
      //  }
      //  else if (array[existing] == null) // checks if there anything in that particular index, if not then we add.
      //  {
        //    LinkedList<Pairs<KeyType, ValueType>> new_arr = new LinkedList<>();
         //   new_arr.add(pairs); // Pairs are being added into this array which is equal to null at the moment.
         //   array[existing] = new_arr; // we equal the original array's index to the new_arr
          //  size_array++; // since new pair was added we need to increase size.
          //  return true; // finally, return true because we have successfully added a new value.        }
      //  }
       // else
          //  return false; // flase is returned because not successuflly stored.

    //   if(key == null)
    //        {
    //            throw new NoSuchElementException(key + "does not exist");
    //        }
    //
    //        int existing = Math.abs(this.key.hashCode()) % capacity;
    //
    //        if(hashArray[existing] != null) //
    //        {
    //            for(int i = 0; i < hashArray[existing].size(); i++) // loops through to find the value
    //            {
    //                if(hashArray[existing].get(i).getKey().equals(key))
    //                {
    //                    val = hashArray[existing].get(i).getVal();
    //                    break;
    //                }
    //            }
    //            return val; // returns value
    //        }
    //
    //        return null; // if the value was not found, null is returned

}