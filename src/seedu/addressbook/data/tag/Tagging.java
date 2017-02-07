package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
    
    private Person person;
    private Tag tag;
    private boolean isAdded; //else isDeleted
    
    public Tagging(Person person, Tag tag, boolean isAdded){
        this.person = person;
        this.tag = tag;
        this.isAdded = isAdded;
    }
    
    public Person getPerson(){
        return person;
    }
    
    public Tag getTag(){
        return tag;
    }
    
    public boolean getIsAdded(){
        return isAdded;
    }
}
