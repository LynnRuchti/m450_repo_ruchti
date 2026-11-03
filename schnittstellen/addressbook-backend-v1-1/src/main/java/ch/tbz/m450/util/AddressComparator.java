package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ch.tbz.m450.util.HelperFunc.compareIfBothPresent;

public class AddressComparator implements Comparator<Address> {

    public List<Address> sort(List<Address> addresses) {
        List<Address> result = new ArrayList<>(addresses);
        for (int i = 1; i < result.size(); i++) {
            Address key = result.get(i);
            int j = i - 1;
            while (j >= 0 && compare(result.get(j), key) > 0) {
                result.set(j + 1, result.get(j));
                j--;
            }
            result.set(j + 1, key);
        }
        return result;
    }

    @Override
    public int compare(Address a1, Address a2) {

        // Compare by firstname, lastname, phonenumber and registration date
        // (in that order), but only if both have the data set.
        int result = compareIfBothPresent(a1.getFirstname(), a2.getFirstname());
        if (result != 0) return result;

        result = compareIfBothPresent(a1.getLastname(), a2.getLastname());
        if (result != 0) return result;

        result = compareIfBothPresent(a1.getPhonenumber(), a2.getPhonenumber());
        if (result != 0) return result;

        result = compareIfBothPresent(a1.getRegistrationDate(), a2.getRegistrationDate());
        return result;
    }
}