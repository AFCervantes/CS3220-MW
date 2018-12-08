package models;

import java.util.ArrayList;
import java.util.List;

public class GuestBookBean {

    List<GuestBookEntry> entries;

    public GuestBookBean()
    {
        entries = new ArrayList<GuestBookEntry>();
    }

    public void setAddEntry( String dummy )
    {
        GuestBookEntry entry = new GuestBookEntry();
        entries.add( entry );
    }

    public GuestBookEntry getLastEntry()
    {
        return entries.get( entries.size() - 1 );
    }

    public List<GuestBookEntry> getEntries()
    {
        return entries;
    }

    public void setEntries( List<GuestBookEntry> entries )
    {
        this.entries = entries;
    }

}