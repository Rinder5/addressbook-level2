package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public Object[] values;
    private boolean isPrivate;
    public int hashCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        hashCode = trimmedAddress.hashCode();
        String[] addressSegments = trimmedAddress.split(", ");
        values[0] = new Block(addressSegments[0]);
        values[1] = new Street(addressSegments[1]);
        values[2] = new Unit(addressSegments[2]);
        values[3] = new PostalCode(addressSegments[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
    	String addressString = values[0].toString();
    	for (int i=1; i<values.length; i++){
            addressString += ", ";
            addressString += values[i].toString();
    	}
        return addressString;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.hashCode == ((Address) other).hashCode()); // state check
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
